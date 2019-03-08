package Pension.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Pension.model.DTO.payDTO;
import Pension.model.DTO.reserveDTO;
import Pension.model.util.DBUtil;

/*CREATE TABLE reserve (
	       reserve_no           NUMBER(5)  PRIMARY KEY,
	       customer_name         VARCHAR2(10) NOT NULL,
	       reserve_date         DATE NOT NULL,
	       reserve_how          VARCHAR2(30) NOT NULL,
	       room_name            VARCHAR2(20) NOT NULL,
	       pay_no               NUMBER(5) NOT NULL
	 );*/
public class reserveDAO {
	
	public static reserveDTO getReserve(int reserveNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		reserveDTO user = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from reserve where reserve_no =?");
			pstmt.setInt(1, reserveNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				user = new reserveDTO(rset.getInt(1), rset.getString(2), rset.getDate(3), rset.getString(4),
						rset.getString(5), rset.getInt(6));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return user;
	}
	// 예약 추가
	public static boolean addReserve(int reserveNo,String customerName, String reserveDate, String reserveHow, String roomName, int payNo ) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into reserve values(?, ?,?,?,?,?)");
			pstmt.setInt(1, reserveNo);
			pstmt.setString(2, customerName);
			pstmt.setString(3, reserveDate);
			pstmt.setString(4, reserveHow);
			pstmt.setString(5, roomName);
			pstmt.setInt(6, payNo);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 예약 name으로 방 변경
	public static boolean updateRoomName(String roomName, String customerName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update reserve set room_name = ? where customer_name = ?");
			pstmt.setString(1, roomName);
			pstmt.setString(2, customerName);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	public static boolean updatePayNo(String price, String customerName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update pay set price = ? "
					+ "where payNo = (select payNo from reserve where customer_name = ?)");
			pstmt.setString(1, price);
			pstmt.setString(2, customerName);
			
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}


	// 예약 no로 예약 취소
	public static boolean deletePensionReserve(int reserveNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from reserve where reserve_no=?");
			pstmt.setInt(1, reserveNo);
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

	// 예약자 명으로 예약테이블 검색
	public static reserveDTO selectReserveName(String customerName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		reserveDTO user = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from reserve where customer_name =?");
			pstmt.setString(1, customerName);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				user = new reserveDTO(rset.getInt(1), rset.getString(2), rset.getDate(3), rset.getString(4),
						rset.getString(5), rset.getInt(6));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return user;
	}
	// 모든 예약 검색
	public static ArrayList<reserveDTO> getAllReserve() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<reserveDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from reserve");
			rset = pstmt.executeQuery();

			list = new ArrayList<reserveDTO>();
			while (rset.next()) {
				list.add(new reserveDTO(rset.getInt(1), rset.getString(2), rset.getDate(3), rset.getString(4),
						rset.getString(5), rset.getInt(6)));
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
