<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="jw.service.user.vo.UserVO" %>

<%
UserVO userVO = (UserVO)session.getAttribute("userVO");
if(userVO == null){
	userVO = new UserVO();
}
%>

<% if(!userVO.isActive()){ %>
<jsp:include page="../jw07/login.html"/>
<br/><br/>
<a href="/edu/jw07/addUser.html">ȸ������...</a>
<%}else{ %>
<%=userVO.getId() %>�� �α��� �ϼ̽��ϴ�.
<br/><br/>
<form method ="post" action="<%=request.getRequestURL() %>" >
URL:<%=request.getRequestURL() %><br/>
URI:<%=request.getRequestURI() %><br/>
<input type="submit"value="Logout"/>
</form>
<br/><br/>
<%} %>
<%--GET/Post��� �̿� ::1���� page�� 2���� ���� display --%>
<%
if(request.getMethod().equals("POST")){
	
	//logout�� 3���� ���
	
	//1.session�� ����
	//session.invalidate();
	
	//2.login������ ���� userVO session ObjectScope remove
	session.removeAttribute("userVO");
	
	//3.login������ ���� userVO Field active false
	//userVO.setActive(false)
	
	//==>logout�� �α׸� ��apge�� sendRedirect
	response.sendRedirect("/edu/jw08/logout.jsp");
}
%>
