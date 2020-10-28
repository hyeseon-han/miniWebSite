<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    MemberDTO dto = (MemberDTO)session.getAttribute("login");
    if(dto != null){
    	String username = dto.getUsername();
    %>
	안녕하세요. <%= username %>
	<a href="LogoutServlet">로그아웃</a>
	<a href="MyPageServlet">mypage</a>
	<a href="CartListServlet">장바구니목록</a>
    
    <%
    }else{
    	
    %>
    
<a href="LoginUIServlet">로그인</a>
<a href="MemberUIServlet">회원가입</a>
<%
} //end if~else
	%>
