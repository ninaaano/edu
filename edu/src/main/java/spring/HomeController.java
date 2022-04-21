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
		
		//controller::권한 /인증처리
		//session ObjectScope저장된UserVO객체 이용 인증
		//경우1.  session ObjectScope에 userVO 인스턴스 생성 및 저장
		if(session.isNew()||session.getAttribute("userVO")==null) {
			session.setAttribute("userVO", new UserVO());
		}
		//경우2.session ObjectScope UserVO추출
		UserVO userVO =(UserVO) session.getAttribute("userVO");
		
		//controller :navigaion
		//navigation디폴트 페이지 지정
		String requestPage = "/user/logon.jsp";
		
		//userVO.active 이용 로그인 유무판단
		if(userVO.isActive()) {
			requestPage="/use/home.jsp";
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(requestPage);
		rd.forward(req,res);
		System.out.println("[HomeController.execute(0 end....]");
		
	}

}
