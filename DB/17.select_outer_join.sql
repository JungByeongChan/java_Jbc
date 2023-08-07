/*
inner join : 두 테이블이 외래키로 연결 되었을 때, 양쪽 다 데이터가 있는 경우
outer join : 두 테이블이 외래키로 연결 되었을 때, 한쪽을 기준으로 

- 상품별 리뷰수를 조회하는 경우, 리뷰가 등록이 안된 상품들은 inner join을 사용하여 리뷰수를 알수가 없음

- outer join 문법 : 기준 테이블이 매우 중요
  inner join은 A join B, B join A가 같지만
  outer join은 A outer join B와 B outer join A는 결과가 다름

- 종류 : left, right
- left join : 기준 테이블을 기준으로 연결
- right join : 참조 테이블을 기준으로 연결

A left join B == B rigt join A
select * from 기준테이블 
	Join 참조테이블
    On 기준테이블.외래키 = 참조테이블.기본키
[where절]
[group by절]
[having절]
[order by절]
[limit절]

*/
-- 제품별 리뷰 개수를 조회하는 쿼리(리뷰가 등록된 제품만 조회)
SELECT 
    op_pr_code AS 제품코드, COUNT(re_num) as 리뷰수
FROM
    review
       right JOIN
    `option` ON op_num = re_op_num
GROUP BY op_pr_code;
-- 제품별 옵션의 개수를 조회하는 쿼리(제품명, 옵션수)
SELECT 
   pr_name as 제품명,
   count(*) as 옵션수
FROM
    product
join
    `option` on pr_code = op_pr_code
GROUP BY pr_code;

-- 제품별 판매량(반품, 환불을 제회한)을 조회하는 쿼리(제품명, 판매량)
select pr_name as 제품명, sum(ol_amount) as 판매량
from product
join `option` on op_pr_code = pr_code
left join order_list on ol_op_num = op_num
left join `order` on or_num = ol_or_num
where or_state is null or or_state not in('반품','환불')
group by pr_code;

-- 제품 옵션별 판매량(반품, 환불을 제외한)을 조회하는 쿼리(제품명, 옵션명, 판매량)
select pr_name as 제품명, ifnull(sum(ol_amount),0) as 판매량, op_name as 옵션명
from product
join `option` on op_pr_code = pr_code
left join order_list on ol_op_num = op_num
left join `order` on or_num = ol_or_num
where or_state is null or or_state not in('반품','환불')
group by op_num;

-- 제품 옵션별 판매량(반품, 환불을 제외한)을 조회하는 쿼리(제품명, 옵션명, 판매량, 총판매금액)
select pr_name as 제품명, ifnull(sum(ol_amount),0) as 판매량, op_name as 옵션명,
pr_price * ifnull(sum(ol_amount),0) as 총판매금액
from product
join `option` on op_pr_code = pr_code
left join order_list on ol_op_num = op_num
left join `order` on or_num = ol_or_num
where or_state is null or or_state not in('반품','환불')
group by op_num;

-- 옵션별 리뷰수를 조회하는 쿼리(제품명, 옵션명, 리뷰수)
select pr_name as 제품명, op_name as 옵션명, count(re_num) as 리뷰수
from review 
right join `option` on re_op_num=op_num
join product on pr_code = op_pr_code
group by op_num;
