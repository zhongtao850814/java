<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="intertech.css" />
<style type="text/css">

.entryLabel {
	background-color: cyan;
}
</style>
<title>Edit Answer</title>
</head>
<body>
	<br />
	<form:form action="editticketanswer.request" commandName="ticketanswer">
		<table border="1">
			<tr>
				<td><form:textarea path="Answer" rows="10" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
		<form:hidden path="id" />
	</form:form>
</body>
</html>