<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <!-- ����� �κ� 
    �� Model2 Web Arch.���� �� :: JSP�� View ����
    �� Work Flow Control �� Controller���
    �� �Ʒ��� �ּ�: Controller����ϴ� ControlServlet ���� ó��
    -->
    
    <%
    //UserVO userVO = (UserVO)session.getAttribute("userVO");
    %>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%//if(userVO==null|| userVO.isActive()!=ture){ %>
<!-- ����� �κ� -->
<!-- <form id="login" method="post" action ="/011model1/user/logonAction.jsp"> -->
<!-- ////////////////////// -->
<form id="login"method="post" action="/012model2/logonAction.do">
	���̵�:<input id="userId" type="text" name="userId" value=""><br/><br/>
	���̵�:<input id="userId" type="text" name="userPasswd" value=""><br/><br/>
	<input id="submin" type="submin" name="submin" value="Enter"/>
</form>
<%//}else{ %>
<%--<%=userVO.getUserId() %> ���� �̹� �α��� �ϼ˽��ϴ�.--%>
<%//} %>
</body>
</html>