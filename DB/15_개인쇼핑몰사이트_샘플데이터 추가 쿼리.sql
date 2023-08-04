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

 -- 제품코드가 ABC001, 제품명이 KH무선마우스, 제품설명이 KH무선마우스입니다. 가격이 15000원
 -- 종류가 무선 / 유선인 제품을 등록하는 쿼리를 작성
 