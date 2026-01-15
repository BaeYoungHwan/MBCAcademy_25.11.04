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
<title>bbsdetail</title>
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

/* text에 맞게 textarea의 크기 조절 */
textarea{  
  width: 100%;  /* 반응형 */
  field-sizing: content;
}
</style>

</head>
<body>

<div align="center">

<h2>글 상세 보기</h2>

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
	<td colspan="2" class="fw-bold fs-5">&nbsp;&nbsp;<%=dto.getTitle() %></td>
</tr>
<tr>	
	<td colspan="2">
		<textarea rows="15" cols="90" class="form-control fs-5" style="border: none" readonly="readonly"><%=dto.getContent() %></textarea>
	</td>
</tr>
</table> 
<br/>

<button type="button" class="btn btn-info text-white" onclick="answer(<%=dto.getSeq() %>)">답글</button>

<button type="button" class="btn btn-info text-white" onclick="bbslist()">글목록</button>

<%
MemberDto mem = (MemberDto)session.getAttribute("login");

if(mem.getId().equals(dto.getId())){
	%>
	<button type="button" class="btn btn-info text-white" 
				onclick="bbsupdate(<%=dto.getSeq() %>)">수정</button>
	<button type="button" class="btn btn-info text-white"
				onclick="bbsdelete(<%=dto.getSeq() %>)">삭제</button>
	<%
}
%>
</div>

<script type="text/javascript">
function bbslist() {
	location.href = "bbslist.do";	
}
function bbsupdate(seq) {
	location.href = "bbsupdate.do?seq=" + seq;
}
function bbsdelete(seq) {
	location.href = "bbsdelete.do?seq=" + seq;
}
function answer(seq) {
	location.href = "answer.do?seq=" + seq;
}
</script>

</body>
</html>




