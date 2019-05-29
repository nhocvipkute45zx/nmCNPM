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


@WebServlet("/ProcessForgotPass")
public class ProcessForgotPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoSQL test = new DaoSQL();

	public ProcessForgotPass() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		Validate validate = new Validate();
		String useremail = request.getParameter("email");
		User2 cus = new DaoSQL().getCustomerBYEmail(useremail);
		RequestDispatcher dis = request.getRequestDispatcher("ForgotPassWord.jsp");
		if (cus != null) {
			validate.sendMail(useremail, "My password is", cus.getPass());
			response.sendRedirect("Thongbao.html");
		} else {
			request.setAttribute("error", "email không tồn tại");
			dis.forward(request, response);
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
