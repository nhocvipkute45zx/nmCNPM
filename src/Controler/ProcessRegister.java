package Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Dao;
import Dao.UserDao;
import Model.User;


@WebServlet("/ProcessRegister")
public class ProcessRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessRegister() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String sdt = request.getParameter("sđt");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("Repassword");
		User user = new User(name, email, sdt, password);
		boolean result = UserDao.insertUser(user);
		if (result == true) {
			response.sendRedirect("Login2.jsp");
		}
		if (result == false) {
			response.sendRedirect("Register.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}
	

}
