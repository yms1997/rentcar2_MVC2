package UserController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import frontController.Controller;

public class LogincheckController implements Controller{
	
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
//		System.out.println("ctx = " + ctx);
		String id = req.getParameter("id");
		if(req.getParameter("id") == null) {
			return "user/memberLogin";
		}
		String pw = req.getParameter("pw");
		int check = UserDAO.getInstance().checkLogin(id, pw);
		if(check != 0) {
			HttpSession session = req.getSession();
			session.setAttribute("log", check);
			session.setAttribute("id", id);
			return "redirect:" + ctx + "/main.jsp";
		}
		else {
			System.out.println("로그인 실패");
			return "redirect:" + ctx + "/memberLogin.do";
		}
	}
}
