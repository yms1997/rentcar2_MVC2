package frontController;

import java.util.HashMap;

import UserController.LoginOutController;
import UserController.LogincheckController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/memberLogin.do", new LogincheckController());
		mappings.put("/memberLogout.do", new LoginOutController());
	}
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
