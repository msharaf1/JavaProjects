<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="flex">
		<form class="newForm" action="/login" method="POST" >
			<c:if test="${loginError != null}" >
				<p class="error">${loginError}</p>				
			</c:if>

			<h1 class="blue">Login</h1>
			<p><input type="text"  name="email" placeholder="Email" /></p>
			<p><input type="password" name="password" placeholder="Password" /></p>
			<p><input type="submit" value="Login" /></p>
		</form>
		
		<form:form class="newForm" action="/" method="POST" modelAttribute="user" >
			<h1 class="blue">Register</h1>

			<c:if test="${userError != null}" >
				<p class="error">${userError}</p>				
			</c:if>

			<p class="error"><form:errors path="name"></form:errors></p>
			<p><form:input placeholder="Name" path="name"></form:input></p>
	
			<p class="error"><form:errors path="email"></form:errors></p>
			<p><form:input placeholder="Email" path="email"></form:input></p>
	
			<p class="error"><form:errors path="password"></form:errors></p>
			<p><form:input placeholder="Password" path="password"></form:input></p>
	
			<p class="error"><form:errors path="confirm"></form:errors></p>
			<p><form:input placeholder="Password Confirmation" path="confirm"></form:input></p>	
	
			<p><input type="submit" value="Register" /></p>
		</form:form>
	</div>
</body>
</html>