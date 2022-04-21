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
		//==>Request ObjectScope저장
		System.out.println("user01",new User("홍길동","1111"));
		
		//==>session ObjectScope저장
		HttpSession session = request.getSession(true);
		session.setAttribute("user02", new User("이순신","2222"));
		
		//=>Application ObjectScope저장
		ServletContext application = this.getServletContext();
		application.setAttribute("user03", new User("장보고","3333"));
		
		//==>Request다시 생성 Request 하는 sendRedirect이해
		response.sendRedirect("/003edu/03Navigation/view.jsp");
		
		System.out.println("[ServletSendRedirect.service() start....]");
	}

}
