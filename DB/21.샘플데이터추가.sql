-- 관리자를 등록하는 작업
-- 아이디 : admin 비번 : admin 이름 : 관리자 번호 : 011-1111-2222 생일 : 2000 01 01
-- 권한 : admin
use cgv;



insert into member(me_id,me_pw,me_name,me_phone, me_birthday, me_authority)
values('admin','admin','관리자','011-1111-2222','2000-01-01','admin');

-- 관리자가 영화 오펜하이머를 등록하기전에 사전에 해야하는 작업을 쿼리로 작성
-- 영화를 등록하기 위해 연령제한 데이터를 추가 : 전체관람가, 12세관람가, 15세관람가, 청소년 관람불가, 제한상영가
insert into age values('전체관람과'),('12세관람가'),('15세관람가'),('청소년 관람불가'),('제한상영가');


-- 감독/배우를 등록하기 위해서 필요한 국가 데이터를 추가
-- 한국,미국,영국,일본 등
insert into country values('한국'),('일본'),('영국'),('미국'),('아일랜드');

-- 다른 데이터베이스 테이블에 있는 데이터를 가져와서 추가하는 쿼리
insert into country select country from sakila.country;


-- 영화를 등록하기 위해 필요한 장르 데이터를 추가
-- 드라마, 스릴러, 공포, 액션, 멜로, 코미디, SF, 어드벤쳐, 판타지, 번죄 등
insert into genre values('멜로'),('드라마'),('코미디'),('SF'),('어드벤쳐'),('액션'),('판타지'),('공포'),('범죄'),('전쟁'),('스릴러');

-- 관리자가 영화 오펜하이머를 등록하는 작업을 쿼리로 작성
-- 메인포스터를 먼저 등록 : 오펜하이머_메인포스터.JPG
insert into file(fi_name, fi_state) values('오펜하이머_메인포스터.jpg', '메인포스터');
-- 영화 정보를 등록 : 제목, 제목-영어, 개봉일, 런닝타임, 줄거리, 등록된 메인포스터 번호, 연령제한을 선택
insert into movie(mo_title, mo_title_eng, mo_opening_date, mo_running_time, mo_plot, mo_fi_num, mo_ag_name)
values('오펜하이머', 'Oppenheimer','2023-08-15','180','“나는 이제 죽음이요, 세상의 파괴자가 되었다.”
세상을 구하기 위해 세상을 파괴할 지도 모르는 선택을 해야 하는 천재 과학자의 핵개발 프로젝트.',1,'15세관람가');


-- 등록된 영화인이 아닌 경우는 영화인을 등록하고, 이미 등록되어 있으면 생략
-- 영화인을 등록(크리스토퍼 놀란, 킬리언 머피, 에밀리 블런트, 맷 데이먼, 로버트 다우니 주니어, 플로렌스 퓨
-- 조쉬 하트넷, 케이시애플렉, 라미 말렉, 케네스 브래너)
insert into film_persion(fp_name,fp_thumbnail,fp_agency,fp_final_education,fp_birthday,fp_ct_name)
 values('크리스토버 놀란','.jpg','','','1970-07-30','영국'),
 ('킬리언 머피','.jpg','','','1974-05-25','아일랜드'),
 ('에밀리 블런트','.jpg','','','1983-02-23','영국'),
 ('맷 데이먼','.jpg','','','1970-10-08','미국'),
 ('로버트 다우니 주니어','.jpg','','','1965-04-04','미국'),
 ('플로렌스 퓨','.jpg','','','1996-01-03','영국'),
 ('조쉬 하트넷','.jpg','','','1978-07-21','미국'),
 ('케이시애플렉','.jpg','','','1975-08-12','미국'),
 ('라미 말렉','.jpg','','','1981-05-12','미국'),
 ('케네스 브래너','.jpg','','','1960-12-10','영국');

-- 역할을 등록
insert into role(ro_role, ro_fp_num, ro_mo_num)
values('감독',1,1),
('배우',2,1),
('배우',3,1),
('배우',4,1),
('배우',5,1),
('배우',6,1),
('배우',7,1),
('배우',8,1),
('배우',9,1),
('배우',10,1);
-- 영화 장르에서 오펜하이머 장르를 추가
insert into movie_genre(mg_ge_name,mg_mo_num) values('드라마',1),('스릴러',1);
-- 제작 국가에서 오펜하이머 제작국가를 추가
insert into country_production(cp_ct_name, cp_mo_num) values('미국',1),('영국',1);
-- 트레일러와 스틸컷을 등록(오펜하이머_트레일러1.MP4, 오펜하이머_스틸컷.JPG, ...)
insert into file(fi_name, fi_state)
values('오펜하이머_트레일러1.mp4', '트레일러'),
('오펜하이머_트레일러2.mp4', '트레일러'),
('오펜하이머_트레일러3.mp4', '트레일러'),
('오펜하이머_스틸컷1.jpg', '스틸컷'),
('오펜하이머_스틸컷2.jpg', '스틸컷'),
('오펜하이머_스틸컷3.jpg', '스틸컷'),
('오펜하이머_스틸컷4.jpg', '스틸컷'),
('오펜하이머_스틸컷5.jpg', '스틸컷');
-- 영화 파일에 오펜하이머에 어떤 트레일러와 스틸컷이 있는지 등록
insert into movie_file(mf_fi_num, mf_mo_num)
values(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1);

-- 영화 콘크리트 유토피아를 등록(위에서 했던 영화 오펜하이머와 같은 방식으로 진행)
-- 트레일러는 2개, 스틸컷은 3개
insert into file(fi_name, fi_state) values('콘크리트_유토피아_메인포스터.jpg', '메인포스터');
-- 영화 정보를 등록 : 제목, 제목-영어, 개봉일, 런닝타임, 줄거리, 등록된 메인포스터 번호, 연령제한을 선택
insert into movie(mo_title, mo_title_eng, mo_opening_date, mo_running_time, mo_plot, mo_fi_num, mo_ag_name)
values('콘크리트_유토피아', 'Concrete Utopia','2023-08-09','130','“아파트는 주민의 것”',10,'15세관람가');

insert into film_persion(fp_name,fp_thumbnail,fp_birthday,fp_ct_name)
 values ('엄태화','.jpg','1981-01-01','한국'),
 ('이병헌','.jpg','1970-07-12','한국'),
 ('박서준','.jpg','1988-12-16','한국'),
 ('박보영','.jpg','1990-02-12','한국'),
 ('김선영','.jpg','1976-04-10','한국'),
 ('박지후','.jpg','2003-11-07','한국'),
 ('김도윤','.jpg','1981-08-07','한국');

-- 역할을 등록
insert into role(ro_role, ro_fp_num, ro_mo_num)
values('감독',1,2),
('배우',2,2),
('배우',3,2),
('배우',4,2),
('배우',5,2),
('배우',6,2),
('배우',7,2),
('배우',8,2),
('배우',9,2),
('배우',10,2);

-- 영화 장르에서 오펜하이머 장르를 추가
insert into movie_genre(mg_ge_name,mg_mo_num) values('드라마',2);
-- 제작 국가에서 오펜하이머 제작국가를 추가
insert into country_production(cp_ct_name, cp_mo_num) values('한국',2);
-- 트레일러와 스틸컷을 등록(오펜하이머_트레일러1.MP4, 오펜하이머_스틸컷.JPG, ...)
insert into file(fi_name, fi_state)
values('콘크리트_유토피아_트레일러1.mp4', '트레일러'),
('콘크리트_유토피아_트레일러2.mp4', '트레일러'),
('콘크리트_유토피아_스틸컷1.jpg', '스틸컷'),
('콘크리트_유토피아_스틸컷2.jpg', '스틸컷'),
('콘크리트_유토피아_스틸컷3.jpg', '스틸컷');
insert into movie_file(mf_fi_num, mf_mo_num)
values(11,2),(12,2),(13,2),(14,2),(15,2);


-- 영화관 등록을 위해 사전에 해야하는 작업
-- 지역데이터를 추가 : 서울,경기,인천,강원,대전/충청,대구,부산/울산,경상,광주/전라/제주
insert into region values('서울'), ('경기'), ('인천'), ('강원'), ('대전/충청'), ('대구'),('부산/울산'),('경상'),('광주/전라/제주');


-- 영화관 등록
-- CGV강남 영화관을 등록, 2관, 24좌석
insert into theater(th_name,th_adress,th_re_name,th_total_screen,th_total_seat) 
values('CGV강남', '서울특별시 강남구 강남대로 438(역삼동)', '서울', 2, 24);

-- 상영관 등록
-- 1관 6층, 총 10좌석
-- 2관(LCK관), 6층(LASER), 총 14좌석
insert into screen(sc_name,sc_total_seat,sc_th_num)
values('1관 6층',10,1),('2관(LCK관) 6층(LASER)',14,1);

-- 좌석을 등록
-- 1관 : A1, A2, A3, A4, B1, B2, B3, C1, C2, C3
-- 2관 : A1, A2, A3, A4, B1, B2, B3, B4, C1, C2, C3, C4, D1, D2
insert into seat(se_name,se_row,se_col,se_sc_num)
values
('A1','A','1',1),
('A2','A','2',1),
('A3','A','3',1),
('A4','A','4',1),
('B1','B','1',1),
('B2','B','2',1),
('B3','B','3',1),
('C1','C','1',1),
('C2','C','2',1),
('C3','C','3',1),
('A1','A','1',2),
('A2','A','2',2),
('A3','A','3',2),
('A4','A','4',2),
('B1','B','1',2),
('B2','B','2',2),
('B3','B','3',2),
('B4','B','4',2),
('C1','C','1',2),
('C2','C','2',2),
('C3','C','3',2),
('C4','C','4',2),
('D1','D','1',2),
('D2','D','2',2);
-- 영화 스케쥴
-- 오펜하이머 1관 23년 8월 16일 00:00, 12:30, 16:00, 19:30, 23:00
-- 콘크리트 유토피아 2관 23년 8월 16일 10:10, 12:50, 18:10, 20:50, 23:30
INSERT INTO MOVIE_SCHEDULE(MS_MO_NUM, MS_SC_NUM, MS_DATE,MS_POSSIBLE_SEAT, 
	MS_START_TIME, MS_END_TIME, MS_DISCOUNT)
SELECT 
	1, 1, '2023-08-16',10,  '09:00:00', 
	RIGHT(ADDDATE('2023-08-16 09:00:00', INTERVAL MO_RUNNING_TIME+10 MINUTE), 8), 
	CASE WHEN '09:00' <= '12:00' THEN 'Y' ELSE 'N' END
FROM MOVIE WHERE MO_NUM = 1;
INSERT INTO MOVIE_SCHEDULE(MS_MO_NUM, MS_SC_NUM, MS_DATE,MS_POSSIBLE_SEAT, 
	MS_START_TIME, MS_END_TIME, MS_DISCOUNT)
SELECT 
	1, 1, '2023-08-16',10,  '12:30:00', 
	RIGHT(ADDDATE('2023-08-16 12:30:00', INTERVAL MO_RUNNING_TIME+10 MINUTE), 8), 
	CASE WHEN '12:30' <= '12:00' THEN 'Y' ELSE 'N' END
FROM MOVIE WHERE MO_NUM = 1;
INSERT INTO MOVIE_SCHEDULE(MS_MO_NUM, MS_SC_NUM, MS_DATE,MS_POSSIBLE_SEAT, 
	MS_START_TIME, MS_END_TIME, MS_DISCOUNT)
SELECT 
	1, 1, '2023-08-16',10,  '16:00:00', 
	RIGHT(ADDDATE('2023-08-16 16:00:00', INTERVAL MO_RUNNING_TIME+10 MINUTE), 8), 
	CASE WHEN '16:00' <= '12:00' THEN 'Y' ELSE 'N' END
FROM MOVIE WHERE MO_NUM = 1;
INSERT INTO MOVIE_SCHEDULE(MS_MO_NUM, MS_SC_NUM, MS_DATE,MS_POSSIBLE_SEAT, 
	MS_START_TIME, MS_END_TIME, MS_DISCOUNT)
SELECT 
	1, 1, '2023-08-16',10,  '19:30:00', 
	RIGHT(ADDDATE('2023-08-16 19:30:00', INTERVAL MO_RUNNING_TIME+10 MINUTE), 8), 
	CASE WHEN '19:30' <= '12:00' THEN 'Y' ELSE 'N' END
FROM MOVIE WHERE MO_NUM = 1;

INSERT INTO MOVIE_SCHEDULE(MS_MO_NUM, MS_SC_NUM, MS_DATE,MS_POSSIBLE_SEAT, 
	MS_START_TIME, MS_END_TIME, MS_DISCOUNT)
SELECT 
	2, 2, '2023-08-16',14,  '10:10:00', 
	RIGHT(ADDDATE('2023-08-16 10:10:00', INTERVAL MO_RUNNING_TIME+10 MINUTE), 8), 
	CASE WHEN '10:10' <= '12:00' THEN 'Y' ELSE 'N' END
FROM MOVIE WHERE MO_NUM = 2;
INSERT INTO MOVIE_SCHEDULE(MS_MO_NUM, MS_SC_NUM, MS_DATE,MS_POSSIBLE_SEAT, 
	MS_START_TIME, MS_END_TIME, MS_DISCOUNT)
SELECT 
	2, 2, '2023-08-16',14,  '12:50:00', 
	RIGHT(ADDDATE('2023-08-16 12:50:00', INTERVAL MO_RUNNING_TIME+10 MINUTE), 8), 
	CASE WHEN '12:50' <= '12:00' THEN 'Y' ELSE 'N' END
FROM MOVIE WHERE MO_NUM = 2;
INSERT INTO MOVIE_SCHEDULE(MS_MO_NUM, MS_SC_NUM, MS_DATE,MS_POSSIBLE_SEAT, 
	MS_START_TIME, MS_END_TIME, MS_DISCOUNT)
SELECT 
	2, 2, '2023-08-16',14,  '18:10:00', 
	RIGHT(ADDDATE('2023-08-16 18:10:00', INTERVAL MO_RUNNING_TIME+10 MINUTE), 8), 
	CASE WHEN '18:10' <= '12:00' THEN 'Y' ELSE 'N' END
FROM MOVIE WHERE MO_NUM = 2;
INSERT INTO MOVIE_SCHEDULE(MS_MO_NUM, MS_SC_NUM, MS_DATE,MS_POSSIBLE_SEAT, 
	MS_START_TIME, MS_END_TIME, MS_DISCOUNT)
SELECT 
	2, 2, '2023-08-16',14,  '20:50:00', 
	RIGHT(ADDDATE('2023-08-16 20:50:00', INTERVAL MO_RUNNING_TIME+10 MINUTE), 8), 
	CASE WHEN '20:50' <= '12:00' THEN 'Y' ELSE 'N' END
FROM MOVIE WHERE MO_NUM = 2;

-- 예매를 위해 사전에 해야하는 작업 
-- 요금 데이터를 추가 
-- 성인 : 14000, 조조 : 12000
-- 청소년 : 11000, 조조 : 9000
INSERT INTO PRICE(PR_TYPE, PR_PRICE, PR_DISCOUNT_PRICE)
VALUES('성인', 14000, 12000), ('청소년', 11000, 9000);

-- 아이디 : abc123, 비번 : abc123, 이름 : 홍길동, 번호 : 011-1234-5678,
-- 생일 : 2000-01-05, 권한 : USER 인 회원이 회원가입 
INSERT INTO MEMBER(ME_ID, ME_PW, ME_NAME, ME_PHONE, ME_BIRTHDAY, ME_AUTHORITY)
VALUES('abc123', 'abc123', '홍길동', '011-1234-5678', '2000-01-05', 'USER');
-- abc123회원이 CGV강남에서 20:50에 시작하는 콘크리트 유토피아 영화를 성인 2명으로, 
-- A1, A2 좌석을 예매했을 때 필요한 쿼리들 

-- RESERVATION에 예약 정보를 추가 
INSERT INTO RESERVATION(RV_NUM, RV_ADULT, RV_TEENAGER, RV_ME_ID, RV_MS_NUM, RV_PRICE)
SELECT '202308091614MS008001',2, 0, 'abc123', MS_NUM,
CASE 
	WHEN MS_DISCOUNT = 'Y' THEN
		2 * 12000 + 0 * 9000
    ELSE
		2 * 14000 + 0 * 11000
    END
FROM MOVIE_SCHEDULE WHERE MS_MO_NUM = 2 AND MS_START_TIME = '20:50:00';

-- RESUERVATION_LIST에 예약 좌석 정보를 추가 
INSERT INTO RESERVATION_LIST(RL_RV_NUM, RL_SE_NUM, RL_PR_NUM) 
	VALUES('202308091614MS008001', 11, 1),('202308091614MS008001', 12, 1);

-- MOVIE_SCHEDULE에 예약 가능 좌석 수를 수정 
UPDATE MOVIE_SCHEDULE 
SET 
    MS_POSSIBLE_SEAT = MS_POSSIBLE_SEAT - 2
WHERE
    MS_NUM = 8;
-- MOVIE에 예매율을 수정 
UPDATE MOVIE 
SET 
    MO_RESERVATION_RATE = ROUND(
    (SELECT 
    SUM(RV_ADULT + RV_TEENAGER)
FROM
    RESERVATION
    JOIN
		MOVIE_SCHEDULE
	ON RV_MS_NUM = MS_NUM
WHERE
	MS_MO_NUM = 2) / 
    (SELECT 
    SUM(RV_ADULT + RV_TEENAGER)
FROM
    RESERVATION
    JOIN
		MOVIE_SCHEDULE
	ON RV_MS_NUM = MS_NUM) * 100)
WHERE
    MO_NUM = 2;
