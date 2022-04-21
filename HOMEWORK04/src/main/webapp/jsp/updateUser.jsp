<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="jw.services.user.vo.UserVO" %>   
<%@ page import="jw.services.user.dao.UserDAO" %>

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
	userVO.setNo(no);
	
	//DB�� �����ϴ� UserDAO�� �̿� ȸ������ Insert
	UserDAO userDAO = new UserDAO();
	userDAO.updateUser(userVO);

%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	</head>
	<body>
		
		<h2>��û�Ͻ� ȸ������</h2>
		<% if(userVO.isActive() ){  %>
		    �����Ϸ� <br/>
		<% }else{  %>
			  ���� error<br/>
		<% }  %>
		
		<br/><br/><br/>
		
	</body>
</html>