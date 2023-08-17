-- 도서 상태 샘플 데이터를 추가
insert into book_state(bs_desc) 
values('예약가능'),('예약 중'),('도서 상태에 의한 예약 불가능'),('대출 가능'),('대출 중'),('도서 생테에 의한 대출 불가능');

-- 도서 샘플 데이터를 추가
-- 101.1ABC12 자바의 정석 남궁성 도우출판 , 일반도서(대출/예약이 가능한 도서)
-- 103.987DD Do it! 점프 투 파이썬 박응용 이지스퍼블리싱 , 예약 불가능한 도서
-- 500.ABC123 해리포터와 마법사의 돌 1 J.K. 롤링저자/강동혁 엮은이 문화수첩, 일반도서
insert into book(bo_num,bo_type,bo_title,bo_publisher,bo_author,bo_possible_loan,bo_possible_reservation)
values('101.1ABC12', '코딩', '자바의 정석', '도우출판', '저자 : 남궁성' , 4, 1),
('103.987DD', '코딩', 'Do it! 점프 투 파이썬' , '이지스퍼블리싱', '저자 : 박응용' , 4, 3),
('500.ABC123', '외국 소설', '해리포터와 마법사의 돌 1', '도우출판', '저자 : J.K. 롤링/엮은이 강동혁' , 4, 1);

-- 회원 샘플 데이터를 추가
insert into member(me_id,me_pw,me_phone,me_birthday,me_authority)
values('admin','admin','011-1234-5678','2000-01-01','admin'),
('qwe123','qwe123','010-1111-2222','2002-02-02','user');

-- 예약 가능한 도서를 조회하는 쿼리
SELECT 
    bo_title AS 제목, bo_possible_reservation AS 예약가능
FROM
    book
        JOIN
    book_state ON bs_num = bo_possible_reservation
WHERE
    bo_possible_reservation = 1;

-- qwe123회원이 자바의 정석을 예약했을 때 적용해야 하는 쿼리
insert into reservation(re_reservation_date,re_me_id,re_bo_num) 
select date_format(now(),'%y-%m-%d'), 'qwe123', bo_num from book where bo_title = '자바의 정석';
UPDATE book 
SET 
    bo_possible_reservation = (SELECT 
            bs_num
        FROM
            book_state
        WHERE
            bs_desc = '예약 중')
WHERE
    bo_num = '101.1ABC12'; -- update 하는 테이블이 book인데 book에서 조회하여 값을 가져올 수 없다.

-- 대출 가능한 도서를 조회하는 쿼리
SELECT 
    *
FROM
    book
WHERE
    bo_possible_loan = (SELECT 
            bs_num
        FROM
            book_state
        WHERE
            bs_desc = '대출 가능')
        AND 
        bo_possible_reservation in(select bs_num from book_state where bs_desc != '예약 중');
        
-- qwe123회원이 대출 가능한 도서를 조회하는 쿼리
select * from book left join reservation on re_bo_num = bo_num where bo_possible_loan = (select bs_num from book_state where bs_desc = '대출 가능')
and (re_num is null or re_me_id = 'qwe123');

-- qwe123회원이 예약한 자바의 정석을 대출했을 때 적용해야하는 쿼리
insert into loan(lo_date,lo_me_id,lo_bo_num,lo_expected_date) 
select date_format(now(),'%y-%m-%d'), 'qwe123', bo_num, date_format(date_add(now(), interval 14 day), '%y-%m-%d') from book where bo_title = '자바의 정석';
-- 예약 테이블에 데이터를 삭제
DELETE FROM reservation 
WHERE
    re_me_id = 'qwe123'
    AND re_bo_num = (SELECT 
        bo_num
    FROM
        book
    
    WHERE
        bo_title = '자바의 정석');
-- 도서 상태를 수정

UPDATE book 
SET 
    bo_possible_loan = (SELECT 
            bs_num
        FROM
            book_state
        WHERE
            bs_desc = '대출 중'),
	bo_possible_reservation =  (SELECT 
            bs_num
        FROM
            book_state
        WHERE
            bs_desc = '예약가능')
WHERE
       bo_num = '101.1ABC12';
--  회원이 대출한 도서 수 증가
update member
set me_book_count = me_book_count +1
where me_id = 'qwe123';


-- qwe123 회원이 현재 대출한 도서를 조회하는 쿼리
SELECT 
    *
FROM
    book
        JOIN
    loan ON lo_bo_num = bo_num
where
	lo_me_id = 'qwe123' and lo_return_date is null;
    
-- qwe123회원이 자바의 정석을 반납했을 때 필요한 쿼리
-- 대출테이블에 반납일을 수정
update loan
set
	lo_return_date = date_format(now(), '%y-%m-%d')
where
	lo_me_id = 'qwe123' and lo_bo_num = select bo_num from book where bo_title = '자바의 정석');
    

-- 도서 테이블에 해당 도서의 도서 상태를 수정
update book
set
	bo_possible_loan = (select bs_num from book_state where bs_desc = '대출 가능')
where
	bo_num ='101.1ABC12';
-- 회원이 대출한 도서 수를 감소
update member
set me_book_count = me_book_count - 1
where me_id = 'qwe123';
-- 연체일을 계산해서 회원 테이블을 수정
update member
set me_total_overdue = me_total_overdue + (select case when datediff(lo_return_date, lo_date) < 1 then 0
else datediff(lo_return_date, lo_expected_date) end as 연체일

from loan where lo_me_id = 'qwe123' and lo_bo_num = '101.1ABC12')
where me_id = 'qwe123';

-- 회원이 대출한 모든 도서가 반납됐을 때 연체일이 있으면 다음날부터 연체 적용이 되도록 수정
UPDATE member 
SET 
    me_apply_overdue = (SELECT 
            CASE
                    WHEN
                        me_book_count = 0
                            AND me_total_overdue != 0
                    THEN
                        DATE_FORMAT(DATE_ADD(NOW(),
                                    INTERVAL me_total_overdue DAY),
                                '%y-%m-%d')
                    ELSE NULL
                END AS T
        FROM
            (select * from member) as tmp -- 서브쿼리이용시 같은이름일경우 문제가 발생할수도 있기 때문에 이름만 변경하면 정상작동
        WHERE
            me_id = 'qwe123')
WHERE
    me_id = 'qwe123';

-- 각 회원들의 대출이 불가능한 기간을 조회하는 쿼리 / 대출이 가능한 회원은 대출 가능으로 표시하고
-- 대출이 불가능한 회원은 언제까지인지를 표시 하도록 작성

select me_id as 아이디,
	case
		when me_apply_overdue is null then '대출가능'
        else me_apply_overdue
	end as 대출불가일
from member;

-- 각 도서별 대출 회수를 조회하는 쿼리
select bo_title as 도서명, count(lo_num) as 대출회수 from book
	left join loan on lo_bo_num = bo_num
    group by bo_num;
    

-- 회원별 연체 회수를 조회하는 쿼리
select
	me_id, count(lo_expected_date < lo_return_date) as 연체회수
from
	member
		left join
	loan on lo_me_id = me_id
group by me_id;

-- 도서를 가장 많이 대출한 회원을 조회하는 쿼리, 대출수가 같은 경우 아이디순으로 정렬
select me_id as 아이디, count(lo_num) as 대출도서 수
from member left join loan on lo_me_id = me_id
group by me_id
order by 대출도서수 desc;