/*
프로시저
- 일럼의 쿼리를 마치 하나의 함수처럼 실행하기 위한 쿼리의 집합
- 예시
	- 대학생 학번을 생성하기 위한 프로시저 : 입학년도, 학과번호를 이용하여 학번을 생성할 수 있다.
    
		함수			프로시저
매개변수	여러개(입력)	여러개(입력|출력|입출력)
리턴값	1개(필수)		여러개, 선택(없을수도있다는의미)
select문	사용 가능		사용 불가능	
처리장소	클라이언트		서버

프로시저 정의
Delimiter// -- 문자의 끝을 //로 인식하게 해줌
create procedure 프로시져명(
[ (IN | OUT | Inout) 매개변수명 타입

] -- 매개변수가 없을수도 있기때문에 생략이 가능하다는 의미로 [] 사용
)
begin
-- 프로시저 코드 구현
-- 변수 선언
	Declear 변수명 타입;
    Declear 변수명 타입 Default 초기값;
    -- 변수에 값을 수정
    set 변수명 = 값;
    -- 조건문 : case when의 경우
    case
		when 조건식 then
			실행문1;
		when 조건식2 then
			실행문2;
		else
			실행문3;
	end;
    -- 조건문 : IF
    if 조건식 then
		실행문1
	else
		실행문2
	end if; 
end //
Delimiter;

프로시저 호출
Call 프로시저명(매개변수들);

*/
-- 모든 영화 예매율을 업데이트하는 프로시저
drop procedure if exists update_reservation_rate;
delimiter //
create procedure update_reservation_rate()
begin
	declare _total_seat int;
	declare done int default 0; 
	declare _mo_num int; 
    declare _movie_seat int;
	
	declare cur cursor for
		select * from movie;
	declare continue handler for not found set done = 1;
	set _total_seat = (
    select
		sum(rv_adult + rv_teenager)
	from
		reservation
    );
    
	 open cur;
		movie_loop : loop
			-- fetch : cur에서 한 행씩 꺼내는 작업을 함
			-- done이 자동으로 1이 됨(왜냐면 16번째줄에서 설정했기 때문)
			fetch cur into _num;
			if done then
				leave movie_loop;
			end if;
			-- 하고싶은 작업
			set _movie_seat = ();
		end loop;
		
		-- cursor를 닫음
		close cur;
	-- 영화 예매를 이용하여 예매 좌석수별로 예매율을 계산 => A영화 예매율 : A영화 예매 좌석수 /예매중인 전체 예매 좌석수 * 100
end //
delimiter ;
-- set _num = (select yy from xx);
-- insert into A(X,C,V) values(1,2,3);

-- where a = b;
drop procedure if exists reservation_movie;
-- 영화를 예매하는 프로시저
Delimiter //
create procedure reservation_movie(
In _ms_num int, -- 스케쥴 번호
In _id varchar(15),-- 예약 아이디명
in _adult_count int,-- 성인수
in _teenager_count int,-- 청소년 수
in _seat_list text -- 좌석번호를 json 형태의 문자열로


)
begin
	declare _adult_total_price int default 0;
    declare _teenager_total_price int default 0;
    declare _total_price int default 0;
    declare _is_discount char(1);
    
    declare done int default 0;
    
    declare _se_num int;
    declare _pr_num int;
    declare _rv_num varchar(20);
    declare seat_name varchar(4);
    declare _possible_seat int;
    /*
    cursor
    - sql 결과 집합을 가르키는 데이터 타입. 프로시저나 함수 내에서 사용
    결과를 반복처리할 때 사용
    - 결과를 한번에 가져오는 것이 아닌, 하나씩 가져와서 처리
    */
    -- 좌석 리스트를 cursor로 선언
    declare cur cursor for
		select *
        from json_table(_seat_list, '$[*]'
        columns(seat_name varchar(4) path '$.seat_name')
        ) as A;
	declare continue handler for not found set done = 1;
    
    -- 예약번호 생성 -- 202308091614MS008001
		-- now() : YYYY -- MM -- DD HH:MM:SS => YYYYMMDDHHMM
    set _rv_num = concat(
    date_format(now(), '%Y%m%d%H%i'),
    'MS',lpad(_ms_num, 3,0),lpad((select count(*)+1 from reservation where rv_ms_num = _ms_num),3,0)
    );
    
    -- 전체 요금을 계산 : 성인수, 청소년수, 조조할인 여부를 알면 => 청소년 총 요금, 성인 총 요금을 계산
 
    -- 예약 테이블에 정보를 추가
    -- 조조할인이 적용되는지 여부를 _is_discount에 저장
    set _is_discount = (select ms_discount from movie_schedule where ms_num = _ms_num);
    if _is_discount = 'Y' then
		set _adult_total_price = (select pr_discount_price from price where pr_type='성인')*_adult_count;
        set _teenager_total_price = (select pr_discount_price from price where pr_type='청소년')*_teenager_count;
    else
		set _adult_total_price = (select pr_price from price where pr_type='성인')*_adult_count;
        set _teenager_total_price = (select pr_price from price where pr_type='청소년')*_teenager_count;
    end if;
    
    set _total_price = _adult_total_price + _teenager_total_price;
	-- 예약 테이블에 정보를 추가
    insert into reservation(rv_ms_num, rv_me_id, rv_adult, rv_teenager, rv_price)
    values(_rv_num, _ms_num, _id, _adult_count, _teenager_count, _total_price);
    -- 예약 리스트에 좌석 정보를 추가
    set _rv_num = (select max(rv_num) from reservation);
    -- cursor를 열고
    open cur;
    read_loop:loop
		fetch cur into seat_name;
        -- 반복을 멈추는 작업
        if done then
			leave read_loop;
		end if;
        -- 좌석정보를 이용하여 예약 리스트에 추가하는 작업
        -- 영화 스케쥴과 좌석을 가져옴
        set _se_num = (
        select se_num from seat 
        join screen on se_sc_num = sc_num
        join movie_schedule on ms_sc_num = sc_num
        where ms_num = _ms_num and se_name = seat_name
        );
        -- 예약좌석에 가격 번호를 연결하는데 있어서, 청소년 먼저하고, 성인을 하는것과
        -- 성인을 먼저하고 청소년을 먼저하는것은 중요하지 않음
        -- 성인먼저 좌석 순으로 배치하고, 이후에 청소년을 좌석순으로 배치
        -- 성인수가 0이 아니면 주어진 좌석은 성인 좌석 
        if _adult_total_count != 0 then 
			set _pr_num = (select pr_num from price where pr_type ='성인');
            set _adult_count = _adult_count -1;
		else
			set _pr_num = (select pr_num from price where pr_type = '청소년');
            set _teenager_count = _teenager_count -1;
		end if;
        insert into reservation_list(rl_rv_num, rl_se_num, rl_pr,num)
        values(_rv_num, _se_num, _pr,num);
	end loop;
	close cur;
    -- 영화 스케쥴에 예약 가능좌석을 업데이트
    set _possible_seat = (select sc_total_seat - sum(rv_adult + rv_teenager)
    from reservation 
    join movie_schedule on ms_num = rv_ms_num 
    join screen on ms_sc_num = sc_num 
    where rv_ms_num = _ms_num);
    update movie_schedule set ms_possible_seat = _possible_seat
    where ms_num = _ms_num;
    -- 모든 영화 예매율을 업데이트
	call update_reservation_rate();
    
end //
Delimiter ;
call reservation_movie(4, 'admin', 1, 1, '[{"seat_name" : "A1"},{"seat_name" : "A2"}]');
/*
{ "속성명" : 값, "속성명" : 값}
*/

