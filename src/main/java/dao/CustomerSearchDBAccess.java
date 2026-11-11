package dao;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//dao定義
public class CustomerSearchDBAccess {
	//DBと接続
	private Connection createConnection() {
		Connection con = null;
		try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(
						"jdbc:mysql://localhost:65534/kidda_la",
						"user1",
						"pass1"
						);
		}catch(ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("DB接続時にエラーが発生しました。");
			e.printStackTrace();
		}
		return con;
	}
	//DBとの接続を閉じる
	private void closeConnection(Connection con) {
		try {
			if(con != null) {
				con.close();
			}
		}catch(SQLException e) {
			System.out.println("DB切断時にエラーが発生しました。");
			e.printStackTrace();
		}
	}
	//電話番号で検索
	public ArrayList<Customer> searchCustomerByTel(int Tel) throws SQLException{
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			if(con !=null) {
				String sql = "SELECT *" +
							"FROM CUSTOMER WHILE tel = ?;";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next() == true) {
					int custId =rs.getInt("CUST ID");
					String custName = rs.getString("CUSTNAME");
					String kana = rs.getString("KANA");
					String address = rs.getString("ADDRESS");
					Customer customer = new Customer(custId, custName, kana, address);
					list.add(customer);
				}
			}
		}catch(SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		}
	}
	//カナで検索
	public ArrayList<Customer> searchCustomerByKana(String Kana) throws SQLException{
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			if(con !=null) {
				String sql = "SELECT *" +
							"FROM CUSTOMER WHILE kana = ?;";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next() == true) {
					int custId =rs.getInt("CUST ID");
					String custName = rs.getString("CUSTNAME");
					String kana = rs.getString("KANA");
					String address = rs.getString("ADDRESS");
					Customer customer = new Customer(custId, custName, kana, address);
					list.add(customer);
				}
			}
		}catch(SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Customer> searchCustomer(int Tel, String Kana) throws SQLException{
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			if(con !=null) {
				String sql = "SELECT *" +
							"FROM CUSTOMER WHILE kana = ? AND tel = ?;";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next() == true) {
					int custId =rs.getInt("CUST ID");
					String custName = rs.getString("CUSTNAME");
					String kana = rs.getString("KANA");
					String address = rs.getString("ADDRESS");
					Customer customer = new Customer(custId, custName, kana, address);
					list.add(customer);
				}
			}
		}catch(SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		}
	}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
			}catch(SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if(pstmt !=null) {
					pstmt.close();
				}
			}catch(SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		void closeConnection(con);
		return list;
	}



