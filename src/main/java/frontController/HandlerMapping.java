package frontController;

import java.util.HashMap;

import UserController.LoginOutController;
import UserController.LogincheckController;
import rentcarController.AllCarListController;
import rentcarController.CatagoryCarListController;
import rentcarController.MainCarListController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/memberLogin.do", new LogincheckController());
		mappings.put("/memberLogout.do", new LoginOutController());
		mappings.put("/mainrentCarList.do", new MainCarListController());
		mappings.put("/rentCarAllList.do", new AllCarListController());
		mappings.put("/rentCarCatagoryList.do", new CatagoryCarListController());
	}
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
