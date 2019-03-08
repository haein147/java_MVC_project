/*
CREATE TABLE room (
       room_name            VARCHAR2(20) PRIMARY KEY,
       room_limit            NUMBER(2) NOT NULL,
       clean_ok            VARCHAR2(20)
);
 수정, 삭제, INSERT, 검색
 */


package Pension.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Pension.model.DTO.roomDTO;
import Pension.model.util.DBUtil;

public class roomDAO {
	public static roomDTO getRoom(String roomName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		roomDTO room = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from room where room_name=?");
			pstmt.setString(1, roomName);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				room = new roomDTO(rset.getString(1), rset.getInt(2), rset.getString(3));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return room;
	}
   //방 추가
   public static boolean addRoom(roomDTO room) throws SQLException{
      Connection con = null;
      PreparedStatement pstmt = null;
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("insert into room values(?,?,?)");
         pstmt.setString(1, room.getRoomName());
         pstmt.setInt(2, room.getRoomLimit());
         pstmt.setString(3, room.getCleanOk());
         
         int result = pstmt.executeUpdate();
         
         if(result == 1) {
            return true;
         }
      }catch(SQLException s) {
         s.printStackTrace();
         throw s;
      } finally {
         DBUtil.close(con, pstmt);
      }
      return false;
   }   
   //방 정보 수정
   public static boolean updateRoom(roomDTO room) throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("update room set clean_ok=?  where room_name=?");
         pstmt.setString(1, room.getCleanOk());
         pstmt.setString(2, room.getRoomName());
         
         int result = pstmt.executeUpdate();
         if(result == 1) {
            return true;
         }
      }catch(SQLException s) {
         s.printStackTrace();
         throw s;
      } finally {
         DBUtil.close(con, pstmt);
      }
      return false;
   }
   //방 정보 삭제
   public static boolean deleteRoom(String roomName) throws SQLException{
      Connection con = null;
      PreparedStatement pstmt = null;
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("delete from room where room_name=?");
         pstmt.setString(1, roomName);
         int result = pstmt.executeUpdate();
         if(result == 1) {
            return true;
         }
      }catch(SQLException s) {
         s.printStackTrace();
         throw s;
      } finally {
         DBUtil.close(con, pstmt);
      }
      return false;
   }
   //모든 방 정보 검색
   public static ArrayList<roomDTO> getAllRoom() throws SQLException{
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      ArrayList<roomDTO> list = null;
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("select * from room");
         rset = pstmt.executeQuery();
         
         list = new ArrayList<roomDTO>();
         while(rset.next()) {
            list.add(new roomDTO(rset.getString(1), rset.getInt(2), rset.getString(3)));
         }
      } catch(SQLException s) {
         s.printStackTrace();
         throw s;
      } finally {
         DBUtil.close(con, pstmt, rset);
      }
      return list;
   }
}