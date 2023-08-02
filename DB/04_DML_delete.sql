/*
delete : 데이터를 삭제
delete from 테이블명 where 기본키 = 값;
*/
-- 학번이 2023160001인 학생의 데이터를 삭제하는 쿼리
DELETE FROM student 
WHERE
    num = 2023160001;
/*
- 데이터 삭제 시 where절이 없거나, where의 속성이 기본키가 아닌 경우 워크벤치에서 동작이 안될 수도 있음
- 이유는 워크벤치에서는 데이터가 update(update/delete)될 때 안전하게 하도록 기본키가 update하는
  경우에만 적용이 되도록 하고있기 때문
- 해결하려면 edit - preperences... > SQL Editor > 제일 하단의 Safe update ...를 체크 해제하면됨
*/
