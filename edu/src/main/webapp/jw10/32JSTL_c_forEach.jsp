<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
        <% request.setCharacterEncoding("euc_kr");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var= "i" items="${paramValues.sw}" begin="0" step= "1">
 -�����Ͻ� sw�� : ${i}<br/>
</c:forEach>

<c:forEach var= "i" items="${paramValues.sw}" >
 -�����Ͻ� sw�� : ${i}<br/>
</c:forEach>

<c:forEach var= "i" items="${param}">
 -${i.key} : ${i.value }<br/>
</c:forEach>

<c:forEach var= "i" items="${param}" >
<c:if test="${!empty param.name }">
 -${param.name}���� ���̴� ${param.age}�Դϴ�.<br/>
 </c:if>
</c:forEach>

<c:forEach var= "i" items="${param}" >
<c:if test="${i.key == 'name' }">
-${param.name}���� ���̴� ${param.age}�Դϴ�.<br/>
</c:if>
</c:forEach>
