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
<a href="/edu/jw07/addUser.html">회원가입...</a>
<%}else{ %>
<%=userVO.getId() %>님 로그인 하셨습니다.
<br/><br/>
<form method ="post" action="<%=request.getRequestURL() %>" >
URL:<%=request.getRequestURL() %><br/>
URI:<%=request.getRequestURI() %><br/>
<input type="submit"value="Logout"/>
</form>
<br/><br/>
<%} %>
<%--GET/Post방식 이용 ::1개의 page로 2개의 내용 display --%>
<%
if(request.getMethod().equals("POST")){
	
	//logout의 3가지 방법
	
	//1.session을 종료
	//session.invalidate();
	
	//2.login정보를 갖는 userVO session ObjectScope remove
	session.removeAttribute("userVO");
	
	//3.login정보를 갖는 userVO Field active false
	//userVO.setActive(false)
	
	//==>logout후 로그링 ㄴapge로 sendRedirect
	response.sendRedirect("/edu/jw08/logout.jsp");
}
%>
