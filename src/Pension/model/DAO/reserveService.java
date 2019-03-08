package Pension.model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import Pension.exception.NotExistException;
import Pension.model.DTO.customerDTO;
import Pension.model.DTO.payDTO;
import Pension.model.DTO.reserveDTO;
import Pension.model.DTO.roomDTO;

public class reserveService {
	
		private static reserveService instance = new reserveService();
		private reserveService(){}
		public static reserveService getInstance(){
			return instance;
		} 
		
		//customer - CRUD
		public static void notExistProbono(String customerName) throws NotExistException, SQLException{
			customerDTO customer = customerDAO.getCustomer(customerName);
			if(customer == null){
				throw new NotExistException("검색하신 예약 정보가 없습니다.");
			}
		}
		//모든 customer 정보 반환
		public static ArrayList<customerDTO> getAllCustomer() throws SQLException{
			return customerDAO.getAllCustomer();
		}
		//customer_name로 검색
		public static customerDTO getCustomer(String customerName) throws SQLException, NotExistException{
			customerDTO customer = customerDAO.getCustomer(customerName);
			if(customer == null){
				throw new NotExistException("검색하신 재능기부 정보가 없습니다.");
			}
			return customer;
		}
		//새로운 customer 저장
		public static boolean addCustomer(String customerName, String customerId, String customerTel,String customerBank, int customerAge) throws SQLException{
			return customerDAO.addCustomer(customerName,customerId,customerTel,customerBank,customerAge);
		}
		//기존 customer 수정
		public static boolean updateCustomer(String customerTel, String customerBank, String customerName) throws SQLException, NotExistException{
			notExistProbono(customerName);
			return customerDAO.updateCustomer(customerTel,customerBank,customerName);
		}
		//customer 삭제
		public boolean deleteCustomer(String customerName) throws SQLException, NotExistException{
			notExistProbono(customerName);
			return customerDAO.deleteCustomer(customerName);
		}
		
		//room - CRUD
		public static void notExistActivist(String roomName) throws NotExistException, SQLException{
			roomDTO room = roomDAO.getRoom(roomName);
			if(room == null){
				throw new NotExistException("검색하는 방이 존재하지 않습니다.");
			}
		}
		//room 정보 추가
		public static boolean addRoom(roomDTO room) throws SQLException{
			return roomDAO.addRoom(room);	
		}
		//room 정보 수정(clean_ok = ? )
		public static boolean updateRoom(roomDTO room) throws SQLException, NotExistException{
			notExistActivist(room.getRoomName());
			return roomDAO.updateRoom(room);
		}
		public static roomDTO getRoom(String roomName) throws SQLException, NotExistException{
			roomDTO room = roomDAO.getRoom(roomName);
			if(room == null){
				throw new NotExistException("검색하신 재능기부 정보가 없습니다.");
			}
			return room;
		}
		//room 정보 삭제
		public boolean deleteRoom(String roomName) throws SQLException, NotExistException{
			notExistActivist(roomName);
			return roomDAO.deleteRoom(roomName);
		}
		//모든 방 정보 검색
		public static ArrayList<roomDTO> getAllRoom() throws SQLException{
			return roomDAO.getAllRoom();
		}
		
		
		
		//pay - CRUD
		public static void notExistRecipient(int payNo) throws NotExistException, SQLException{
			payDTO pay = payDAO.getPay(payNo);
			if(pay == null){
				throw new NotExistException("검색하는 결제정보가 존재하지 않습니다.");
			}
		}
		public static boolean addPay(payDTO pay) throws SQLException{
			return payDAO.addPay(pay);
		}
		/*public static boolean updatePay(payDTO pay) throws SQLException, NotExistException{
			notExistRecipient(pay.getPayNo());
			return payDAO.updatePay(pay);
		}*/
		public boolean deletePay(int payNo) throws SQLException, NotExistException{
			notExistRecipient(payNo);
			return payDAO.deletePay(payNo);
		}
		public static payDTO getPay(int payNo) throws SQLException{
			return payDAO.getPay(payNo);
		}
		public static ArrayList<payDTO> getAllPay() throws SQLException{
			return payDAO.getAllPay();
		}
		
		public static void notExistProbonoUser(int reserveNo) throws NotExistException, SQLException{
			reserveDTO reserve = reserveDAO.getReserve(reserveNo);
			if(reserve == null){
				throw new NotExistException("검색하는 예약 정보가 존재하지 않습니다.");
			}
		}
		public static boolean addReserve(int reserveNo,String customerName, String reserveDate, String reserveHow, String roomName, int payNo ) throws SQLException{
			return reserveDAO.addReserve(reserveNo,customerName, reserveDate, reserveHow, roomName, payNo);
		}
		public static boolean updateRoomName(String customerName, String roomName) throws SQLException, NotExistException{
			return reserveDAO.updateRoomName(customerName,roomName);
		}
		public static boolean updatePayNo(String pay, String customerName) 	throws SQLException, NotExistException{
			return reserveDAO.updatePayNo(pay,customerName);
		}
		public static boolean deletePensionReserve(int reserveNo) throws SQLException, NotExistException{
			notExistProbonoUser(reserveNo);
			return reserveDAO.deletePensionReserve(reserveNo);
		}
		
		//프로보노프로젝트 id로 존재 유무 검색하는 메소드 
		public static reserveDTO getReserve(int reserveNo) throws SQLException, NotExistException{
			reserveDTO reserve = reserveDAO.getReserve(reserveNo);
			if(reserve == null){
				throw new NotExistException("검색하는 예약 정보가 존재하지 않습니다.");
			}
			return reserve;
		}
		
		public static ArrayList<reserveDTO> getAllReserve() throws SQLException{
			return reserveDAO.getAllReserve();
		}
		
		
	}


