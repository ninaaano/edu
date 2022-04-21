<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="jw.service.user.vo.UserVO" %>   
<%@ page import="jw.common.dao.UserDao" %>

<%
	request.setCharacterEncoding("EUC_KR");
	
	//client���� �Ѿ�� ���� ����.
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	int no = Integer.parseInt(request.getParameter("no"));
	
	//Client�� ���� data�� UserVO instance ���� �� Value set
	UserVO userVO = new UserVO();
	userVO.setId(id);
	userVO.setPwd(pwd);
	
	
	//DB�� �����ϴ� UserDAO�� �̿� ȸ������ Insert
	UserDao userDAO = new UserDao();
	userDAO.addUser(userVO);
%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	</head>
	<body>
	
	<h2>ȸ������</h2>
	
	<%if( userVO.isActive() ){  %>
	    <%= userVO.getId()  %> �� ȯ���մϴ�.<br/>
	    <% //==> ȸ�����ԿϷ�Ǹ�... userVO instance session �� ����
		    request.getSession(true).setAttribute("userVO", userVO);
	    %>
	<% }else{  %>
	    	�ٽð����� �ּ���.<br/>
	<% }  %>
	
	<p><p><a href='/homework04/jsp01/findUserView.jsp'>����������1(id �Է�)</a>
	<p><p><a href='/homework04/jsp01/findUser.jsp'>����������2(session���)</a>
	</boyd>
	
</html>