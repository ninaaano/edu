package homework02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework02.UserDAO;
import homework02.UserVO;

public class AddUser extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		req.setCharacterEncoding("EUC-KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();

		// client form dataó��
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String gender = req.getParameter("gender");
		String birth = req.getParameter("birth");
		String job = req.getParameter("job");
		String tel = req.getParameter("tel");
		String addr = req.getParameter("addr");
		
		// UserVO instance ���� �� Client Form Data ���� (Binding)
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setPwd(pwd);
		userVO.setGender(gender);
		userVO.setBirth(birth);
		userVO.setJob(job);
		userVO.setTel(tel);
		userVO.setAddr(addr);
		

		// DB���� Data �˻� �� UserVO.active true / false ����
		UserDAO useDao = new UserDAO();
		useDao.addUser(userVO);

		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");

		
		// homework01.
		
		if( userVO.isActive() ){
            out.println(userVO.getId()+"�� ȯ���մϴ�.<br/>");
            req.getSession(true).setAttribute("userVO", userVO);
        }else{
            out.println("�ٽ� ������ �ּ���.<br/>");
        }
		
//		// homework02.
//		if( userVO.isActive() ){
//			out.println("ȸ������<br/>"+"���̵� : "+userVO.getId()+" ,��й�ȣ : "+userVO.getPwd()+" �Դϴ�.<br/>");
//            req.getSession(true).setAttribute("userVO", userVO);
//        }else{
//            out.println("�ٽ� ������ �ּ���.<br/>");
//        }


		out.println("<p><p><a href='homework02/findUser.html'>�� ��������</a>");
		//out.println("<p><p><a href='../homework02/FindUser'>�� ��������2</a>");
		out.println("</body>");
		out.println("</html>");

	}

}
