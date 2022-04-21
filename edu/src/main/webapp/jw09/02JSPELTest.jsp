<%@ page contentType="text/html;charset=euc-kr" %>

<%@ page import="java.util.*" %>

<h3>4. ����(. , [] ) ������ ���</h3><p/>

<%-- �Ʒ������� Servlet Controller ��  ȭ�鱸�� ���� ObjectScope �� ���� �� �� ���� ���� --%>
<%
	// 1. page ObjectScope ����
	pageContext.setAttribute("abc",new String("page ObjectScope ����� ���ڿ�"));
	
	// 2. request ObjectScope ����
	request.setAttribute("abc",new String("request ObjectScope ����� ���ڿ�"));
	
	//3.1 session ObjectScope  (size() ==0��)  ArrayList ����
	session.setAttribute("abc",new ArrayList());
	
	// 3.2 session ObjectScope ���� ���� ArrayList ����
	ArrayList arrayList =new ArrayList();
	arrayList.add( new String("ArrayList  ����� ���ڿ�") );
	session.setAttribute("def",arrayList);
	
	// 4. Application ObjectScope ���� ���� HashMap ����
	HashMap hashMap = new HashMap();
	hashMap.put("zzz",new String("HashMap ����� ���ڿ�"));
	application.setAttribute("abc",hashMap);
%>

<!-- 
   	:: EL : ��ü ������ . �� [] �����ڸ� ����
   	:: EL : ObjectScope �� ��� �� �� �ִ� ��ü������ implicit Object ���� 
		page				==>pageScope,
		request			==>requestScope
		session			==> sessionScope
		application	==>applicationScop
-->

<h5>${pageScope.abc} = ${pageScope["abc"]}

<h5>${requestScope.abc}=${requestScope["abc"]}

<h5>${empty sessionScope.abc}=${empty sessionScope["abc"]}

<h3> ${abc}</h3>