<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.myHelp.domain.User"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html  xmlns=" http://www.w3.org/1999/xhtml">
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


<form:form  action="support.request"   method="post" >
<select name="searchoption">
<option value="all">All</option>
<option value="open">Open</option>
<option value="processing">Processing</option>
<option value="closed">Closed</option>
</select>
<input id="begin_time" name="begin" type="text" onclick="WdatePicker();"/>
<input id="end_time" name="end" type="text" onclick="WdatePicker();"/>
<input type="submit" name="search" value="search">
		<table border="1">
			<tr>
				<th>&nbsp;</th>
				<th>Ticket ID</th>
				<th>Question</th>
				<th>Answer</th>
				<th>Post time</th>
				<th>Answer time</th>
				<th>Status</th>
				<th>Category</th>
				<th>&nbsp;</th>
				
			</tr>
			<c:forEach items="${tickets}" var="ticket">
				<tr>
					<td><input type=checkbox  name='choose' id="options" value="${ticket.id}"> </td>
					<td>${ticket.id}</td>
					<td>${ticket.getQuestion() }</td>
					<td>${ticket.getAnswer() }</td>
					<td>${historys.get(ticket.id-1).getCreateTime() }</td>
					<td>${historys.get(ticket.id-1).getResolveTime() }</td>
					<c:if
						test = '${ticket.getState()==true}'>
						<td>open</td>
					</c:if>
					<c:if
						test = '${ticket.getState()==false}'>
						<td>closed</td>
					</c:if>
					<td>${ticket.getCategory() }</td>
					<td><a href="editticketanswer.request?ticketid=${ticket.id}">edit</a></td>
					
					
			</c:forEach>
		</table>
		<span STYLE="margin-left : 5px"><input type=checkbox name='selectall' id="all" onClick='javascript:funcSelectAll()'/>  select all</span>
		<span STYLE="margin-left : 320px"><input type="submit" name="close" value="close" onClick='javascript:check()'></span>
		<br />
		
	</form:form>

</body>

<script language="javascript">
function funcSelectAll()
{
	   for (var a=0; a < document.forms[0].choose.length; a++){
		   
           document.forms[0].choose[a].checked = document.forms[0].selectall.checked;   
     } 
}

function check(){
	var state=[];
	var i = 0;
	var flag = 0;
	<c:forEach var="ticket" items="${tickets}">
		state[i]=${ticket.getState()};
		i++;
	</c:forEach>
	for (var a=0; a < document.forms[0].choose.length; a++){
           if(state[a]==false&&document.forms[0].choose[a].checked==true){
        	   var b=a+1;
        	   alert("The ticket "+ b +" you have choose is already be closed");
        		document.forms[0].choose[a].checked=false;
           }   
     } 
}
</script>
<script type="text/javascript" src="jquery.min.js"  charset="UTF-8"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
</html>