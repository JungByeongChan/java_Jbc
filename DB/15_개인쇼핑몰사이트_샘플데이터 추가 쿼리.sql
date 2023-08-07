use shoppingmall;

-- 회원아이디가 ABC123, 비밀번호가 1234, 번호가 011-1234-5678
-- 서울시 강남구 KH빌딩, 주소 상세가 6층 361반, 우편번호 01234인 회원이 가입을 했을 때 쿼리 작성
-- 권한은 ADMIN(판매자), USER(고객이자 회원) 중 하나

INSERT INTO MEMBER(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY, ME_NAME)
	VALUES('abc123','1234','011-1234-5678','서울시 강남구 KH빌딩', '6층 361반', '01234', 'USER', '홍길동');

INSERT INTO MEMBER(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY, ME_NAME)
	VALUES('admin','admin','011-1111-1111','서울시 강북구 KH빌딩', '3층 101호', '01231', 'ADMIN', '임꺽정');
INSERT INTO MEMBER(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY, ME_NAME)
	VALUES('qwe123','qwe1234','011-9999-5678','서울시 강남구 KH빌딩', '1층 161반', '01234', 'USER', '고길동');

-- 제품코드가 ABC001, 제품명이 KH무선마우스, 제품설명이 KH무선마우스입니다., 가격이 15000원
-- 종류가 무선 / 유선인 제품을 등록하는 쿼리를 작성 
-- PRODUCT 테이블과 OPTION테이블에 데이터를 추가 
INSERT INTO PRODUCT VALUES('ABC001','KH무선마우스','KH무선마우스입니다.', 15000);
INSERT INTO `OPTION`(OP_NAME, OP_PR_CODE) VALUES('무선', 'ABC001'),('유선','ABC001');

-- 제품 코드가 ABC001인 제품의 제품 정보와 옵션을 조회하는 쿼리 
SELECT 
    *
FROM
    PRODUCT
        JOIN
    `OPTION` ON PR_CODE = OP_PR_CODE
WHERE
    PR_CODE = 'ABC001';
    

-- 제품 코드가 ABC001인 제품 중에서 유선 제품이 10개 들어오고, 무선 제품이 5개 들어왔을 떄 사용해야하는 쿼리
update `option` set op_amount = 10 where op_pr_code = 'ABC001' and op_name = '유선';
update `option` set op_amount = 5 where op_pr_code = 'ABC001' and op_name = '무선';

-- abc123 회원이 배송지를 다음과 같이 등록(배송지명 : 집, 주소 : 서울시 강남구 123번지,
-- 상세 : KH아파트 101동 101호, 우편번호 : 12345)
insert into address(ad_name, ad_addr, ad_addr_detail, ad_post, ad_me_id)
values('집','서울시 강남구 123번지', 'KH아파트 101동 101호', '12345','abc123');

-- abc회원이 ABC001 제품 중 유선을 3개 장바구니에 담았을 때 쿼리
insert into basket(ba_amount, ba_me_id, ba_op_num)
values('3', 'abc123', '2');

-- insert into basket(ba_amount, ba_me_id, ba_op_num)
-- select 3,'abc123', OP_NUM from `option`
-- where op_pr_code = 'abc001' and op_name = '유선';

-- abc123회원이 ABC001 제품 중 유선을 1개 장바구니에 담았을 때 쿼리
update basket set ba_amount = 1 -- where ba_num = 1 로 해도되며, 아니면 이하 수식으로도 가능
where
ba_me_id= 'abc123' and
ba_op_num = (select op_num from `option` where op_pr_code = 'ABC001' and op_name = '유선');

-- abc회원이 ABC001 제품 중 무선을 2개 구매하고 배송지로 집을 선택했을 때 실행해야하는 모든 쿼리를 작성
-- 1. 주문내역을 추가 => 주문 리스트에서 주문 내역번호가 필요하기 때문
insert into `order`(or_total,or_price, or_use_point, or_save_point,or_me_id, or_ad_num) 
values(15000 * 2, 15000*2,0,3000,'abc123', '1');
-- 2. 주문 리스트에 구매 목록을 작성
insert into order_list(ol_amount, ol_price, ol_or_num, ol_op_num)
values(2, 15000*2, 1, 1);
-- 3. 제품 수량을 수정
update `option` set op_amount = op_amount - 2 where op_num = 1;
-- 4. 마일리지(포인트) 적립
-- 4-1. 마일리지 내역 추가
insert into point(po_content, po_amount, po_me_id)
values('제품 구매에 의한 적립', 3000, 'abc123');
-- 4.2 회원 정보의 포인트 수정
update member set me_point = me_point + 3000 where me_id = 'abc123'; 


-- 제품 코드가 ABC002, 제품명 KH키보드, 제품상세가 혁신적인KH키보드, 제품가격이 30000원
-- 제품 종류가 '기계식', '일반'인 제품을 등록하는 쿼리

INSERT INTO PRODUCT VALUES('ABC002','KH키보드','혁신적인KH키보드', 30000);
INSERT INTO `OPTION`(OP_NAME, OP_PR_CODE) VALUES('기계식', 'ABC002'),('일반','ABC002');

-- 제품 코드가 ABC002, 종류가 기계식인 제품이 100개,제품 코드가 ABC002, 종류가 일반인 제품이 50개 입고

update `option` set op_amount = op_amount + 100 where op_pr_code = 'ABC002'and op_name = '기계식';
update `option` set op_amount = op_amount + 50 where op_pr_code = 'ABC002'and op_name = '일반';

-- qwe123회원이 ABC001 제품 중 무선을 2개 장바구니에 담고
-- 이어서 ABC002 제품 중 기계식을 3개 장바구니에 담았을 때 쿼리를 작성하시오
insert into basket(ba_amount, ba_me_id, ba_op_num) values(2,'qwe123', 1);
insert into basket(ba_amount, ba_me_id, ba_op_num) values(3,'qwe123', 3);

-- qwe123회원이 장바구니에 담긴 모든 제품을 구매했을 때 쿼리(구매시 포인트 사용은 x)
-- 배송지를 집으로, 경기도 안산시 안산구 123번지, 상세는 없음, 우편번호는 12312를 등록 후 구매 
-- 0. 배송지 테이블에 추가
INSERT INTO ADDRESS(AD_NAME, AD_ADDR, AD_ADDR_DETAIL, AD_POST, AD_ME_ID)
VALUES('집', '경기도 안산시 안산구 123번지','','12312', 'qwe123');
-- 1. 주문 테이블에 추가 
INSERT INTO `ORDER`(OR_TOTAL, OR_PRICE, OR_USE_POINT, OR_SAVE_POINT, OR_ME_ID, OR_AD_NUM)
SELECT 15000*2+30000*3, 15000*2+30000*3, 0, (15000*2+30000*3)/10, 'qwe123', AD_NUM
	FROM ADDRESS
    WHERE AD_ME_ID = 'qwe123' AND AD_NAME = '집';
-- 2. 주문 리스트 테이블에 추가 
INSERT INTO ORDER_LIST(OL_AMOUNT, OL_PRICE, OL_OR_NUM, OL_OP_NUM)
	SELECT 2, PR_PRICE*2, 2, OP_NUM 
    FROM `OPTION`
    JOIN PRODUCT
    ON OP_PR_CODE = PR_CODE
    WHERE
		OP_PR_CODE = 'ABC001' AND OP_NAME = '무선';
INSERT INTO ORDER_LIST(OL_AMOUNT, OL_PRICE, OL_OR_NUM, OL_OP_NUM)
	SELECT 3, PR_PRICE*3, 2, OP_NUM 
    FROM `OPTION`
    JOIN PRODUCT
    ON OP_PR_CODE = PR_CODE
    WHERE
		OP_PR_CODE = 'ABC002' AND OP_NAME = '기계식';
-- 3. 옵션 테이블에 수정(수량)
UPDATE `OPTION` 
SET 
    OP_AMOUNT = OP_AMOUNT - 2
WHERE
    OP_PR_CODE = 'ABC001' AND OP_NAME = '무선';
UPDATE `OPTION` 
SET 
    OP_AMOUNT = OP_AMOUNT - 3
WHERE
    OP_PR_CODE = 'ABC002' AND OP_NAME = '기계식';
-- abc123회원이 제품을 받고 구매 확정을 눌렀을 때 쿼리
-- 주문에 구매확정으로 수정
update `order` set or_state = '구매 확정' where or_num = 1;
-- 포인트 내역에 적립 내용을 추가
insert into point(po_content, po_amount, po_me_id)
values('제품 구매에 의한 적립', 3000, 'abc123');
-- 회원 정보에 포인트를 누적
update member set me_point = me_point + 3000 where me_id = 'abc123';

-- abc123회원이 구매 확정한 ABC001 제품 중 무선인 제품에 '좋은 마우스입니다.' 라고 리뷰를 등록했을 때 쿼리
insert into review(re_content, re_thumb, re_op_num, re_me_id)
values('좋은 마우스입니다.',null,1,'abc123');