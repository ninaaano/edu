<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ page import = "BusinessLogicLayer.UserVO" %>
    <%@ page import = "BusinessLogicLayer.UserDAO" %>

    <%
    request.setCharacterEncoding("EUC-KR");
    
    String id =request.getParameter("id");
    UserVO userVO = new UserVO();
    
    if(id==null) {
    	session = request.getSession();
		id=((UserVO)session.getAttribute("userVO")).getId();	
	}
    
    
    UserDAO userDao = new UserDAO();
	userVO = userDao.findUser(id);
	
	%>
	
	<html>
	<head>
	<meta charset="EUC-KR">
<title>ȸ������</title>
	</head>
	<body>
	
    <% if(userVO!=null){ %>
    
    ID : <%= userVO.getId() %> <br/>
    PWD : <%= userVO.getPwd() %> <br/>
       
    <% }else{ %>
    ȸ���� �ƴմϴ�.<br/>
    
    <% } %>
  
  </body></html>


