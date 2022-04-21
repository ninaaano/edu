package jw01;
//package server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

/*
 * Get��� ���۵� Client Form Dataó��
 * */
public class GetData extends HttpServlet {
	// 1. Client Get������� Request :: doGet() method O/R
	// 2. service() O/R ����
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
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

		out.println("<h2>GetTest</h2>");
		out.println("<li>�̸� : " + clientName);
		out.println("<li>�ּ� : " + clientAddr);
		
		out.println("<p><p><a href='/edu/getData.html'>�ڷ�</a>");
		
		out.println("</body>");
		out.println("</html>");
		
		
	}
}
