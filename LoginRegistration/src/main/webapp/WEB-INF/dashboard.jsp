<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tasks Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1>Welcome, <%= session.getAttribute("user") %>!</h1>
	
	<table>
		<tr>
			<th>Task:</th>
			<th>Creator:</th>
			<th>Assignee:</th>
			<th>Priority:</th>
		</tr>
	
		<c:forEach items="${ tasks }" var="t" >
			<tr>
				<td>
					<a href="/tasks/${ t.id }">${ t.content }</a>
				</td>
				<td><p>${t.creator}</p></td>
				<td><p>${t.assignee}</p></td>
				<td><p>${t.priority}</p></td>
			</tr>
		</c:forEach>
	</table>
	
<a href="/tasks/new">Create a Task</a>
</body>
</html>