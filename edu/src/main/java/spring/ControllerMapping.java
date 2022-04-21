package spring;

import spring.model2.service.user.view.HomeController;
import spring.model2.service.user.view.LogonAcitonController;
import spring.model2.serivce.user.vice.LogonController;

public class ControllerMapping {
	private static ControllerMapping controllerMapping;
	
	public ControllerMapping() {
		// TODO Auto-generated constructor stub
	}
//���� �� �ڽ��� �ν��Ͻ� return �ϴ� static Mehtod
	public static ControllerMapping getInstance() {
		if(controllerMapping ==null) {
			controllerMapping = new ControllerMapping();
		}
		return controllerMapping;
	}
	
	//Clent Request Page(actionPage)�� �޾� Request ó�� Controller ���� return
	public Controller getController(String actionPage) {
		System.out.println("[ControllerMapping.getController() start....]");
		
		Controller controller =null;
		
		if(actionPage.equals("logon")) {
			controller = new LogonController();
		}else if(actionPage.equals("logonAction")) {
			controller = new LogonActionController();
		}else if(actionPage.equals("home")) {
			controller = new HomeController();
		}
		
		//==> �߰������� �߻��Ѵٸ� �Ʒ��� ���� �߰��ϸ� �ȴ�.
	/*
		}else if(actionPage.equals("member")) {
			action = new MemberAction();
		}else if(actionPage.equals("logout")) {
			action=new LogoutAction();
		}
		*/
		System.out.println("[ControllerMapping.getController() end....]");
		
		return controller;
	}
}
