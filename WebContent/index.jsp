<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="myhelp.css" />
<title>MyHelp</title>
</head>
<body>
<body>
	<h1>Welcome Myhelp</h1>
	<h3>Please log in or sign up</h3></h>
	<form action="login.request"   method="post" >
	<p>
		UserName:    <input type="text" name="username" path="username"/>
	</p>
		<p>
		UserPassword:<input type="password" name="password" path="password"/>
	</p>

	<p>
		<input type="submit" name="login" value="Login">    <a href="signup.request">signup</a>
	</p>
	</form>
	
</body>
</body>
</html>