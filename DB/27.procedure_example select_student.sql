-- 검색 결과 테이블을 반복문을 이용해서 활용하는 프로시저
-- 학생 정보를 출력하는 프로시저(프로시저 이용하지 않아도 select문으로 처리 가능하지만 연습을 위해)

use course;

drop procedure if exists select_student;

delimiter //
create procedure select_student()
begin
		declare done int default 0; -- cursor를 이용하여 반복문을 할 때 종료할지를 결정해주는 변수
        declare _num char(10); -- 검색결과에 있는 한행의 있는 학번을 저장할 변수
        declare _name varchar(20); -- 검색결과에 있는 한행의 있는 이름을 저장할 변수
        declare _major varchar(20); -- 검색결과에 있는 한행의 있는 전공을 저장할 변수
        
        declare cur cursor for
			select * from student;
		declare continue handler for not found set done = 1;
        -- cursor를 열고
        open cur;
        student_loop : loop
			-- fetch : cur에서 한 행씩 꺼내는 작업을 함
            -- done이 자동으로 1이 됨(왜냐면 16번째줄에서 설정했기 때문)
			fetch cur into _num, _name, _major;
            if done then
				leave student_loop;
			end if;
            -- 하고싶은 작업
            select concat(_num, _name, _major);
        end loop;
        
        -- cursor를 닫음
        close cur;
end //
delimiter ;

call select_student();
