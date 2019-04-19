package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;


/**
 * Servlet implementation class ProcessLogin
 */
@WebServlet("/ProcessLogin")
public class ProcessLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String useremail = request.getParameter("mail");
		String userpassword = request.getParameter("password");
		
		

		if (new UserDao().login(useremail, userpassword)) {
			HttpSession http = request.getSession();
			
			
			http.setAttribute("email", useremail);
			
			response.sendRedirect("index.html");
		} else {
			request.getRequestDispatcher("index.html").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
