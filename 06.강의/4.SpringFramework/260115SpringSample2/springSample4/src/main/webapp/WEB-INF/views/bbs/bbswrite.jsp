<%@page import="com.mbc.pro.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bbswrite</title>

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
<%  
// login한 유저의 id
MemberDto mem = (MemberDto)session.getAttribute("login");
if(mem == null){
	%>    
	<script type="text/javascript">
	alert('login 해 주십시오');
	location.href = "login.jsp";
	</script>
	<%
}	
%>

<h2>글쓰기</h2>

<div align="center">

<form action="bbswriteAf.do" method="post">

<table class="table mytable">
<col width="200"/><col width="400"/>
<tr>
	<th>아이디</th>
	<td>
		<input type="text" class="form-control" name="id" size="50px" value="<%=mem.getId() %>" readonly="readonly"/>
	</td>
</tr>
<tr>
	<th>제목</th>
	<td>
		<input type="text" class="form-control" name="title" size="50px"/>
	</td>
</tr>

<tr>
	<th>내용</th>
	<td>
		<textarea rows="20" class="form-control" cols="50px" name="content" placeholder="내용을 기입"></textarea>
	</td>
</tr>

</table>
<br/>
<input type="submit" class="btn btn-primary" value="글쓰기"/>
</form>

</div>

</body>
</html>







