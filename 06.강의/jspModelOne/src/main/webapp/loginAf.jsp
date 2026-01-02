<%@page import="com.mbc.mvc.one.dto.MemberDto"%>
<%@page import="com.mbc.mvc.one.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	//String name = request.getParameter("name");
	//String email = request.getParameter("email");
	//System.out.println("name: " + name);
	
	MemberDao dao = MemberDao.getInstance();
	
	MemberDto mem = dao.login(id, pw);

	if(mem != null){
		// login한 사용자 정보 저장
		session.setAttribute("login", mem);
		// session.setMaxInactiveInterval(60 * 60 * 2);
		%>
		<script type="text/javascript">
		alert("<%=mem.getName() %>님 환영합니다");
		location.href="login.jsp";
		</script>
		<%
	}else{
		%>
		<script type="text/javascript">
		alert("아이디나 패스워드를 확인하십시오");
		location.href = "login.jsp";
		</script>
		<%
	}
	%>