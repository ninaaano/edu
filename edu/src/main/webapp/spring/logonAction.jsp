<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import = "spring.model1.service.user.vo.UserVO"%>
<%@ page import = "spring.model1.service.user.dao.UserDao"%>


<%
UserVO userVO = (UserVO)session.getAttribute("userVO");
if(userVO == null){
userVO = new UserVO();
}
%>

<%if(userVO.isActive()){ %>
<jsp:forward page="home.jsp"/>
<%} %>

<%
request.setCharacterEncoding("euc-kr");

String userId = request.getParameter("userId");
String userPassswd = request.getParameter("userPAsswd");

String targetAction = "/user/logon.jsp";

userVO.setUserId("userid");
userVO.setUserPasswd("userPasswd");

UserDao userDAO = new UserDao();
userDAO.getUser(userVO);

if(userVO.isActive()){
	session.setAttribute("userVO", userVO);
	targetAction = "/user/home.jsp";
	
}

%>

<jsp:forward page = '<%targetAction %>' />