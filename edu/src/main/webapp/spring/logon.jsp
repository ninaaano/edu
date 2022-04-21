<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "spring.model1.service.user.vo.UserVO" %>

<%
UserVO userVO = (UserVO)session.getAttribute("userVO");
%>
<%
//UserVO userVO = (UserVO)session.getAttribute("userVO");
%>

<html>
<head>
<meta charset="EUC-KR">
</head>
<body>

<% if(userVO == null || userVO.isActive() != true) { %>
<% //if(userVO == null || userVO.isActive() != true) { %>
	<form id="login" method="post" action="/011model1/user/logonAction.jsp">
	<!-- <form id="login" method="post" action="/012model2/user/logonAction.do"> -->
	아이디 : <input id="userId" type="text" name="userId" value=""><br/><br/>
	패스워드 : <input id="userId" type="text" name="userPasswd" value=""><br/><br/>
	<input id="submit" type="submit" name="submit" value="Enter"/>
		
	</form>

<% }else{ %>
<% //}else{ %>

<%= userVO.getUserId() %> 님은 이미 로그인하셨습니다.
<%-- <%= userVO.getUserId() %> 님은 이미 로그인하셨습니다. --%>
<%} %>
<%//} %>

</body>
</html>