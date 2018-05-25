<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>github.com/binbin666</title>
</head>
<body>
	<h1>SpringMVC/SpringSecurity/Hibernate</h1>
	<h2>${message}</h2>

	<%-- <form action='<spring:url value="/createAction"/>' method="post">
	       用户名：<input value="username" type="text" />
	       密码：<input value="password" type="password" />
		<input value="Create" type="submit">
	</form>
	<form action='<spring:url value="/listAction"/>' method="post">
		<input value="List" type="submit">
	</form> --%>
	<form action='<spring:url value="/logoutAction"/>' method="post">
		<input value="Logout" type="submit">
	</form>
</body>
</html>