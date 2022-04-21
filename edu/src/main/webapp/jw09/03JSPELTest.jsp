<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("euc_kr");%>

requestURI: ${pageContext.request.requestURI }<br/>
pageContextEl session id: ${pagecontext.session.id}<br/>

이름:<%=request.getParameterValues("name")%>

주소:${param.addr}<br/>

${paramValues.sw[1]}<br/>
${paramValues.sw[2]}<br/><hr/>

쿠키 저장 name:${cookie.JSESSIONID.name}<br/>
쿠기 저장 value:${cookie.JSESSIONID.value}