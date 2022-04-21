<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import = "spring.service.domain.User"%> 

<html>
<meta charset="EUC-KR">
<body>

1. Servlet ���� Request ObjectScope ������ ���� ��� . <br/>

<% User user01 = (User)request.getAttribute("user01"); %>
<% if(user01 != null){ %>
	���̵� : <%=user01.getUserId()%><br/>
	��й�ȣ : <%=user01.getUserPasswd() %><br/>
<%} else { %>
	Request ObjectScope �� ����� ������ �����ϴ�.
<%} %>
<hr/><hr/>

2. Servlet ���� Session ObjectScope ������ ���� ��� . <br/>

<% User user02 = (User)session.getAttribute("user01"); %>
<% if(user02 != null){ %>
	���̵� : <%=user02.getUserId()%><br/>
	��й�ȣ : <%=user02.getUserPasswd() %><br/>
<%} else { %>
	Session ObjectScope �� ����� ������ �����ϴ�.
<%} %>
<hr/><hr/>

3.Servlet ���� Application ObjectScope ������ ���� ���. <br/>
<% User user03 = (User)application.getAttribute("user03"); %>
<% if(user03!=null){  %>
	���̵� : <%=user03.getUserId()%><br/>
	��й�ȣ : <%=user03.getUserPasswd() %><br/>
<%} else { %>
	Application ObjectScope �� ����� ������ �����ϴ�.
<%} %>


</body>
</html>