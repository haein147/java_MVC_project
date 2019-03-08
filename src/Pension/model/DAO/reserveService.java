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
				throw new NotExistException("�˻��Ͻ� ���� ������ �����ϴ�.");
			}
		}
		//��� customer ���� ��ȯ
		public static ArrayList<customerDTO> getAllCustomer() throws SQLException{
			return customerDAO.getAllCustomer();
		}
		//customer_name�� �˻�
		public static customerDTO getCustomer(String customerName) throws SQLException, NotExistException{
			customerDTO customer = customerDAO.getCustomer(customerName);
			if(customer == null){
				throw new NotExistException("�˻��Ͻ� ��ɱ�� ������ �����ϴ�.");
			}
			return customer;
		}
		//���ο� customer ����
		public static boolean addCustomer(String customerName, String customerId, String customerTel,String customerBank, int customerAge) throws SQLException{
			return customerDAO.addCustomer(customerName,customerId,customerTel,customerBank,customerAge);
		}
		//���� customer ����
		public static boolean updateCustomer(String customerTel, String customerBank, String customerName) throws SQLException, NotExistException{
			notExistProbono(customerName);
			return customerDAO.updateCustomer(customerTel,customerBank,customerName);
		}
		//customer ����
		public boolean deleteCustomer(String customerName) throws SQLException, NotExistException{
			notExistProbono(customerName);
			return customerDAO.deleteCustomer(customerName);
		}
		
		//room - CRUD
		public static void notExistActivist(String roomName) throws NotExistException, SQLException{
			roomDTO room = roomDAO.getRoom(roomName);
			if(room == null){
				throw new NotExistException("�˻��ϴ� ���� �������� �ʽ��ϴ�.");
			}
		}
		//room ���� �߰�
		public static boolean addRoom(roomDTO room) throws SQLException{
			return roomDAO.addRoom(room);	
		}
		//room ���� ����(clean_ok = ? )
		public static boolean updateRoom(roomDTO room) throws SQLException, NotExistException{
			notExistActivist(room.getRoomName());
			return roomDAO.updateRoom(room);
		}
		public static roomDTO getRoom(String roomName) throws SQLException, NotExistException{
			roomDTO room = roomDAO.getRoom(roomName);
			if(room == null){
				throw new NotExistException("�˻��Ͻ� ��ɱ�� ������ �����ϴ�.");
			}
			return room;
		}
		//room ���� ����
		public boolean deleteRoom(String roomName) throws SQLException, NotExistException{
			notExistActivist(roomName);
			return roomDAO.deleteRoom(roomName);
		}
		//��� �� ���� �˻�
		public static ArrayList<roomDTO> getAllRoom() throws SQLException{
			return roomDAO.getAllRoom();
		}
		
		
		
		//pay - CRUD
		public static void notExistRecipient(int payNo) throws NotExistException, SQLException{
			payDTO pay = payDAO.getPay(payNo);
			if(pay == null){
				throw new NotExistException("�˻��ϴ� ���������� �������� �ʽ��ϴ�.");
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
				throw new NotExistException("�˻��ϴ� ���� ������ �������� �ʽ��ϴ�.");
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
		
		//���κ���������Ʈ id�� ���� ���� �˻��ϴ� �޼ҵ� 
		public static reserveDTO getReserve(int reserveNo) throws SQLException, NotExistException{
			reserveDTO reserve = reserveDAO.getReserve(reserveNo);
			if(reserve == null){
				throw new NotExistException("�˻��ϴ� ���� ������ �������� �ʽ��ϴ�.");
			}
			return reserve;
		}
		
		public static ArrayList<reserveDTO> getAllReserve() throws SQLException{
			return reserveDAO.getAllReserve();
		}
		
		
	}


