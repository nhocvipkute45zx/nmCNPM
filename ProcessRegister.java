package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoSQL;
import Model.User2;
import Util.Validate;

@WebServlet("/ProcessRegister")
public class ProcessRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoSQL test = new DaoSQL();

	public ProcessRegister() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User2 cus = new User2();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String sdt = request.getParameter("sđt");
		String pass = request.getParameter("password");
		String rePass = request.getParameter("Repassword");

		cus.setTenUser(name);
		cus.setEmail(email);
		cus.setSdt(sdt);
		cus.setPass(pass);

		RequestDispatcher dis = request.getRequestDispatcher("Register.jsp");
		if (name.length() < 4) {
			request.setAttribute("error", "nhập nhiều hơn 3 kí tự!");
			dis.forward(request, response);
		}
		if (!Validate.checkmail(email)) {
			request.setAttribute("error", "email có dạng nguyena@gmail.com");
			dis.forward(request, response);
		}
		if (Validate.checkSdt(sdt) == false) {
			request.setAttribute("error", "nhập sdt sai");
			dis.forward(request, response);
		}
		if (!pass.equals(rePass) || pass.length() <= 0) {
			request.setAttribute("error", "Hãy nhập lại password !");
			dis.forward(request, response);
		}
		if (test.checkMailexit(email)) {
			request.setAttribute("error", "email đã tồn tại");
			dis.forward(request, response);
		}
		if (test.checkSDTexit(sdt)) {
			request.setAttribute("error", "sđt đã tồn tại");
			dis.forward(request, response);
		} else if (test.add(cus)) {
			response.sendRedirect("Login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
