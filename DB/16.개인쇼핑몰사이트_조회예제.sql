-- qwe123회원이 구매(환불, 반품을 제외한)한 제품명과 옵션명 목록을 확인하는 쿼리 
SELECT 
	OR_ME_ID AS 주문아이디,
    PR_NAME AS 제품명,
    OP_NAME AS 옵션명,
    PR_PRICE AS 제품가격,
    OL_AMOUNT AS 구매수량
FROM `ORDER`
	JOIN ORDER_LIST ON OL_OR_NUM = OR_NUM
    JOIN `OPTION` ON OL_OP_NUM = OP_NUM
    JOIN PRODUCT ON OP_PR_CODE = PR_CODE
WHERE OR_STATE NOT IN('환불', '반품') AND OR_ME_ID = 'qwe123';


-- abc123회원이 장바구니에 담은 제품명과 옵션명, 수량을 확인하는 쿼리
select ba_me_id as 회원아이디, pr_name as 제품명, op_name as 옵션명, ba_amount as 수량
from basket join `option` on ba_op_num = op_num
join product on op_pr_code = pr_code
where ba_me_id = 'abc123';

-- abc123회원이 등록한 배송지 정보를 조회하는 쿼리
select ad_addr,ad_addr_detail from address where ad_me_id = 'abc123';

-- 등록된 모든 제품을 검색하는 쿼리
select * from product;

-- kh가 제품명에 포함된 제품들을 검색하는 쿼리
select * from product where pr_name like concat('%','KH%','%');

-- kh가 제품명에 포함된 제품들 중에서 1페이지에 해당하는 제품들을 검색하는 쿼리(한 페이지에는 제품이 최대 5개)
select * from product where pr_name like concat('%','KH%','%') limit 0,5;

-- kh가 제품명에 포함된 제품들 중에서 2페이지에 해당하는 제품들을 검색하는 쿼리(한 페이지에는 제품이 최대 5개)
select * from product where pr_name like concat('%','KH%','%') limit 2,5;

-- abc123회원이 작성한 모든 리뷰를 조회하는 쿼리
select * from review where re_me_id = 'abc123';

-- abc123회원이 작성한 리뷰가 있는 제품명을 조회
select pr_name as 리뷰제품 from review
join `option` on re_op_num = op_num
join product on pr_code = op_pr_code where re_me_id = 'abc123';

-- 제품 코드가 ABC001이고, 옵션명이 무선인 제품에 달린 리뷰를 조회
select * from review join `option` on op_num = re_op_num
where op_pr_code = 'ABC001' and op_name = '무선';

-- 제품명이 KH무선마우스인 제품의 리뷰 개수를 조회하는 쿼리
select count(*) as 'KH무선마우스 리뷰수' from review join `option` on re_op_num = op_num
where op_pr_code = (select pr_code from product where pr_name = 'KH무선마우스');

-- 제품별 리뷰 개수를 조회하는 쿼리
select op_pr_code as 제품코드,count(*) from review join `option` on op_num = re_op_num group by op_pr_code;
