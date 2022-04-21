package jw01;
//package server;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class PostData extends HttpServlet {
	// 1. Client Post������� Request :: doPost() method O/R
	// 2. service() O/R ����
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		// res.setCharacterEncoding("~~") API Ȯ��
		// 16���� ���ڵ��� client form data �ѱ� ���ڵ�
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
		out.println("<head><title>PostData.java</title></head>");
		out.println("<body>");
		out.println("<h2>PostTset</h2>");
		out.println("<li>�̸� : " + clientName);
		out.println("<li>�ּ� : " + clientAddr);
		
		out.println("<p><p><a href='/edu/postData.html'>�ڷ�</a>");
		
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
}
