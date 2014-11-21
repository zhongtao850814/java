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
.error {
	color: red;
}

.entryLabel {
	background-color: cyan;
}
</style>
<title>Sign Up</title>
</head>
<body>

	<form:form action="signup.request"  commandName="user">
		<table border="1">
			<tr>
				<th>&nbsp;</th>
				<th>New Employee Info</th>
			</tr>
			<tr>
				<td class="entryLabel">First name:</td>
				<td><form:input path="firstName" size="40" /> <form:errors
						path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td class="entryLabel">Last name:</td>
				<td><form:input path="lastName" size="40" /> <form:errors
						path="lastName" cssClass="error" /></td>
			</tr>
	
			<tr>
				<td><input type="submit" value="submit" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
		<a href="index.jsp">Back to MainPage</a>
	</form:form>

</body>
</html>