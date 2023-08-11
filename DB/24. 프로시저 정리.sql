/*
- 함수
하나의 작업을 하도록 구성, 예매 함수 => 예매에 데이터를 추가"만" 함
매개변수 : 값을 사용(매개변수의 값이 변경되지 않음)
반환값 : 무조건 1개
- 프로시저
일련의 작업을 하도록 구성. 예매 프로시저
 => 예매에 데이터를 추가, 스케쥴의 예매 가능좌석 업데이트, 영화의 예매율 업데이트

매개변수 : 값을 사용, 값을 반환, 값을 사용과 반환 IN Out // 매개변수로 리턴값을 받을 수 있음
반환값 : 없음 대신 매개변수를 이용하여 out/inout 인 매개변수에 반환값을 전달할 수 있음
select문에서 사용이 불가능

delimiter // 

create procedure 프로시져명(
[
in|out|inout 변수명 변수 타입
]
)
begin
	-- 변수 선언 방법	
	declare 변수명 변수타입;
    declare 변수명 변수타입 default 기본값;
    
    -- 변수값 변경
    set 변수명 = 값;
    
    -- if문
    if 조건식 then
		실행문;
	elseif 조건식2 then
		실행문2;
    else
		실행문3;
        end if;
end //
delimiter ;

-- 프로시저 호출
call 프로시져명(매개변수들);
*/

-- 숫자가 주어짐ㄴ 숫자앞에 0을 붙여서 최대 5자리로 된 숫자를 만드는 프로시저
-- 1 => 00001

drop procedure if exists zero_num;

delimiter //
create procedure zero_num(
in _num int
)
begin
	declare _res char(5);
    set _res = (select lpad(_num, 5, '0'));
    select _res;
end //
delimiter ;
call zero_num(123);