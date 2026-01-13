<%@page import="com.mbc.pro.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<MemberDto> list = (List<MemberDto>)request.getAttribute("list");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>

<h2>Hello</h2>

<table border="1">
<tr>
	<th>id</th><th>password</th><th>name</th><th>email</th>
</tr>
<%
	for(MemberDto m : list){
	%>
	<tr>
		<td><%=m.getId() %></td>
		<td><%=m.getPw() %></td>
		<td><%=m.getName() %></td>
		<td><%=m.getEmail() %></td>	
	</tr>
	<%
	}
%>
</table>



</body>
</html>










