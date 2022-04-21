package spring;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spring.model2.control.Controller;
import spring.model2.service.user.dao.UserDao;
import spring.model2.service.user.vo.UserVO;

import jspJava.UserDao;
import jspJava.UserVO;

public class LogonActionController implements Controller{
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("[LogonActionController.execute() start....]");
		
		HttpSession session = req.getSession(true);
		
		//==>Controller :권한/인증 처리
		//==>session ObjectScope저장된 UserVO객체 이용 인증
		//==>경우1: session ObjectScope에 userVO인스턴스 생성 및 저장
		if(session.isNew()||session.getAttribute("userVO")==null) {
			session.getAttribute("userVO",new UserVO());
		}
		
		//==> 경우 2: session ObjectScope userVO추출
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		
		//==>controller: Navigation(forward/sendRedirect view page결정)
		//navigation 디폴트 페이지 지정
		String requestPage = "/user/logon.jsp";
		
		//==>UserVO.active 이용 로그인 유무 판단
		if(userVO.isActive()) {
			requestPage ="/user/home.jsp";
		}
		//==> 로그인한 회원이 아니라면
		else {
			//client form data처리
			String userId = req.getParameter("userId");
			String userPasswd = req.getParameter("userPasswd");
			
			//controller: model과 view의 연결 binding
			userVO.setUserId(userId);
			userVO.setUserPasswd(userPasswd);
		}
		
		//controller: business logic처리
		UserDao userDao = new UserDao();
		userDao.getUser(userVO);
		
		//controller navigation
		if(userVO.isActive()) {
			requestPage="/user/home.jsp";
		}
	}
	
	RequestDispatcher rd = req.getRequestDispatcher(requestPage);
	rd.forward(req,res);
	
	System.out.println("[LogonActionController.execute(0 end....]");

}
