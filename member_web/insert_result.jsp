<%-- 0314 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert_result</title>
</head>
<body>
<%
String abc = request.getParameter("mid");
String irum = request.getParameter("irum");
String pwd = request.getParameter("pwd");
String phone = request.getParameter("phone");
String address = request.getParameter("address");
String addressDetail = request.getParameter("address_detail");
%>
<ol>
	<li><%=abc%></li>
	<li><%=irum%></li>
	<li><%=pwd%></li>
	<li><%=phone%></li>
	<li><%=address%></li>
	<li><%=addressDetail%></li>
</ol>

</body>
</html>