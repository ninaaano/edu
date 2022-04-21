<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% request.setCharacterEncoding("euc_kr");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

이름 : ${param.name} <br/>
${param.name}님 환영합니다<br/>

<c:set var="level" value="성인" scope="session"/>
<c:if test = "${param.age<19}">
<c:set var="level" value="청소년"/>
</c:if>

${param.name}님의 나이 ${param.age}로 ${level}입니다.<br/>

<c:if test = "${!empty paramValues.sw[0] }">
선택하신 sw : ${paramValues.sw[0]} <br/>
</c:if>
<c:if test = "${!empty paramValues.sw[1] }">
선택하신 sw : ${paramValues.sw[1]} <br/>
</c:if>
<c:if test = "${!empty paramValues.sw[2] }">
선택하신 sw : ${paramValues.sw[2]} <br/>
</c:if>
<hr/>

<c:choose>
<c:when test = "${param.age>19 }">
${param.name}님은 성인으로 나이:${param.age } <br/>
</c:when>
<c:when test = "${param.age<18 }">
${param.name}님은 청소년으로 나이:${param.age } <br/>
</c:when>
<c:otherwise>
${param.name}님은 청소년?,어른? 나이:${param.age } <br/>
</c:otherwise>
</c:choose>