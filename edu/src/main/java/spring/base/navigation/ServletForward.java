package spring.base.navigation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spring.service.domain.User;

/*
 * :: Servlet Navigation :: Forward
 * :: JSP Standard Action Tag : < jsp : forward page = "~~.jsp"/> �� ��
 * :: Servelt���� ������ ObjectScope�� ������ Bean�� JSP�� Forward�� ����� Bean ���� ���� Ȯ��
 * */
//@WebServlet("/ServletForward")
public class ServletForward extends HttpServlet {
	//service()
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("[ServletForward.service() start!!]");
		
		//==> Request ObjectScope ����
		request.setAttribute("uesr1", new User("ȫ�浿","1111"));
		
		//==> Session ObjectScope����
		HttpSession session = request.getSession(true);
		session.setAttribute("user02", new User("�̼���", "2222"));
		
		//==> Application ObjectScope ����
		ServletContext application = this.getServletContext();
		application.setAttribute("user03", new User("�庸��","3333"));
		
		// 1. ServletContext object ����
		ServletContext sc = this.getServletContext();
		// 2. Context���� resource �̵��� �� �ִ� ����� �����ϴ� RequestDisppatcher ��ü ����
		RequestDispatcher rd = sc.getRequestDispatcher("/02Navigation/view.jsp");
		//3.Forward
		rd.forward(request, response);
		
		System.out.println("[ServletForward.service() end.....]");
		
	}

}
