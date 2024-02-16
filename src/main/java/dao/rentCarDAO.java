package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.rentcarVO;

public class rentCarDAO {
	private rentCarDAO() {
	}

	static private rentCarDAO instance;

	static public rentCarDAO getInstance() {
		if (instance == null) {
			instance = new rentCarDAO();
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

	private void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<rentcarVO> getSelectCar() {

		ArrayList<rentcarVO> v = new ArrayList<rentcarVO>();

		try {
			getConnect();
			String sql = "SELECT * FROM rentcar ORDER BY no DESC";
			// String sql = "SELECT * FROM rentcar ORDER BY no DESC LIMIT 3";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {

				rentcarVO bean = new rentcarVO();
				bean.setNo(rs.getInt("no"));
				bean.setName(rs.getString("name"));
				bean.setCategory(rs.getInt("category"));
				bean.setPrice(rs.getInt("price"));
				bean.setUsepeople(rs.getInt("usepeople"));
				bean.setTotalQty(rs.getInt("total_qty"));
				bean.setCompany(rs.getString("company"));
				bean.setImg(rs.getString("img"));
				bean.setInfo(rs.getString("info"));

				v.add(bean);
				count++;

				if (count > 2)
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return v;
	}

	public ArrayList<rentcarVO> getAllCar() {
		ArrayList<rentcarVO> v = new ArrayList<>();

		rentcarVO bean = null;

		try {
			getConnect();
			String sql = "SELECT * FROM rentcar";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				bean = new rentcarVO();
				bean.setNo(rs.getInt("no"));
				bean.setName(rs.getString("name"));
				bean.setCategory(rs.getInt("category"));
				bean.setPrice(rs.getInt("price"));
				bean.setUsepeople(rs.getInt("usepeople"));
				bean.setTotalQty(rs.getInt("total_qty"));
				bean.setCompany(rs.getString("company"));
				bean.setImg(rs.getString("img"));
				bean.setInfo(rs.getString("info"));

				v.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return v;

	}

	public ArrayList<rentcarVO> getCategoryCar(int cate) {

		ArrayList<rentcarVO> v = new ArrayList<>();

		rentcarVO bean = null;

		try {
			getConnect();
			String sql = "SELECT * FROM rentcar WHERE category=?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, cate);

			rs = ps.executeQuery();

			while (rs.next()) {

				bean = new rentcarVO();
				bean.setNo(rs.getInt("no"));
				bean.setName(rs.getString("name"));
				bean.setCategory(rs.getInt("category"));
				bean.setPrice(rs.getInt("price"));
				bean.setUsepeople(rs.getInt("usepeople"));
				bean.setTotalQty(rs.getInt("total_qty"));
				bean.setCompany(rs.getString("company"));
				bean.setImg(rs.getString("img"));
				bean.setInfo(rs.getString("info"));

				v.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return v;
	}
}
