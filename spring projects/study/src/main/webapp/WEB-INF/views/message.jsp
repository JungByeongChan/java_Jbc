<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안내메세지</title>
</head>
<body>
<script type="text/javascript">
		alert('${msg}');
		location.href= '<c:url value="${url}"/>';
	</script>
</body>
</html>