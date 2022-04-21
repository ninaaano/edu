package jw02;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PostDataATagServletMapping extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		//client form data �ѱ۵��ڵ�
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
		out.println("<head><title>GetData.java</title></head>");
		out.println("<body>");
		
		out.println("<h2>GetTset</h2>");
		out.println("<li>�̸� : " + clientName);
		out.println("<li>�ּ� : " + clientAddr);
		
		//==> </a> �±׸� �̿��Ͽ� Query���ڿ� ����
		out.println("<p><p><a href='/edu/PostDataATagServletMapping?name=ȫ�浿&addr=����'>�ڱ��ڽ�</a>");
		
		out.println("</body>");
		out.println("</html>");
		
	}

}
