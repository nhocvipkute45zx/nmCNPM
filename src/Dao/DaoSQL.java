package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.User2;


public class DaoSQL {
	private Connection con;
	public DaoSQL() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=nmCNPM;integratedSecurity=true;";
			con = DriverManager.getConnection(connectionUrl);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean checkMailexit(String email) {
		String sql = "select MaUser, Email from [dbo].[User] where Email = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			return ps.executeQuery().next();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	public boolean checkSDTexit(String sdt) {
		String sql = "select MaUser, Sđt from [dbo].[User] where Sđt = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sdt);
			return ps.executeQuery().next();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean add(User2 cus) {
		String sql = "INSERT INTO [dbo].[User](TenUser, Email, Sđt, Pass) VALUES(?,?,?,?)";
		try {
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, cus.getTenUser());
			pr.setString(2, cus.getEmail());
			pr.setString(3, cus.getSdt());
			pr.setString(4, cus.getPass());
			return pr.executeUpdate() == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//4.
	public boolean checkUserEmail(String email, String password) {
		//tạo biến b
		boolean b = false;
		//Lấy dữ liệu từ Database với điều kiện WHERE.....
		String sql = "SELECT * FROM [dbo].[User] WHERE email='" + email + "' AND Pass='" + password + "'";
		try {
			//thực thi truy vấn câu lệnh câu lệnh
			PreparedStatement pr = con.prepareStatement(sql);
			//pr.excuteQuery() thực thi câu lệnh trả về một Resultset
			ResultSet result = pr.executeQuery();
			//result.next() kiểm tra có record nào không. nếu có thì trả b về true
			b = result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//nếu không có thì trả b về false
		return b;
	}
	//sdt  tương tự nha
	public boolean checkUserSdt(String sdt, String password) {
		boolean b = false;
		String sql = "SELECT * FROM [dbo].[User] WHERE Sđt='" + sdt + "' AND Pass='" + password + "'";
		try {
			PreparedStatement pr = con.prepareStatement(sql);
			ResultSet result = pr.executeQuery();
			b = result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	public User2 getCustomerBYEmail(String email) {
		String sql = "Select * from [dbo].[User] where Email='" + email + "'";
		User2 cus = new User2();
		try {
			PreparedStatement pr = con.prepareStatement(sql);
			ResultSet result = pr.executeQuery();
			while (result.next()) {
				cus.setMaUser(result.getInt("MaUser"));
				cus.setTenUser(result.getString("TenUser"));
				cus.setEmail(result.getString("Email").trim());
				cus.setSdt(result.getString("Sđt"));
				cus.setPass(result.getString("Pass").trim());
				return cus;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
