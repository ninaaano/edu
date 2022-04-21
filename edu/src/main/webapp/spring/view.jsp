<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import = "spring.service.domain.User"%> 

<html>
<meta charset="EUC-KR">
<body>

1. Servlet 에서 Request ObjectScope 저장한 정보 출력 . <br/>

<% User user01 = (User)request.getAttribute("user01"); %>
<% if(user01 != null){ %>
	아이디 : <%=user01.getUserId()%><br/>
	비밀번호 : <%=user01.getUserPasswd() %><br/>
<%} else { %>
	Request ObjectScope 에 저장된 정보는 없습니다.
<%} %>
<hr/><hr/>

2. Servlet 에서 Session ObjectScope 저장한 정보 출력 . <br/>

<% User user02 = (User)session.getAttribute("user01"); %>
<% if(user02 != null){ %>
	아이디 : <%=user02.getUserId()%><br/>
	비밀번호 : <%=user02.getUserPasswd() %><br/>
<%} else { %>
	Session ObjectScope 에 저장된 정보는 없습니다.
<%} %>
<hr/><hr/>

3.Servlet 에서 Application ObjectScope 저장한 정보 출력. <br/>
<% User user03 = (User)application.getAttribute("user03"); %>
<% if(user03!=null){  %>
	아이디 : <%=user03.getUserId()%><br/>
	비밀번호 : <%=user03.getUserPasswd() %><br/>
<%} else { %>
	Application ObjectScope 에 저장된 정보는 없습니다.
<%} %>


</body>
</html>