<%@ page contentType="text/html; charset=EUC-KR" %>

<%@ page import="jw.services.user.vo.UserVO" %>   
<%@ page import="jw.services.user.dao.UserDAO" %>

<%
	request.setCharacterEncoding("EUC_KR");
	
	//client���� �Ѿ�� ���� ����.
	String id = request.getParameter("id");
	System.out.println("::"+id);
	//==>id�� null�ΰ��� ?
	//==><a href='/homework04/updateUserView.jsp'>����������2(session���)</a>
	if(id == null){
		//==>  Session�� ����� userVO instance �� id ���
		id =  ( (UserVO)session.getAttribute("userVO")).getId();
	}
	
	//DB�� �����ϴ� UserDAO�� �̿� ȸ������ select ��
	UserDAO bean = new UserDAO();
	//==> ȸ���� ������ ���� userVO intance�� �ޱ�
	UserVO userVO = bean.findUser(id);
%>
<html>
<body>

ȸ������ ����ȭ�� �Դϴ�. �����Ͻð�..... �����Ϸ�.....<br/>

	<form method="Get" action="/homework04/jsp01/updateUser.jsp">
		
		<table border="1" width="80%">
			<tr>
				<td>���̵�</td>
				<td><input type="text" name="id" value ="<%=userVO.getId() %>" /></td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td><input type="text" name="pwd" value ="<%=userVO.getPwd() %>"/></td>
			</tr>
			<tr>
				<td>����ȣ</td>
				<td><input type="text" name="no"  value="<%=userVO.getNo() %>" /> ��ȣ�� �����ϸ�ʵ�</td>
			</tr>
			<tr>
				<td colspan="2"><center><input type="submit" value="�����Ϸ�(��������)"/></center></td>
			</tr>
		</table>
		
	</form>	
	
</body>
</html>