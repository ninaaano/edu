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
 * ::Client request(logon.do)처리 Controller
 */
public class LogonController implements Controller{
	
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		System.out.println("[LogonController.execute() start....]");
		
		HttpSession session = req.getSession(true);
		
		//==>CONTROLLER: 권한/인증처리
		//=> session OvjextScope 저장된 UserVO 객체 이용 인증
		//=> 경우 1. session ObjectScope에 userVO인슴턴스 생성 및 저장
		if(session.isNew()||session.getAttribute("userVO")==null) {
			session.setAttribute("userVO", new UserVO());
		}
		
		//==>경우2:session ObjectScope userVO추출
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		
		//=> controller :navigation(forward/sendRediect view page 결정)
		//Navigation 디폴트 페이지 지정
		String requestPage = "/user/logon.jsp";
		
		//==>UserVO.active이용 로그인 유무 판단
		if(userVO.isActive()) {
			requestPage= "/user/home.jsp";
		}
		
		//==>Controller:navigation(최종 결정된 pageforward)
		RequestDispatcher rd = req.getRequestDispatcher(requestPage);
		rd.forward(req,res);
		
		System.out.println("[LogonController.execute() end....]");
	}

	public LogonController() {
		// TODO Auto-generated constructor stub
	}

}
