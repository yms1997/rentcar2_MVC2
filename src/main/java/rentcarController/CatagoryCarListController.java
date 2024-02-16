package rentcarController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.rentCarDAO;
import frontController.Controller;
import vo.rentcarVO;

public class CatagoryCarListController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int category = Integer.parseInt(req.getParameter("category"));
		ArrayList<rentcarVO> list = rentCarDAO.getInstance().getCategoryCar(category);
		req.setAttribute("cars", list);
		return "rentcar/rentCarCatagoryList";
	}
}
