<%@ page contentType="text/html;charset=EUC-KR" %>
<html>
<body>
:: 10ResponseSendredirect.jsp 시작 <br/>

<% request.setAttribute("aaa", new String("연결됨")); %>

<%response.sendRedirect("09JSPActionForward.jsp"); %>
:: 10ResponseSendredirect.jsp 끝 <br/>

</body>
</html>