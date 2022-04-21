package jw04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginBeanInitParam extends HttpServlet {
	
	//Field
	private String jdbcDriver;
	private String jdbcURL;
	private String jdbcUser;
	private String jdbcPasswd;
	
	//init() Method OverRiding
	//==>web.xml(Mata-data) ��ϵ� ��������
	//==> init() Method�� Client �� ���� request�� 1ȸ�� ȣ�� :: Servlet Life Cycle
	public void init(ServletConfig sc) throws ServletException{
		super.init(sc);
		jdbcDriver = sc.getInitParameter("jdbcDriver");
		jdbcURL = sc.getInitParameter("jdbcURL");
		jdbcUser = sc.getInitParameter("jdbcUser");
		jdbcPasswd = sc.getInitParameter("jdbcPasswd");
		
		// ==> �Ʒ��� ������ :: console Ȯ��
		System.out.println("web.xml�� ��ϵ� InitParam���� �������� Ȯ��");
		System.out.println("jdbcDriver" + jdbcDriver );
		System.out.println("jdbcURL" + jdbcURL );
		System.out.println("jdbcUser" + jdbcUser );
		System.out.println("jdbcPasswd" + jdbcPasswd );
			
	}
	
	//doPost() method OverRiding
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		req.setCharacterEncoding("EUC-KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
		// client form dataó�� 
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		// UserVO instance ���� �� Client Form Data ���� (Binding)
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setPwd(pwd);
		
		// DB���� Data �˻� �� UserVO.active true / false ����
		UserInitParamDao dao = new UserInitParamDao();
		//DB�������� driver, url, password ����
		dao.setJdbcDriver(jdbcDriver);
		dao.setJdbcURL(jdbcURL);
		dao.setJdbcUser(jdbcUser);
		dao.setJdbcPasswd(jdbcPasswd);
		
		dao.getUser(userVO);
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");

		out.println("<h2>Login ȭ��</h2>");

		if (userVO.isActive()) {
			out.println(id + "�� ȯ���մϴ�.");
		} else {
			out.println("Login ����! id, pwd�� Ȯ���ϼ���.");
		}

		out.println("<p><p><a href='/edu/jw04/LoginBeanInitParam.html'>�ڷ�</a>");
		out.println("</body>");
		out.println("</html>");

		
		
	}

}
