/*CREATE TABLE customer (
       customer_name     VARCHAR2(10) PRIMARY KEY,
       customer_id        VARCHAR2(20) NOT NULL,
       customer_tel     VARCHAR2(20) NOT NULL,
       customer_bank     VARCHAR2(50),
       customer_age     NUMBER(5)
);
*/
package Pension.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Pension.model.DTO.customerDTO;
import Pension.model.util.DBUtil;

public class customerDAO {
	// 고객 추가
	public static boolean addCustomer(String customerName, String customerId, String customerTel,String customerBank, int customerAge) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into customer values(?,?,?,?,?)");
			pstmt.setString(1, customerName);
			pstmt.setString(2, customerId);
			pstmt.setString(3, customerTel);
			pstmt.setString(4, customerBank);
			pstmt.setInt(5, customerAge);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

//고객 번호로 전화번호,계좌번호 수정
	public static boolean updateCustomer(String customerTel, String customerBank, String customerName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update customer set customer_tel=?, customer_bank =?"
					+ " where customer_name=?");
			pstmt.setString(1,customerTel);
			pstmt.setString(2,customerBank);
			pstmt.setString(3,customerName );

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

//고객 삭제
	public static boolean deleteCustomer(String customerName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from customer where customer_name=?");
			pstmt.setString(1, customerName);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

//
	public static customerDTO getCustomer(String customerName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		customerDTO customer = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from customer where customer_name=?");
			pstmt.setString(1, customerName);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				customer = new customerDTO(rset.getString(1), rset.getString(2), rset.getString(3),
						rset.getString(4), rset.getInt(5));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return customer;
	}
//모든 고객 정보 검색
	public static ArrayList<customerDTO> getAllCustomer() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<customerDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from customer");
			rset = pstmt.executeQuery();

			list = new ArrayList<customerDTO>();
			while (rset.next()) {
				list.add(new customerDTO(rset.getString(1), rset.getString(2), rset.getString(3),
						rset.getString(4), rset.getInt(5)));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}