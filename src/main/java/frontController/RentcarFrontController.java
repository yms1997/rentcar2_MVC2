package frontController;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class RentcarFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // 한글깨짐방지
		
		String url = req.getRequestURI();
		String ctx = req.getContextPath();
		
		String command = url.substring(ctx.length());
		frontController.Controller controller = null;
		String nextPage = null;
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		nextPage = controller.requestHandler(req, res);
		
		
		if(nextPage != null) {
			if(nextPage.indexOf("redirect:") != -1) {
				res.sendRedirect(nextPage.split(":")[1]);
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher(ViewResolver.makeView(nextPage)); // forward
				rd.forward(req, res);
			}
		}
	}

}
