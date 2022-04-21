package homework01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework01.UserDAO;
import homework01.UserVO;

public class AddUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("EUC-KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();

		// client form data처리
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String gender = req.getParameter("gender");
		String birth = req.getParameter("birth");
		String job = req.getParameter("job");
		String tel = req.getParameter("tel");
		String addr = req.getParameter("addr");
		
		// UserVO instance 생성 및 Client Form Data 전달 (Binding)
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setPwd(pwd);
		userVO.setGender(gender);
		userVO.setBirth(birth);
		userVO.setJob(job);
		userVO.setTel(tel);
		userVO.setAddr(addr);
		

		// DB접근 Data 검색 비교 UserVO.active true / false 변경
		UserDAO useDao = new UserDAO();
		useDao.addUser(userVO);

		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");

		if( userVO.isActive() ){
            out.println(userVO.getId()+"님 환영합니다.<br/>");
        }else{
            out.println("다시 가입해 주세요.<br/>");
        }

		out.println("<p><p><a href='homework02/findUser.html'>내 정보보기</a>");
		out.println("</body>");
		out.println("</html>");

	}

}

