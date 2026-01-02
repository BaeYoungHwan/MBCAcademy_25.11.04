<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.center{
	margin : auto;
	width : 60%;
	border: 2px solid;
	padding: 10px;
}


</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>
</head>
<body>
<h1>login</h1>
<div class="center">
<form action="loginAf.jsp" method="post">

<table border ="1">
<tr>
	<th>ID</th>
	<td>
		<input type="text" id="id" name="id" size="20"/><br/>
		<input type="checkbox" id="chk_save_id"/>id 저장
	</td>
</tr>
<tr>
	<th>PW</th>
	<td>
		<input type="password" name="pw" size="20"/>
	</td>

</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="log-in"/> &nbsp; &nbsp; &nbsp; &nbsp;
		<a href="regi.jsp">회원가입</a>
	</td>
</tr>
</table>
</form>

<script type="text/javascript">
/*
	session : server 저장공간, login한 정보 object를 저장
	cookie : client 저장공간, id, password 저장. String 저장
 */
 
// cookie에서 user_id를 산출
let user_id = $.cookie("user_id");
if(user_id != null){
	$("#id").val(user_id);
	$("#chk_save_id").prop("checked", true);
}

$("#chk_save_id").click(function () {
	if($("#chk_save_id").is(":checked") == true){
		if($("#id").val().trim()==""){ // id가 빈문자일 경우
			alert("id를 입력해주세요");
			$("chk_save_id").prop("checked", false);
		}else{
			$.cookie("user_id", $("#id").val(), { expires:7, path:'/'})	
		}
		
	}else{
		$.removeCookie("user_id",{ path:'/'})
		
	}
})


</script>



</div>
</body>
</html>