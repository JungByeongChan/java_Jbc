-- 영화 오펜하이머에 출연한 감독과 배우들을 조회하는 쿼리
select mo_title as '영화제목',fp_name as '영화인', ro_role as '역할'
from film_persion 
join role on fp_num = ro_fp_num 
join movie on mo_num = ro_mo_num 
where mo_title = '오펜하이머';

-- 영화 오펜하이머 기본 정보를 조회하는 쿼리
select
	mo_title as 제목,
    mo_title_eng as '제목(영문)',
    mo_opening_date as 개봉일,
    mo_running_time as 런닝타임,
    mo_plot as 줄거리,
    mo_ag_name as 연령제한,
    concat(mo_reservation_rate,'%') as 예매률
from
	movie
where
    mo_title = '오펜하이머';
    
-- 영화 오펜하이머의 트레일러와 스틸컷 파일의 개수를 조회하는 쿼리
select mo_title as '영화제목',fi_state as '타입',count(*) as '개수' 
from file 
join movie_file on mf_fi_num = fi_num 
join movie on mf_mo_num = mo_num 
where mo_title = '오펜하이머' 
group by fi_state;

-- abc회원의 예매 내역을 조회하는 쿼리(영화명, 시간, 좌석명)
SELECT 
    mo_title as 영화제목, ms_start_time as 상영시간, se_name as 좌석
FROM
    reservation
    join
    reservation_list on rl_rv_num = rv_num
    join
    seat on rl_se_num = se_num
    join
    movie_schedule on ms_num = rv_ms_num
    join
    movie on mo_num = ms_mo_num
where rv_me_id = 'abc123';

-- abc회원의 예매 내역을 조회하는 쿼리(영화명, 시간, 좌석명 성인 X명, 청소년 X명)
SELECT 
    mo_title as 영화제목, ms_start_time as 상영시간,
    sum(rv_adult) as 성인수, sum(rv_teenager) as 청소년수
FROM
    reservation
    join
    movie_schedule on ms_num = rv_ms_num
    join
    movie on mo_num = ms_mo_num
where rv_me_id = 'abc123'
group by rv_num;

-- CGV강남 영화관에서 콘크리트 유토피아 20:50에 예매 가능한 좌석을 조회하는 쿼리 (outer join)
SELECT 
   se_name 
FROM
	seat
    join
    screen on se_sc_num = sc_num
    join
    movie_schedule on ms_sc_num = sc_num
    
    where ms_num = 8 and se_num not in(
    select rl_se_num from reservation
    join reservation_list on rl_rv_num = rv_num
    where rv_ms_num = 8
    );
    
    -- CGV강남 영화관에서 콘크리트 유토피아 20:50에 예매 가능한 좌석을 조회하는 쿼리 (outer join)
SELECT 
   se_name as '좌석번호', 
   case 
		when rl_se_num is null then 'O'
		else 'X' 
		end as '예약 가능 여부'
FROM
	seat
    join
    screen on se_sc_num = sc_num
    join
    movie_schedule on ms_sc_num = sc_num
    left join -- 예약과 예약 리스트를 join하는게 아니라 예약 리스트와 좌석을 join
    reservation_list on se_num = rl_se_num
    
    where ms_num = 8;
    
-- 'abc123' 회원이 관람했던 영화목록을 조회하는 쿼리

select mo_title as '관람 영화' from reservation
join movie_schedule on ms_num = rv_ms_num
join movie on ms_mo_num = mo_num
where rv_me_id = 'abc123' and now() >= concat(ms_date, ' ', ms_start_time)
group by mo_num; -- 같은 영화를 여러번 봐도 관람 영화 목록에는 1번만 출력
    
-- 예약 가능한 모든 상영 영화 정보를 조회하는 쿼리

SELECT distinct
  mo_title as 영화제목, ms_date as 상영일, ms_start_time as 상영시간,
  mo_ag_name as 연령제한
FROM
    movie_schedule
    join
    movie on mo_num = ms_mo_num
    
    where now()<concat(ms_date,' ', ms_start_time) and ms_possible_seat > 0;
    
    
-- cgv에서 이벤트로 한 영화를 여러번 회원 중에 가장 많이 본 회원 3명을뽑을고한다.
-- 각 영화를 각 회원이 몇번봤는지 조회하는 쿼리
 SELECT 
    MO_TITLE AS 영화, RV_ME_ID AS 아이디, COUNT(RV_NUM) AS 회수
FROM
    RESERVATION
        JOIN
    MOVIE_SCHEDULE ON MS_NUM = RV_MS_NUM
        JOIN
    MOVIE ON MS_MO_NUM = MO_NUM
WHERE
    NOW() >= CONCAT(MS_DATE, ' ', MS_START_TIME)
GROUP BY RV_ME_ID , MS_MO_NUM;

-- 회원들 중 금액 사용이 가장 많은 3명의 회원을 조회하는 쿼리 
SELECT 
    ME_ID AS 아이디,
    IFNULL(SUM(CASE
                WHEN NOW() >= CONCAT(MS_DATE, ' ', MS_START_TIME) THEN RV_PRICE
                ELSE 0
            END),
            0) AS 누적금액
FROM
    RESERVATION
        JOIN
    MOVIE_SCHEDULE ON RV_MS_NUM = MS_NUM
        RIGHT JOIN
    MEMBER ON RV_ME_ID = ME_ID
GROUP BY RV_ME_ID
ORDER BY 누적금액 DESC
LIMIT 3;

SELECT * FROM (
	SELECT 
		ME_ID AS 아이디,
		누적금액,
		RANK() OVER(ORDER BY 누적금액 DESC) AS 순위
	FROM
		(SELECT *, IFNULL(SUM(CASE
					WHEN NOW() >= CONCAT(MS_DATE, ' ', MS_START_TIME) THEN RV_PRICE
					ELSE 0
				END),
				0) AS 누적금액 FROM
		RESERVATION
			JOIN
		MOVIE_SCHEDULE ON RV_MS_NUM = MS_NUM
			RIGHT JOIN
		MEMBER ON RV_ME_ID = ME_ID
		GROUP BY RV_ME_ID
		) AS A
	) AS B
WHERE 순위 <= 3;

-- 영화인별로 배우로 참여한 영화 개수를 조회하는 쿼리
select fp_name as 영화인, ifnull(count(ro_num),0) as '참여영화수(배우)' from film_persion
	left join
    (select * from role where ro_role = '배우') as role2 on ro_fp_num = fp_num
    group by fp_num;

-- 각 스케쥴 별 예약한 좌석 수를 조회하는 쿼리
select mo_title as 영화, ms_date as 상영일, ms_start_time as 상영시간, sc_total_seat - ms_possible_seat as 예약좌석수
from movie_schedule join screen on ms_sc_num = sc_num
join movie on mo_num = ms_mo_num;

-- 영화관별 상영 영화 목록을 보여주는 쿼리
select th_name as 영화관, mo_title as 영화-- sc_name as 상영관 
from movie_schedule 
join screen on sc_num = ms_sc_num -- 영화관과 연결을 위해 먼저 상영관과 연결
join theater on th_num = sc_th_num -- 영화관명을 조회하기 위해 영화관 연결
join movie on ms_mo_num = mo_num -- 영화 제목을 조회하기 위해 영화관 연결
where now() < concat(ms_date, ' ', ms_start_time) 
group by th_num, ms_mo_num;

-- 오펜하이머를 상영하는 영화관을 조회하는 쿼리
select * 
from movie_schedule
join screen on sc_num = ms_sc_num
join theater on th_num = sc_th_num
join movie on ms_mo_num = mo_num
where now() < concat(ms_date, ' ', ms_start_time) and mo_title = '오펜하이머'
group by th_num, ms_mo_num;