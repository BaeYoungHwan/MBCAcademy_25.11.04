<%@page import="com.mbc.pro.dto.MemberDto"%>
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
<title>answer</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">
.mytable{
	width: 800px;
}
th{
	text-align: center;
}
#ta{  
  width: 100%;  /* 반응형 */
  field-sizing: content;
}
</style>

</head>
<body>

<%--
		기본글
			작성자
			작성일
			조회수
			제목
			내용
 --%>
 
<div align="center">

<h2>기본글</h2>

<table class="table mytable">
<col width="140px"/><col width="400px"/>

<tr>
	<th class="bg-primary text-white">작성자</th>
	<td><%=dto.getId() %></td>
</tr>
<tr>
	<th class="bg-primary text-white">작성일</th>
	<td><%=dto.getWdate() %></td>
</tr>
<tr>
	<th class="bg-primary text-white">조회수</th>
	<td><%=dto.getReadcount() %></td>
</tr>
<tr>	
	<td colspan="2" class="fw-bold fs-5"><%=dto.getTitle() %></td>
</tr>
<tr>	
	<td colspan="2">
		<textarea rows="1" cols="90" id="ta" class="form-control fs-5" readonly="readonly"><%=dto.getContent() %></textarea>
	</td>
</tr>

</table>

<h2>Answer</h2>

<%--
		답글
			로그인한 id
			제목
			내용
 --%>

<%
	MemberDto mem = (MemberDto)session.getAttribute("login");
%>

<form action="answerAf.do" method="post">

<%-- 기본글의 sequence(고유번호) --%>
<input type="hidden" name="seq" value="<%=dto.getSeq() %>"/>

<table class="table mytable">
<col width="140px"/><col width="400px"/>
<tr>
	<th>아이디</th>
	<td><%=mem.getId() %>
	<input type="hidden" name="id" value="<%=mem.getId() %>"/>
	</td>
</tr>
<tr>	
	<td colspan="2">
		<input type="text" name="title" class="form-control" placeholder="제목을 기입해 주십시오"/>
	</td>
</tr>
<tr>	
	<td colspan="2">
		<textarea rows="10" cols="50px" name="content" class="form-control" placeholder="내용을 기입해 주십시오"></textarea>
	</td>
</tr>
</table>
<input type="submit" class="btn btn-primary" value="답글쓰기"/>

</form>

</div>
<br/><br/>

</body>
</html>





