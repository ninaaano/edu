package homework02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import homework02.UserDAO;
import homework02.UserVO;

public class FindUser extends HttpServlet {
	

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		req.setCharacterEncoding("EUC-KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();

		// client form data처리
		String id = req.getParameter("id");
		
		if(id==null) {
			//HttpSession session = req.getsession(true);
			//id = ((UserVO)session.getAttribute("userVO")).getId();
			id=((UserVO)req.getSession(true).getAttribute("userVO")).getId();
		//System.out.println(id);
		}
		
		UserDAO userDao = new UserDAO();
		UserVO userVO = userDao.findUser(id);
			

		out.println("<html>");
		out.println("<body>");

		if(userVO!=null ){
            out.println("회원정보<br/>"+"아이디 : "+userVO.getId()+" ,비밀번호 : "+userVO.getPwd()+" 입니다.<br/>");
            out.println(userVO.getId()+"님 환영합니다.<br/> " + "입력하신 정보는 <br/>"
            		+ "<li>아이디 : " + userVO.getId() + "<br/><li>비밀번호 : "+userVO.getPwd() + "<br/><li>성별 : " + userVO.getGender()+ 
            		"<br/><li>생일 : " +userVO.getBirth()+ "<br/><li>직업 : "+userVO.getJob()+ 
            		"<br/><li>전화번호 : " + userVO.getTel()+ "<br/><li>주소 : " + userVO.getAddr()+ "</br><li> 입니다.");
                 
        }else{
            out.println("회원이 아닙니다..<br/>");
        }


		out.println("</body>");
		out.println("</html>");

	}

}