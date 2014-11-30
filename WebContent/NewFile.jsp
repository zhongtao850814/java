<%@page import="java.util.List" %>

<%@page import="java.util.ArrayList" %>   

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>CheckBox Example</title>
</head>
<body>
<h1>CheckBox Example</h1>
<%
List langLst = new ArrayList();
langLst.add("Java");
langLst.add("C");
langLst.add("C++");
langLst.add("Small Talk");
langLst.add("C#");
request.setAttribute("langLst",langLst);
%>
<form>

<input type=checkbox name='selectAllCheck' onClick='javascript:funcSelectAll()' value='Select All'>Select All </input>
<input id="access_log_time" name="" type="text" onclick="WdatePicker();"/>
<TABLE border="1">
<tr>
      <th>
           <B>Programming Language List </B>
       </th>
</tr>

<c:forEach var="item" items="${requestScope.langLst}">
    <tr>
      <td>
           <input type=checkbox name='lang' ><c:out value="${item}" /> </input>
      </td>
    </tr>
</c:forEach>

</form>

</body>

<script language="javascript">
function funcSelectAll()
{
	
  
	   for (var a=0; a < document.forms[0].lang.length; a++)        {
                 document.forms[0].lang[a].checked = document.forms[0].selectAllCheck.checked;   
                 alert(document.forms[0].lang[a].value); 
           }
        

}


</script>
<script type="text/javascript" src="jquery.min.js"  charset="UTF-8"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
</html>