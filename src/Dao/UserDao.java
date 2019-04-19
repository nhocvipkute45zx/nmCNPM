package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.User;

public class UserDao {
	private static Connection connection;

	public UserDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/use", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// check mail
	public boolean checkEmail(String email) {
		String select = "SELECT * FROM use WHERE email = '"+email+"'";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				connection.close();
				return true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
		
	}
	//kết thúc check mail
	public static boolean insertUser(User user) throws SQLException {
		String insert = "INSERT INTO use VALUE(null,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(insert);
		ps.setString(2,user.getName());
		ps.setString(3,user.getEmail());
		ps.setString(4,user.getSdt());
		ps.setString(5,user.getPassword());
		ps.executeUpdate();
		return true;
	}
	public boolean login(String email, String password) {
		boolean b = false;
		String sql = "SELECT * FROM use WHERE email='" + email + "' AND password='" + password + "'";
		try {
			PreparedStatement pr = connection.prepareStatement(sql);
			ResultSet result = pr.executeQuery();
			b = result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	public static void main(String[] args) {
		UserDao d = new UserDao();
	
		System.out.println(d.login("nhocvipkute45zx@gmail.com", "khoaqwe1123"));
	}
}
