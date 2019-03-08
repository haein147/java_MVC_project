/*
 * CREATE TABLE pay ( //INSERT, 검색, 삭제
      pay_no           NUMBER(5) PRIMARY KEY,
      pay_how          VARCHAR2(30) NOT NULL
);
 * 
 */

package Pension.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Pension.model.DTO.customerDTO;
import Pension.model.DTO.payDTO;
import Pension.model.DTO.reserveDTO;
import Pension.model.util.DBUtil;

public class payDAO {
	
	public static payDTO getPay(int payNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		payDTO user = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from pay where pay_no =?");
			pstmt.setInt(1, payNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				user = new payDTO(rset.getInt(1), rset.getString(2), rset.getString(3));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return user;
	}
   public static boolean addPay(payDTO pay) throws SQLException{
         Connection con = null;
         PreparedStatement pstmt = null;
         try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement("insert into pay values(?, ?, ?)");
            pstmt.setInt(1, pay.getPayNo());
            pstmt.setString(2, pay.getPayHow());
            pstmt.setString(3, pay.getPay());
            
            int result = pstmt.executeUpdate();
            
            if(result == 1) {
               return true;
            }
         } catch(SQLException s) {
            s.printStackTrace();
            throw s;
         }finally {
            DBUtil.close(con, pstmt);
         }
         return false;
      }
   public static boolean updatePay(String payHow, String price, int payNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update pay set pay_how=?, price =?"
					+ " where pay_no=?");
			pstmt.setString(1, payHow);
			pstmt.setString(2, price);
			pstmt.setInt(3, payNo);

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
   public static boolean deletePay(int payNo) throws SQLException{
      Connection con = null;
      PreparedStatement pstmt = null;
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("delete from pay where pay_no=?");
         pstmt.setInt(1, payNo);
         int result = pstmt.executeUpdate();
         if(result == 1) {
            return true;
         }
      } catch(SQLException s) {
         s.printStackTrace();
         throw s;
      }finally {
         DBUtil.close(con, pstmt);
      }
      return false;
   }
      public static ArrayList<payDTO> getAllPay() throws SQLException{
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rset = null;
         ArrayList<payDTO> list = null;
         try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement("select * from pay");
            rset = pstmt.executeQuery();
            
            list = new ArrayList<payDTO>();
            while(rset.next()) {
               list.add(new payDTO(rset.getInt(1), rset.getString(2), rset.getString(3)));
            }
         }catch(SQLException s) {
            s.printStackTrace();
            throw s;
         }finally {
            DBUtil.close(con, pstmt, rset);
         }
         return list;
      }
   }
   
