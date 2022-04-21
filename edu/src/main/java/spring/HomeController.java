package spring;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spring.model2.control.Controller;
import spring.model2.service.user.vo.UserVO;

import jspJava.UserVO;

public class HomeController implements Controller{
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("[HomeController.execute(0 start....]");
		HttpSession session = req.getSession(true);
		
		//controller::���� /����ó��
		//session ObjectScope�����UserVO��ü �̿� ����
		//���1.  session ObjectScope�� userVO �ν��Ͻ� ���� �� ����
		if(session.isNew()||session.getAttribute("userVO")==null) {
			session.setAttribute("userVO", new UserVO());
		}
		//���2.session ObjectScope UserVO����
		UserVO userVO =(UserVO) session.getAttribute("userVO");
		
		//controller :navigaion
		//navigation����Ʈ ������ ����
		String requestPage = "/user/logon.jsp";
		
		//userVO.active �̿� �α��� �����Ǵ�
		if(userVO.isActive()) {
			requestPage="/use/home.jsp";
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(requestPage);
		rd.forward(req,res);
		System.out.println("[HomeController.execute(0 end....]");
		
	}

}
