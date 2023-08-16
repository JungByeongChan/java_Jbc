/*
트리거 : 이벤트(insert, update, delete)에 반응해 자동으로 실행되는 작업
=> 데이터 일관성을 유지하기 위해
트리거 예시
Ex) 쇼핑몰에서 회원이 주문을 완료하면 주문 리스트테이블에 데이터가 추가 => 옵션 수량이 변경
트리거 특징
- old와 new를 통해 이벤트가 발생된 데이터를 접근할 수 있다.
	- insert 이벤트에는 이전 데이터가 없기 떄문에 new를 통해서만 추가된 데이터에 접근할 수 있다.
    - delete 이벤트에는 새로운 데이터가 없기 때문에 old를 통해서만 삭제된 데이터에 접근할 수 있다.
    - update 이벤트에는 수정되기전 데이터는 old, 수정된 데이터는 new로 접근할 수 있다.
    - old.속성명, new.속성명
- 이벤트가 발생된 데이터는 수정할 수 없다.


drop trigger if exists 트리거명
delimiter //
create trigger 트리거명 트리거시간 이벤트명 On 테이블명
for each row
begin
// 구현
end //
delimiter ;

트리거시간 : before | after 
이벤트명 : insert | update | delete
*/

use test;
-- 회원이 등록되면 대쉬보드 테이블에 등록된 회원수를 증가시키는 트리거
drop trigger IF EXISTS insert_member;

delimiter //
create trigger insert_member after insert on member
for each row
begin
	update dash_board
	set
		db_member = db_member + 1;
end //
delimiter ;

insert into member(me_id, me_pw) values('abc123', 'abc123'),('admin','admin');

-- 회원이 게시글을 작성하면 회원의 작성된 게시글 수가 증가하는 트리거
drop trigger IF EXISTS insert_board;

delimiter //
create trigger insert_board after insert on board
for each row
begin
	update member
	set
		me_board_count = me_board_count + 1
	where
		me_id = new.bo_me_id;
end //
delimiter ;

insert into board(bo_title,bo_me_id) values('게시글', 'abc123');

-- 게시글이 삭제됐을 때 해당 게시글을 작성한 회원의 게시글 수를 1줄이는 트리거

drop trigger IF EXISTS delete_board;

delimiter //
create trigger delete_board after delete on board
for each row
begin
	update member
	set
		me_board_count = me_board_count - 1
	where
		me_id = old.bo_me_id;
end //
delimiter ;

delete from board where bo_num = 1;

insert into board(bo_title,bo_me_id) values('게시글', 'abc123');


use shoppingmall;

-- 회원이 제품을 주문했을 때 필요한 트리거
-- 주문 테이블에 데이터 추가 => 주문 리스트에 데이터가 추가 => 각 주문 리스트에 맞는 옵션에 수량이 변경
-- 주문 리스트에 데이터가 추가될 때 각 주문 리스트에 맞는 옵션 수량이 변경되는 트리거



drop trigger IF EXISTS insert_order_list;

delimiter //
create trigger insert_order_list after insert on order_list
for each row
begin
	update `option`
	set
		op_amount = op_amount - new.ol_amount
	where
        op_num = new.ol_op_num;
end //
delimiter ;


-- 주문번호가 3번이 없는 경우만 아래 코드 적용
insert into
`order`(or_num,or_total,or_price,or_use_point,or_save_point,or_me_id,or_ad_num)
values(3,45000,0,4500,'qwe123',2);
-- 아래 쿼리가 실행될 때 트리거가 작동
insert into order_list(ol_amount, ol_price, ol_or_num, ol_op_num)
values(1,15000,3,1),(1,30000,3,3);


-- 회원이 주문한 제품을 구매확정으로 바꾸면 포인트가 적립되는 트리거

drop trigger if exists `update_order`
delimiter //

create trigger `update_order` after update on `order`
for each row
begin
	-- or_state가 구매확정이면 포인트를 적립0
	if new.or_state = '구매확정' then
		update member set me_point = me_point + new.or_save_point
        where me_id = new.or_me_id;
    end if;
end
delimiter ;


update `order` set or_state = '구매확정' where or_num = 3;