<%@ page contentType="text/html;charset=EUC-KR" %>
<%
Integer count = (Integer)application.getAttribute("count");

if(count == null){
	out.println("::해당 페이지 1번째 출력::");
	application.setAttribute("count", new Integer(1));
} else {
	int changeCount = count.intValue()+1;
	out.println("::해당 페이지"+changeCount+" 번째 출력::");
	
	application.setAttribute("count", new Integer(changeCount));
}


%>