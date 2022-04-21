package spring;

import spring.model2.service.user.view.HomeController;
import spring.model2.service.user.view.LogonAcitonController;
import spring.model2.serivce.user.vice.LogonController;

public class ControllerMapping {
	private static ControllerMapping controllerMapping;
	
	public ControllerMapping() {
		// TODO Auto-generated constructor stub
	}
//동일 한 자신의 인스턴스 return 하는 static Mehtod
	public static ControllerMapping getInstance() {
		if(controllerMapping ==null) {
			controllerMapping = new ControllerMapping();
		}
		return controllerMapping;
	}
	
	//Clent Request Page(actionPage)를 받아 Request 처리 Controller 생성 return
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
		
		//==> 추가사항이 발생한다면 아래와 같이 추가하면 된다.
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
