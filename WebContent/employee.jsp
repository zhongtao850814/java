<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.myHelp.domain.User"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MYHELP</title>
</head>
<body>
		<%
			//String option = request.getParameter("option");
			User user=(User)session.getAttribute("user"); 
		%>
 
<h1><% user.getId();%></h1>
<h2>Welcome come!</h2>  <h2>${employee.getFirstName()} </h2> 
<h2>${tickets.get(0).getId()}</h2>

<form:form   >

		<table border="1">
			<tr>
				<th>Ticket ID</th>
				<th>Question</th>
				<th>Answer</th>
				<th>Post time</th>
				<th>Answer time</th>
				<th>Question State</th>
				<th>Category</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${ticketHistory}" var="history">
				<tr>
					<td>${history.ticketID}</td>
					<td>${tickets.get(history.ticketID-1).getQuestion() }</td>
					<td>${tickets.get(history.ticketID-1).getAnswer() }</td>
					<td>${history.createTime}</td>
					<td>${history.resolveTime }</td>
					<c:if
						test = '${tickets.get(history.ticketID-1).getState()==true}'>
						<td>open</td>
					</c:if>
					<c:if
						test = '${tickets.get(history.ticketID-1).getState()==false}'>
						<td>closed</td>
					</c:if>
					<td>${tickets.get(history.ticketID-1).getCategory() }</td>
					<td><a href="editticketquestion.request?ticketid=${history.ticketID}">edit</a></td>
			</c:forEach>
		</table>
		<a href="createquestion.request">Question</a>
		<br />
	</form:form>


</body>
</html>