<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype aheml>
<html lang="ko">
<head>
	<title>스프링</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  my name is ${name }. </P>
<form action="<c:url value='/test1'/>">
	<input type="text" name="id"><br>
	<input type="text" name="age"><br>
	<button>전송</button>
</form>
</body>
</html>
