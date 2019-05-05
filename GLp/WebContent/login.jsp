<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${erro }</h1>
	<form action="${pageContext.request.contextPath}/login">
		<input type="text" name="name">
		<br>
		<input type="text" name="pwd">
		<input type="submit">
		</form>
</body>
</html>