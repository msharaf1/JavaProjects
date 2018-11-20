<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Task</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1>Create a New Task</h1>
	<div class="flex">
		
		<form class="newTask" action="/tasks/new" method="POST" >
		<input type="hidden" name="creator" value="<%= session.getAttribute("user") %>"/>
						<h1 class="blue">Task Content:</h1>
			<p><input type="text"  name="content" placeholder="Insert your task here!" /></p>
			<h1 class="blue">Task Assignee:</h1>
			<p><select name="assignee">
				<c:forEach items="${users}" var="user">
        				<option value="${user.name}"><c:out value="${user.name}"/> </option>

   				</c:forEach>
  			</select>
  			<h1 class="blue">Priority:</h1>
  			<p><select name="priority">
        		<option value="High">High</option>
        		<option value="Medium">Medium</option>
        		<option value="Low">Low</option>
  			</select>
  			</p>
			<p><input type="submit" value="Create"/></p>
			
		</form>
	</div>
</body>
</html>