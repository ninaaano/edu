<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@page import = "BusinessLogicLayer.UserVO" %>
<%@page import = "BusinessLogicLayer.UserDAO" %>

<%
request.setCharacterEncoding("EUC-KR");

String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String gender = request.getParameter("gender");
String birth = request.getParameter("birth");
String job = request.getParameter("job");
String tel = request.getParameter("tel");
String addr = request.getParameter("addr");

UserVO userVO = new UserVO();
userVO.setId(id);
userVO.setPwd(pwd);
userVO.setGender(gender);
userVO.setBirth(birth);
userVO.setJob(job);
userVO.setTel(tel);
userVO.setAddr(addr);

UserDAO userDao = new UserDAO();
userDao.addUser(userVO);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%if(userVO.isActive()){%>
	<%= userVO.getId() %> 님 환영합니다.<br/>
	<% request.getSession(true).setAttribute("userVO", userVO); %>
	<%}else{ %> 
	다시 입력하세요.<br/>
	<%} %>
	
	<p><p><a href='findUser.html'>내 정보보기</a>


</body>
</html>