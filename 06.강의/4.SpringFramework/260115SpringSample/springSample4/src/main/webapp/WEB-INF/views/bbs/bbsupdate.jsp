<%@page import="com.mbc.pro.dto.BbsDto"%>
<%@page import="com.mbc.pro.dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	BbsDto dto = (BbsDto)request.getAttribute("dto");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bbsupdate</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">
.mytable{
	width: 800px;
}
</style>

</head>
<body>

<h2>글 수정</h2>

<div align="center">

<form action="bbsupdateAf.do" method="post">

<input type="hidden" name="seq" value="<%=dto.getSeq() %>"/>

<table class="table mytable">
<col width="200"/><col width="400"/>
<tr>
	<th>아이디</th>
	<td>
		<input type="text" class="form-control" value="<%=dto.getId() %>" readonly="readonly"/>
	</td>
</tr>
<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" class="form-control" value="<%=dto.getTitle() %>"/>
	</td>
</tr>
<tr>
	<th>내용</th>
	<td>
		<textarea rows="20" cols="50px" class="form-control" name="content"><%=dto.getContent() %></textarea>
	</td>
</tr>
</table>
<br/>
<button type="submit" class="btn btn-primary" >수정완료</button>
</form>
</div>

</body>
</html>





