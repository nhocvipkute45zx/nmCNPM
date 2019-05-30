package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoSQL;
import Util.Validate;


@WebServlet("/ProcessLogin")
public class ProcessLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoSQL test = new DaoSQL();

	public ProcessLogin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		RequestDispatcher dis = request.getRequestDispatcher("Login.jsp");

		//2. get email, pass và sđt đến lớp ProcessLogin

		String email = request.getParameter("name");
		String pass = request.getParameter("password");
		String sdt = request.getParameter("name");
		
		//kết thúc lấy dữ liệu
		
		//3. checkUserEmail()(hàm kiểm tra Email có trong database không) chuyển đến DaoSQL
		
		if (test.checkUserEmail(email, pass)) {
			response.sendRedirect("index.html");
		}
		if (test.checkUserSdt(sdt, pass)) {
			response.sendRedirect("index.html");
		}
		//5. Nếu b=true thì trả về trang index.html
		// Nếu b = false thì trả về trang Login.jsp
		else if(!test.checkUserEmail(email, pass)){
			request.setAttribute("error", "thông tin đăng nhập sai");
			dis.forward(request, response);
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
