<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% request.setCharacterEncoding("euc_kr");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

�̸� : ${param.name} <br/>
${param.name}�� ȯ���մϴ�<br/>

<c:set var="level" value="����" scope="session"/>
<c:if test = "${param.age<19}">
<c:set var="level" value="û�ҳ�"/>
</c:if>

${param.name}���� ���� ${param.age}�� ${level}�Դϴ�.<br/>

<c:if test = "${!empty paramValues.sw[0] }">
�����Ͻ� sw : ${paramValues.sw[0]} <br/>
</c:if>
<c:if test = "${!empty paramValues.sw[1] }">
�����Ͻ� sw : ${paramValues.sw[1]} <br/>
</c:if>
<c:if test = "${!empty paramValues.sw[2] }">
�����Ͻ� sw : ${paramValues.sw[2]} <br/>
</c:if>
<hr/>

<c:choose>
<c:when test = "${param.age>19 }">
${param.name}���� �������� ����:${param.age } <br/>
</c:when>
<c:when test = "${param.age<18 }">
${param.name}���� û�ҳ����� ����:${param.age } <br/>
</c:when>
<c:otherwise>
${param.name}���� û�ҳ�?,�? ����:${param.age } <br/>
</c:otherwise>
</c:choose>