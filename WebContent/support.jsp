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
 

<h2>Welcome come!  ${employee.getFirstName()} </h2> 


<form:form >

		<table border="1">
			<tr>
				<th>Ticket ID</th>
				<th>Question</th>
				<th>Answer</th>
				<th>Post time</th>
				<th>Answer time</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${opentickets}" var="ticket">
				<tr>
					<td>${ticket.id}</td>
					<td>${ticket.getQuestion() }</td>
					<td>${ticket.getAnswer() }</td>
					<td></td>
					<td></td>
					<td><a href="ticketcategory.request">details</a></td>
					<td><a href="editticketanswer.request?ticketid=${ticket.id}">edit</a></td>
					<td><a href="closequestion.request">close</a></td>
					
			</c:forEach>
		</table>
		<br />
	</form:form>


</body>
</html>