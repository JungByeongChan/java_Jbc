<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="<%=request.getContextPath() %>/signup" method="post">
		<input type="text" name="id"><br>
		<input type="password" name="pw"><br>
		<button>회원가입</button>
	</form>
		
	<script>
		<%
			Boolean result = (Boolean)request.getAttribute("signupOk");
			if(result != null && result){
		%>	
			alert('회원가입 성공')
		<%
			}else if(result != null && !result){
		%>
			alert('회원가입 실패')
		<%
			}
		%>
		
	</script>
	
</body>
</html>