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
	���̵� : <input id="userId" type="text" name="userId" value=""><br/><br/>
	�н����� : <input id="userId" type="text" name="userPasswd" value=""><br/><br/>
	<input id="submit" type="submit" name="submit" value="Enter"/>
		
	</form>

<% }else{ %>
<% //}else{ %>

<%= userVO.getUserId() %> ���� �̹� �α����ϼ̽��ϴ�.
<%-- <%= userVO.getUserId() %> ���� �̹� �α����ϼ̽��ϴ�. --%>
<%} %>
<%//} %>

</body>
</html>