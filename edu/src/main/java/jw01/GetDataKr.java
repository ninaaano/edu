package jw01;
//package server;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*
 * Get��� ���۵� Client Form Dataó��
 * */
public class GetDataKr extends HttpServlet {
	// 1. Client Get������� Request :: doGet() method O/R
	// 2. service() O/R����
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		/*=====================================================================
		 * ==> Tomcat 8.X�̻� Get ��� �ѱ��ذ���
		 * ==> server.xml ��������
		 * <Connector port = "8080" protocol = "HTTP/1.1"
		 * 		connection Timeout="200000"
		 * 		redirectPort = "8443"
		 * 		useBodyEncodingForURI="true"/> 	<== �߰�
		 ======================================================================*/
		req.setCharacterEncoding("EUC-KR");
		
		// �Ʒ� �� ���๮�� servlet���� client�� Html�� ���۽� �ʼ� �ڵ�
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();	
		
		// client form data(QueryString :: name = value)ó�� (APIȮ��!)
		String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");
		
		//client form ���
		System.out.println(clientName + " : " + clientAddr);
		
		/*=====================================================================
		 * ==> Tomcat 7.X ������ Get��� �ѱ��ذ���
		 * 16���� �ڵ��� client form data �ѱ� ���ڵ�
		 * String clientNameKo = this.convertKo(clientName);
		 * String clientAddrKo = convertKo(clinentAddr);
		 * //client form ���
		 * System.our.println(clientNameKo + " : " + clientAddrKo);
		 ======================================================================*/
		
		out.println("<html>");
		out.println("<head><title>GetDataKr.java</title></head>");
		out.println("<body>");
		
		out.println("<h2>GetTset</h2>");
		out.println("<li>�̸� : " + clientName);
		out.println("<li>�ּ� : " + clientAddr);
		
		out.println("<p><p><a href='/edu/getDataKr.html'>�ڷ�</a>");
		
		out.println("</body>");
		out.println("</html>");
	
	}
	
	/*=====================================================================
	 * ==> Tomcat 7.X ������ Get��� �ѱ��ذ���
	//method
	 * private String convertKo(String paramValue){
	 * 	String convertParamValue = null;
	 * 	try{
	 * 		//==> API Ȯ��
	 * 		byte[] b = paramValue.getBytes("8859_1");
	 * 		convertParamValue = new String(b, "EUC-KR");
	 * 	}catch(UnsupportedEncodingException uee){
	 * 		System.out.println("�ѱۺ�ȯ �� Exception�߻�");
	 * 		uee.printStackTeace();
	 * 	}
	 * 	return convertParamValue;
	 * }
	 ======================================================================*/
}
