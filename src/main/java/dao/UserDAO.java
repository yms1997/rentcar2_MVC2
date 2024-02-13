package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private UserDAO() {
	}

	static private UserDAO instance;

	static public UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}
	
	private Connection conn; // db 객체
	private PreparedStatement ps; // 쿼리문 객체
	private ResultSet rs; // 뷰테이블 객체
	
	private void getConnect() {
		String url = "jdbc:mysql://localhost:3306/rentcardb01?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연동실패");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("driver 클래스 찾지 못함 ");
		}
	}
}
