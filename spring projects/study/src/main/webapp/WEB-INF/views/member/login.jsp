<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="<c:url value='/member/login'/>" method="post">
	<input type="text" name="me_id" placeholder="아이디" required><br>
	<input type="password" name="me_pw" placeholder="비밀번호" required><br>
	
	<button>로그인</button>
	</form>
	
</body>
</html>