<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <!-- 변경된 부분 
    ㅇ Model2 Web Arch.적용 시 :: JSP는 View 역할
    ㅇ Work Flow Control 은 Controller담당
    ㅇ 아래의 주석: Controller담당하는 ControlServlet 에서 처리
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
<!-- 변경된 부분 -->
<!-- <form id="login" method="post" action ="/011model1/user/logonAction.jsp"> -->
<!-- ////////////////////// -->
<form id="login"method="post" action="/012model2/logonAction.do">
	아이디:<input id="userId" type="text" name="userId" value=""><br/><br/>
	아이디:<input id="userId" type="text" name="userPasswd" value=""><br/><br/>
	<input id="submin" type="submin" name="submin" value="Enter"/>
</form>
<%//}else{ %>
<%--<%=userVO.getUserId() %> 님은 이미 로그인 하셧습니다.--%>
<%//} %>
</body>
</html>