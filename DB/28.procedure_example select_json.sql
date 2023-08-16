-- json형태의 문자열을 추출해서  출력하는 프로시저


drop procedure if exists select_json;

delimiter //
create procedure select_json(
in _json text
)
begin
		declare done int default 0; -- cursor를 이용하여 반복문을 할 때 종료할지를 결정해주는 변수
        declare _id char(10); -- 검색결과에 있는 한행의 있는 아이디를 저장할 변수
        declare _name varchar(20); -- 검색결과에 있는 한행의 있는 이름을 저장할 변수
        
        
        declare cur cursor for
			select * from json_table(_json, "$[*]"
				columns(
					id char(10) path "$.id",
                    name varchar(20) path "$.name"
				)
            ) as info_table;
		declare continue handler for not found set done = 1;
        -- cursor를 열고
        open cur;
        student_loop : loop
			-- fetch : cur에서 한 행씩 꺼내는 작업을 함
            -- done이 자동으로 1이 됨(왜냐면 16번째줄에서 설정했기 때문)
			fetch cur into _id, _name;
            if done then
				leave student_loop;
			end if;
            -- 하고싶은 작업
            select _id, _name;
        end loop;
        
        -- cursor를 닫음
        close cur;
end //
delimiter ;

CALL SELECT_JSON('[{"id" : "abc123","name":"홍길동"},{"id" : "admin","name":"고길동"},{"id" : "qwe123","name":"임꺽정"}]');