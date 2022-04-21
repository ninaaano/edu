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

/*
 * FileName:LogonController.java
 * ::Client request(logon.do)ó�� Controller
 */
public class LogonController implements Controller{
	
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		System.out.println("[LogonController.execute() start....]");
		
		HttpSession session = req.getSession(true);
		
		//==>CONTROLLER: ����/����ó��
		//=> session OvjextScope ����� UserVO ��ü �̿� ����
		//=> ��� 1. session ObjectScope�� userVO�ν��Ͻ� ���� �� ����
		if(session.isNew()||session.getAttribute("userVO")==null) {
			session.setAttribute("userVO", new UserVO());
		}
		
		//==>���2:session ObjectScope userVO����
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		
		//=> controller :navigation(forward/sendRediect view page ����)
		//Navigation ����Ʈ ������ ����
		String requestPage = "/user/logon.jsp";
		
		//==>UserVO.active�̿� �α��� ���� �Ǵ�
		if(userVO.isActive()) {
			requestPage= "/user/home.jsp";
		}
		
		//==>Controller:navigation(���� ������ pageforward)
		RequestDispatcher rd = req.getRequestDispatcher(requestPage);
		rd.forward(req,res);
		
		System.out.println("[LogonController.execute() end....]");
	}

	public LogonController() {
		// TODO Auto-generated constructor stub
	}

}
