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

		// client form dataó��
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
            out.println("ȸ������<br/>"+"���̵� : "+userVO.getId()+" ,��й�ȣ : "+userVO.getPwd()+" �Դϴ�.<br/>");
            out.println(userVO.getId()+"�� ȯ���մϴ�.<br/> " + "�Է��Ͻ� ������ <br/>"
            		+ "<li>���̵� : " + userVO.getId() + "<br/><li>��й�ȣ : "+userVO.getPwd() + "<br/><li>���� : " + userVO.getGender()+ 
            		"<br/><li>���� : " +userVO.getBirth()+ "<br/><li>���� : "+userVO.getJob()+ 
            		"<br/><li>��ȭ��ȣ : " + userVO.getTel()+ "<br/><li>�ּ� : " + userVO.getAddr()+ "</br><li> �Դϴ�.");
                 
        }else{
            out.println("ȸ���� �ƴմϴ�..<br/>");
        }


		out.println("</body>");
		out.println("</html>");

	}

}