<%@ page contentType="text/html;charset=EUC-KR" %>
<br/><hr/>

<h3>
-07JSPActionIncludeParam.jsp 시작 <br/><br/>

request, session, application Object Scope Data 추출 <br/><br/>

request ObjectScope 추출 Data : <%= request.getAttribute("aaa") %><br/>
session ObjectScope 추출 Data : <%= session.getAttribute("bbb") %><br/>
application ObjectScope 추출 Data : <%= application.getAttribute("ccc") %><br/><br/>

-07JSPActionIncludeParam.jsp 끝 <br/>
</h3>
param으로 넘어온 srt값 : <%= request.getParameter("str")%><br/><br/>

<hr/><br/>