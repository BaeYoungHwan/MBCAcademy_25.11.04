<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- message --%>

<%
// 회원가입
String message = (String)request.getAttribute("message");
if(message != null && message.equals("") == false){
	if(message.equals("MEMBER_YES")){
		%>
		<script type="text/javascript">
	   	alert("회원가입에 성공했습니다");
	   	location.href = "login.do";
	   	</script>
		<%		
	}else{
		%>
	   <script type="text/javascript">
	   alert("다시 가입해 주십시오");
	   location.href = "regi.do";
	   </script>
	   <%		
	}	
}

// login
String loginMsg = (String)request.getAttribute("loginMsg");
if(loginMsg != null && loginMsg.equals("") == false){
	if(loginMsg.equals("LOGIN_SUCCESS")){		
		%>
		<script type="text/javascript">
	   	alert("로그인에 성공했습니다");
	   	location.href = "bbslist.do";
	   	</script>
		<%
	}else{
		%>
		<script type="text/javascript">
	   alert("아이디나 패스워드를 확인해 주십시오");
	   location.href = "login.do";
	   </script>
		<%		
	}	
}

// bbswrite
String bbswriteMsg = (String)request.getAttribute("bbswriteMsg");
if(bbswriteMsg != null && !bbswriteMsg.equals("")){
	if(bbswriteMsg.equals("BBSWRITE_SUCCESS")){
		%>
		<script type="text/javascript">
	   	alert("글쓰기에 성공했습니다");
	   	location.href = "bbslist.do";
	   	</script>
		<%	
	}else{
		%>
		<script type="text/javascript">
	   	alert("다시 작성해 주십시오");
	   	location.href = "bbswrite.do";
	   	</script>
		<%
	}
}

// bbsupdate
String bbsupdateMsg = (String)request.getAttribute("bbsupdateMsg");
if(bbsupdateMsg != null && bbsupdateMsg.equals("") == false){
	Integer seq = (Integer)request.getAttribute("seq");	
	if(bbsupdateMsg.equals("UPDATE_SUCCESS")){
		%>
		<script type="text/javascript">
		alert("글이 성공적으로 수정되었습니다");
		alert(<%=seq %>);
		location.href = "bbsdetail.do?seq=" + <%=seq %>;
		</script>
		<%
	}else{		
		%>
		<script type="text/javascript">
		alert("글을 다시 수정해 주십시오");
		location.href = "bbsupdate.do?seq=" + <%=seq %>;
		</script>
		<%
	}
}

// delete
String bbsdeleteMsg = (String)request.getAttribute("bbsdeleteMsg");
if(bbsdeleteMsg != null && bbsdeleteMsg.equals("") == false){
	if(bbsdeleteMsg.equals("DELETE_SUCCESS")){
		%>
		<script type="text/javascript">
		alert("글이 성공적으로 삭제되었습니다");
		location.href = "bbslist.do";
		</script>
		<%
	}else{		
		%>
		<script type="text/javascript">
		alert("글이 삭제되지 않았습니다");
		location.href = "bbslist.do";
		</script>
		<%
	}	
}

//답글
String answerMsg = (String)request.getAttribute("answerMsg");
if(answerMsg != null && answerMsg.equals("") == false){
	if(answerMsg.equals("ANSWER_SUCCESS")){
		%>
		<script type="text/javascript">
		alert("답글이 성공적으로 추가되었습니다");
		location.href = "bbslist.do";
		</script>
		<%
	}else{		
		%>
		<script type="text/javascript">
		alert("답글을 다시 작성해 주십시오");
		location.href = "bbslist.do";
		</script>
		<%
	}
}
%>






