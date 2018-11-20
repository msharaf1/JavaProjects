<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task # ${ task.id }</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1>Task ID #${ task.id }</h1>
	<h2>Task: ${ task.content }</h2>
	<h2>Creator: ${ task.creator }</h2>
	<h2>Assignee: ${ task.assignee }</h2>
	<h2>Priority: ${ task.priority }</h2>
	
	<form:form action="/tasks/${task.id}/edit" method="GET" modelAttribute="task" >
		<input type="submit" value="Edit Task" />
	</form:form>
	
	<form:form action="/tasks/${task.id}/delete" method="POST" modelAttribute="task" >
		<input type="submit" value="Delete" />
	</form:form>
	

</body>
</html>
