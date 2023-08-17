/*
이벤트 스케쥴러 : 일정주기마다 이벤트를 발생시켜서 등록된 이벤트를 실험하는 것
create event 이벤트명
on schedule every 숫자단위(day, hour,minute,..)
[starts 시간]
do
	작업할코드; -- 작업될 코드는 한줄로 된 insert/update/delete나 프로시저 이용
*/
-- 이벤트 스케쥴러의 on/off 를 조회하는 쿼리
show variables like 'event%';
use test;
-- 등록된 이벤트 스케쥴러 조회
show events;
drop event if exists test_event;
create event test_event on schedule every 1 minute
do
	update dash_board set db_member = db_member + 1;
