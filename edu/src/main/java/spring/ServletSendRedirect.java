package spring;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sprint.service.domain.User;

public class ServletSendRedirect {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//==>Request ObjectScope����
		System.out.println("user01",new User("ȫ�浿","1111"));
		
		//==>session ObjectScope����
		HttpSession session = request.getSession(true);
		session.setAttribute("user02", new User("�̼���","2222"));
		
		//=>Application ObjectScope����
		ServletContext application = this.getServletContext();
		application.setAttribute("user03", new User("�庸��","3333"));
		
		//==>Request�ٽ� ���� Request �ϴ� sendRedirect����
		response.sendRedirect("/003edu/03Navigation/view.jsp");
		
		System.out.println("[ServletSendRedirect.service() start....]");
	}

}
