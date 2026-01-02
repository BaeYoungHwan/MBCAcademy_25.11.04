<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<style type="text/css">
.center{
	margin : auto;
	width : 60%;
	border: 2px solid;
	padding: 10px;
}


</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>

<h2>회원가입</h2>

<div class="center">

<form action="regiAf.jsp" method="post">
<table border="1">
<tr>
	<th>ID</th>
	<td>
		<input type="text" name="id" id="id" size="20"/><br/>
		<p id="idcheck" style="font-size: 8px"></p>
		<button type="button" id="id_chk_btn">id 확인</button>
	</td>
</tr>
<tr>
	<th>Password</th>
	<td>
		<input type="text" name="pw" size="20"/>
	</td>
</tr>
<tr>
	<th>이름</th>
	<td>
		<input type="text" name="name" size="20"/>
	</td>
</tr>
<tr>
	<th>이메일</th>
	<td>
		<input type="email" name="email" size="20"/>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="회원가입"/>
	</td>
</tr>
</table>

</form>

</div>

<script type="text/javascript">
$(document).ready(function () {
	
	$("#id_chk_btn").click(function () {
		
		// ajax		idcheck.jsp
		
	});	
	
});
</script>


</body>
</html>