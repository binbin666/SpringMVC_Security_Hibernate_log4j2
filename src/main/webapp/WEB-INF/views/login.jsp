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
	<h4>Login Form</h4>
	
	<form action='<spring:url value="/loginAction"/>' method="post">
    <table>
      <tr>
        <td>Username</td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="password" name="password"></td>
      </tr>
      <tr>
        <td><input type="checkbox" name="rememberMe"></td>
        <td>Remember me</td>
      </tr>
      <tr>
        <td><button type="submit">Login</button></td>
      </tr>
    </table>
  </form>
  <br/>
</body>
</html>