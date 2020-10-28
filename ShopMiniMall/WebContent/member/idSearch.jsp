<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
   String mesg = (String)session.getAttribute("memberAdd");
   if(mesg!=null){
%>
   <script type="text/javascript">
     alert('<%=mesg%>');
   </script>
<%
   }
%>
<form action="MemberIdSearchServlet" method="get">
	이름
	<input type="text" name = "username">
	<br> 전화번호:
	<select name="phone1">
		<option value="010">010</option>
		<option value="011">011</option>
	</select>-
	<input type="text" name="phone2">-
	<input type="text" name="phone3">
	<br> 이메일:
	<input type="text" name="email1" id="email1">@
	<input type="text" name="email2" id="email2" placeholder="직접입력">
	<input type="submit" value="메일 보내기">
</form>
</body>
</html>