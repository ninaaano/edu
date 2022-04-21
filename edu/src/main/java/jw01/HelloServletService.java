package jw01;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServletService extends HttpServlet{
	///Field
	///Method
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{

		System.out.println("::servlet service() ����");
		System.out.println("Req IP : "+req.getRemoteAddr());

		res.setContentType("text/html;charset=EUC-KR");
		
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("Eng : Hello");
		out.println("<p>");
		out.println("Korea : ��μ���");
		out.println("</body>");
		out.println("</html>");

		System.out.println("::servlet service() ����\n");

	}//end of service
}//end of class

/* 
	1.   [TOMCAT_HONE]\webapps\examples\WEB-INF\classes  ������ copy
	2. compile
		- J2EE API  classpath ����
		 - [TOMCAT_HONE]\lib\servlet-api.jar    ==> classpath����

	3. browser ����
	    - ǥ��ȭ�� ���������� ȯ�漳�� ȭ�� web.xml ��  �Ʒ��� ���� ���(?)��..
		-  http://127.0.0.1:8080/examples/FirstServlet     �� ȣ��
*/