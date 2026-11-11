package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;

public class CustomerSearchDBAccess {
    private Connection createConnection () throws Exception {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:65534/KIDDA_LA",
                "user1",
                "pass1"
            );
        } catch (SQLException e) {
            throw new Exception("【エラー】\nDB接続処理に失敗しました！\n管理者に連絡してください。");
        } catch (ClassNotFoundException e) {
            throw new Exception("【エラー】\nDB接続処理に失敗しました！\n管理者に連絡してください。");
        }
        return con;
    }

    private void closeConnection (Connection con) throws Exception {
        try {
            con.close();
        } catch (SQLException e) {
            throw new Exception("【エラー】\nデータベース処理失敗しました！");
        }
    }

    public ArrayList<Customer> searchCustomerByTel (String tel) throws Exception {
        String sql = "SELECT * from CUSTOMER WHERE TEL = ?";
        Connection con = this.createConnection();
        ArrayList<Customer> ret = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tel);
            ResultSet rs = stmt.executeQuery();
            while (rs.next() == true) {
                Customer cus = new Customer(
                    rs.getInt("CUSTID"),
                    rs.getString("CUSTNAME"),
                    rs.getString("KANA"),
                    rs.getString("TEL"),
                    rs.getString("ADDRESS")
                );
                ret.add(cus);
            }
        } catch (SQLException e) {
            throw new Exception("【エラー】\n顧客情報検索処理に失敗しました！\n管理者に連絡してください。");
        }
        this.closeConnection(con);
        return ret;
    }

    public ArrayList<Customer> searchCustomerByKana (String kana) throws Exception {
        String sql = "SELECT * from CUSTOMER WHERE KANA LIKE CONCAT('%', ? '%')";
        Connection con = this.createConnection();
        ArrayList<Customer> ret = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, kana);
            ResultSet rs = stmt.executeQuery();
            while (rs.next() == true) {
                Customer cus = new Customer(
                    rs.getInt("CUSTID"),
                    rs.getString("CUSTNAME"),
                    rs.getString("KANA"),
                    rs.getString("TEL"),
                    rs.getString("ADDRESS")
                );
                ret.add(cus);
            }
        } catch (SQLException e) {
            throw new Exception("【エラー】\n顧客情報検索処理に失敗しました！\n管理者に連絡してください。");
        }
        this.closeConnection(con);
        return ret;
    }

    public ArrayList<Customer> searchCustomer (String tel, String kana) throws Exception {
        String sql = "SELECT * from CUSTOMER WHERE TEL = ? AND KANA LIKE CONCAT('%', ? '%')";
        Connection con = this.createConnection();
        ArrayList<Customer> ret = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tel);
            stmt.setString(2, kana);
            ResultSet rs = stmt.executeQuery();
            while (rs.next() == true) {
                Customer cus = new Customer(
                    rs.getInt("CUSTID"),
                    rs.getString("CUSTNAME"),
                    rs.getString("KANA"),
                    rs.getString("TEL"),
                    rs.getString("ADDRESS")
                );
                ret.add(cus);
            }
        } catch (SQLException e) {
            throw new Exception("【エラー】\n顧客情報検索処理に失敗しました！\n管理者に連絡してください。");
        }
        this.closeConnection(con);
        return ret;
    }
}
