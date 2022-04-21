<%@ page contentType="text/html;charset=EUC-KR" %>
<html>
<body>

::06JSPActionIncludeParam.jsp 시작 <br/>

<% 
String value = "local variable";

request.setAttribute("aaa",value);
session.setAttribute("bbb", new String("session ObjectScope 저장된 문자열"));
application.setAttribute("ccc", new String("application ObjectScope 저장된 문자열"));
%>

<jsp:include page="07JSPActionIncludeParam.jsp">
	<jsp:param name="srt" value="<%= value %>"/>
</jsp:include>

::06JSPActionIncludeParam.jsp 끝 <br/>

</body>
</html>