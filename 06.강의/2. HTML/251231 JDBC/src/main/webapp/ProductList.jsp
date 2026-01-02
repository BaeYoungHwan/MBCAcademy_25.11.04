<%@page import="com.mbc.projet.dto.ProjectDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.mbc.projet.dao.ProjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProjectDAO dao = ProjectDAO.geInstance();
	List<ProjectDTO> list = dao.getList();
	
	for(ProjectDTO p : list){
		System.out.println(p.toString());
	}
%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

<h1>상품 목록</h1>
<table border="1"> 
<col width ="50"/>
<col width ="100"/>
<col width ="100"/>
<col width ="200"/>

<thead>

<tr>
<th>상품번호</th><th>상품명</th><th>가격</th><th>내용</th>
</tr>

</thead>
<tbody>
<%
for(ProjectDTO dto : list){
	
%>
	<tr>
		<td><%= dto.getProductid() %></td>
		<td><%= dto.getName() %></td>
		<td><%= dto.getPrice() %></td>
		<td><%= dto.getProduct_desc() %></td>
	</tr>
<%
}
%>

</tbody>

</table>


</body>
</html>