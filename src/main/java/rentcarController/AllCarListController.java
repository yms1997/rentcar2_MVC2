package rentcarController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.rentCarDAO;
import frontController.Controller;
import vo.rentcarVO;

public class AllCarListController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ArrayList<rentcarVO> list = rentCarDAO.getInstance().getAllCar();
		req.setAttribute("cars", list);
		return "rentcar/rentCarAllList";
	}
}
