<%@page import="com.mbc.mvc.one.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String id = request.getParameter("id");

	MemberDao dao = MemberDao.getInstance();
	int count  = dao.idcheck(id);
	if(count == 1){
		out.println("No");
	}else{
		out.println("Yes");
	}
%>