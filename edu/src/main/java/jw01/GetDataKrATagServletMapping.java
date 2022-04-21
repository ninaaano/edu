package jw01;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetDataKrATagServletMapping extends HttpServlet {
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
	
	
	out.println("<html>");
	out.println("<head><title>GetDataKrATag.java</title></head>");
	out.println("<body>");
	
	out.println("<h2>GetTset</h2>");
	out.println("<li>�̸� : " + clientName);
	out.println("<li>�ּ� : " + clientAddr);
	
	//==> </a> �±׸� �̿��Ͽ� Query���ڿ� ����
	out.println("<p><p><a href='/edu/GetDataKrATagServletMapping?name=ȫ�浿&addr=����'>�ڱ��ڽ�</a>");
	
	out.println("</body>");
	out.println("</html>");
	
	}
}
