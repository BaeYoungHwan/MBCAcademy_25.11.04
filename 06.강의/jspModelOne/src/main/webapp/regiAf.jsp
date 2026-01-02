<%@page import="com.mbc.mvc.one.dto.MemberDto"%>
<%@page import="com.mbc.mvc.one.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	System.out.println("name: " + name);
	
	MemberDao  dao = MemberDao.getInstance();
	int count = dao.addMemeber(new MemberDto(id, pw, name, email, 3));
	
	if(count > 0){
%>
	<script type="text/javascript">
	alert("회원가입에서 성공했습니다.")
	location.href="login.jsp";
	</script>
<%
	}else{
%>
	<script type="text/javascript">
	alert("다시 가입해 주십시오.")
	location.href = "regi.jsp";
	</script>
<%
	}	
%>