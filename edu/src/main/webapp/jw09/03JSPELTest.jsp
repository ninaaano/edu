<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("euc_kr");%>

requestURI: ${pageContext.request.requestURI }<br/>
pageContextEl session id: ${pagecontext.session.id}<br/>

�̸�:<%=request.getParameterValues("name")%>

�ּ�:${param.addr}<br/>

${paramValues.sw[1]}<br/>
${paramValues.sw[2]}<br/><hr/>

��Ű ���� name:${cookie.JSESSIONID.name}<br/>
��� ���� value:${cookie.JSESSIONID.value}