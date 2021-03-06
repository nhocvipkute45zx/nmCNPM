package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.User2;
import Util.Validate;

public class DaoSQL {
	private static Connection con;
	private static User2 cus = new User2();

	public DaoSQL() {
		//kết nối data base
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
//kiểm tra mail có tồn tại
	public boolean checkMailexit(String email) {
		String sql = "select MaUser, Email from Users where Email = ?";
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
	//kiểm tra số điện thoại có tồn tại
	public boolean checkSDTexit(String sdt) {
		String sql = "select MaUser, Sđt from Users where Sđt = ?";
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
//thêm một người dùng mới vào
	public boolean add(User2 cus) {
		String sql = "INSERT INTO Users(TenUser, Email, Sđt, Pass) VALUES(?,?,?,?)";
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
// kiem tra email có trùng khớp với password
	public boolean checkUserEmail(String email, String password) {
		boolean b = false;
		String sql = "SELECT * FROM Users WHERE email='" + email + "' AND Pass='" + password + "'";
		try {
			PreparedStatement pr = con.prepareStatement(sql);
			ResultSet result = pr.executeQuery();
			b = result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	//kiem tra số điẹn thoại có trùng khớp với password
	public boolean checkUserSdt(String sdt, String password) {
		boolean b = false;
		String sql = "SELECT * FROM Users WHERE Sđt='" + sdt + "' AND Pass='" + password + "'";
		try {
			PreparedStatement pr = con.prepareStatement(sql);
			ResultSet result = pr.executeQuery();
			b = result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
