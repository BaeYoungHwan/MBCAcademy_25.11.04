<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>log-in</title>

<style type="text/css">
body {
  margin: 0;
  padding: 0;
  background-color: #17a2b8;
  height: 100vh;
}
#login .container #login-row #login-column #login-box {
  /* margin-top: 120px; */
  max-width: 400px;
  height: 320px;
  border: 1px solid #9C9C9C;
  background-color: #EAEAEA;
}
#login .container #login-row #login-column #login-box #login-form {
  padding: 20px;
}
#login .container #login-row #login-column #login-box #login-form #register-link {
  margin-top: -85px;
}
</style>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>

</head>
<body>

<h2>log-in</h2>

<form action="loginAf.do" id="login-form" class="form"  method="post">

<div id="login">
    <h3 class="text-center text-white pt-5">Login form</h3>
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <!-- <form id="login-form" class="form" action="" method="post"> -->
                        <h3 class="text-center text-info">Login</h3>
                        <div class="form-group">
                            <label for="username" class="text-info">Id:</label><br>
                            <input type="text" name="id" id="id" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="password" class="text-info">Password:</label><br>
                            <input type="password" name="pw" id="password" class="form-control" value="123"/>
                        </div>
                        <div class="form-group">
                            <label for="remember-me" class="text-info"><span>Remember me</span> <span><input type="checkbox" id="chk_save_id"></span></label><br>
                            <input type="submit" class="btn btn-info btn-md" value="submit">
                        </div>
                        <div id="register-link" class="text-right" >
                            <a href="regi.do" class="text-info">회원가입</a>
                        </div>
                    <!-- </form> -->
                </div>
            </div>
        </div>
    </div>
</div>

</form>
<!-- </div> -->

<script type="text/javascript">
/*
	session: server 저장공간, login한 정보 object를 저장
	cookie: client 저장공간. id, password 저장. String 저장
*/

// cookie에서 user id를 산출
let user_id = $.cookie("user_id");
if(user_id != null){	// user id 있음
	$("#id").val(user_id);
	$("#chk_save_id").prop("checked", true);
}

$("#chk_save_id").click(function () {
	
	if($("#chk_save_id").is(":checked") == true){ // 첵크되었을 때
		
		if($("#id").val().trim() == ""){	// id가 빈문자였을 때
			alert('id를 입력해 주십시오');
			$("#chk_save_id").prop("checked", false);
		}
		else{	// cookie에 저장
			$.cookie("user_id", $("#id").val(), { expires:7, path:'/' });
		}		
	}
	else{
		$.removeCookie("user_id", { path:'/' });
	}	
});
</script>

</body>
</html>






