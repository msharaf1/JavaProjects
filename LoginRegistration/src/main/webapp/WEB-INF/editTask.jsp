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
	<h1>${ task.content }</h1>

	<form:form action="/tasks/${task.id}/update" method="POST" modelAttribute="task" >
	<input type="hidden" name="creator" value="<%= session.getAttribute("user") %>"/>
		<form:label path="content" >Content
			<form:errors path="content"></form:errors>
			<form:input path="content"></form:input>
		</form:label>
			<form:select path="assignee" value="${task.assignee }">
					<c:forEach items="${users}" var="user">
        			<option value="${user.name}"><c:out value="${user.name}"/> </option>
   			</c:forEach></form:select>
   				<form:select path="priority">
   				<option id="High">High</option>
        		<option id="Medium">Medium</option>
        		<option id="Low">Low</option>
        		</form:select>

		<input type="submit" value="Update" />
	</form:form>
	<form:form action="/tasks/${task.id}/delete" method="POST" modelAttribute="task" >
		<input type="submit" value="Delete" />
	</form:form>

</body>