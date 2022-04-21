<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="jw.services.user.vo.UserVO" %>   
<%@ page import="jw.services.user.dao.UserDAO" %>

<%
	request.setCharacterEncoding("EUC_KR");
	
	//client���� �Ѿ�� ���� ����.
	String id = request.getParameter("id");
	//==>id�� null�ΰ��� ?
	//==><a href='/homework04/findUser.jsp'>����������2(session���)</a>
	if(id == null){
		//==>  Session�� ����� userVO instance �� id ���
		id =  ( (UserVO)session.getAttribute("userVO")).getId();
	}
	
	//DB�� �����ϴ� UserDAO�� �̿� ȸ������ select ��
	UserDAO bean = new UserDAO();
	//==> ȸ���� ������ ���� userVO intance�� �ޱ�
	UserVO userVO = bean.findUser(id);
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	</head>
	<body>
		
		<h2>��û�Ͻ� ȸ������</h2>
		<% if(userVO != null){  %>
		    no  :  <%= userVO.getNo()  %> <br/>
		    id   :  <%= userVO.getId() %> <br/>
		    pwd : <%= userVO.getPwd() %> <br/>
		<% }else{  %>
			<%= id  %> �� �ش��ϴ� data�� �����ϴ�.<br/>
		<% }  %>
		
		<br/><br/><br/>
		
	
		<a href='/homework04/jsp01/updateUserView.jsp?id=<%=userVO.getId() %>'>����������(id����)</a>
		
		<p><p>
	
		<a href='/homework04/jsp01/updateUserView.jsp'>����������(session���)</a>

	</body>
</html>