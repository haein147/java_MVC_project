package Pension.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Pension.model.DAO.customerDAO;
import Pension.model.DAO.payDAO;
import Pension.model.DAO.reserveDAO;
import Pension.model.DAO.reserveService;
import Pension.model.DAO.roomDAO;
import Pension.model.DTO.customerDTO;
import Pension.model.DTO.payDTO;
import Pension.model.DTO.reserveDTO;
import Pension.model.DTO.roomDTO;
import Pension.view.EndView;
import Scanner.ScannerDriver;

public class pensionController {
	
	static Scanner s = ScannerDriver.getScanner();
	static reserveService instance = reserveService.getInstance();

	// 모든 예약 검색
	public static ArrayList<reserveDTO> getAllReserve() {
		ArrayList<reserveDTO> allReserve = null;
		try {
			allReserve = reserveDAO.getAllReserve();
			EndView.listView(allReserve);
			
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("모든 예약 검색시 에러 발생");
		}
		return allReserve; 
	}
	//고객명으로 예약 조회
	public static reserveDTO getReserve(int reserveNo) {
		reserveDTO reserve = null;
		try {
			
			reserve = reserveDAO.getReserve(reserveNo);
			EndView.allView(reserve);
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("고객명으로 예약테이블 검색 오류 ");
		} 
		return reserve;
	}
	//모든 고객 검색
	public static ArrayList<customerDTO> getAllCustomer(){
		ArrayList<customerDTO> allCustomer = null;
		try{
			allCustomer = customerDAO.getAllCustomer();
			EndView.listView(allCustomer);	
			
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("모든 고객 검색시 에러 발생");
		}
		return allCustomer;
	}
	//고객 이름으로 고객 정보 검색
	public static customerDTO getCustomer(String customerName) {
		customerDTO customer = null;
		try {
			
			customer = customerDAO.getCustomer(customerName);
			EndView.allView(customer);
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("고객명으로 고객 정보 검색 오류 ");
		} 
		return customer;
	}
	

	//모든 객실 정보 조회 오류
	public static ArrayList<roomDTO> getAllRoom(){
		ArrayList<roomDTO> allRoom = null;
		try{
			allRoom = roomDAO.getAllRoom();		
			EndView.listView(allRoom);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("모든 객실 정보 검색 오류");
		}
		return allRoom;
	}
	//객실 이름으로 검색
	public static roomDTO getRoom(String roomName) {
		roomDTO room = null;
		try {
			room = roomDAO.getRoom(roomName);
			EndView.allView(room);
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("객실 이름으로 객실 정보 검색 오류 ");
		} 
		return room;
	}
	//결제 정보 검색
	public static ArrayList<payDTO> getAllPay(){
		ArrayList<payDTO> allPay = null;
		try{
			allPay = payDAO.getAllPay();
			EndView.listView(allPay);	
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("모든 결제정보 검색시 에러 발생");
		}	
		return allPay;
	}
	//결제 번호로 결제정보 조회
	public static payDTO getPay(int payNo) {
		payDTO pay = null;
		try {
			
			pay = payDAO.getPay(payNo);
			EndView.allView(pay);
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("결제 번호로 결제정보 검색 오류 ");
		} 
		return pay;
	}
	//예약 추가
	public static boolean addReserve(int reserveNo,String customerName, String reserveDate, String reserveHow, String roomName, int payNo) {
		boolean result = false;
		try {
			result = reserveDAO.addReserve(reserveNo,customerName,reserveDate,reserveHow,roomName,payNo);
            System.out.println("정상적으로 추가되었습니다.");

		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("예약 추가시 에러 발생");
		}
		return result;

	}
	//고객 추가
	public static boolean addCustomer(String customerName, String customerId, String customerTel,String customerBank, int customerAge) {
		boolean result = false;
		try {
			result = customerDAO.addCustomer(customerName,customerId,customerTel,customerBank,customerAge);
			System.out.println("정상적으로 추가되었습니다.");
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("고객 추가시 에러 발생");
		}
		return result;

	}
	public static boolean updateRoomName(String roomName, String customerName){
		boolean result = false;
		try{
			result = reserveDAO.updateRoomName(roomName, customerName);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("고객 이름으로 방 수정 오류");
		}
		return result;
	}
	public static boolean updatePayNo(String price, String customerName){
		boolean result = false;
		try{
			result = reserveDAO.updatePayNo(price, customerName);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("고객 이름으로 결제 정보 수정 오류");
		}
		return result;
	}
	public static boolean updatePay(String payHow, String pay, int payNo){
		boolean result = false;
		try{
			result = payDAO.updatePay(payHow, pay, payNo);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("고객 이름으로 결제 정보 수정 오류");
		}
		return result;
	}
	//고객 번호로 전화번호,계좌번호 수정
	public static boolean updateCustomer(String customerTel, String customerBank, String customerName)
	{
		boolean result = false;
		try{
			result = customerDAO.updateCustomer(customerTel,customerBank,customerName);
			System.out.println("정상적으로 수정되었습니다.");
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("고객 이름으로 결제 정보 수정 오류");
		}
		return result;
	}
	public static boolean deleteCustomer(String customerName) {
		boolean result = false;
		try{
			result = customerDAO.deleteCustomer(customerName);
			System.out.println("정상적으로 삭제되었습니다.");
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("삭제 오류");
		}
		return result;
	}
	
	public static boolean deletePay(int payNo) {
		boolean result = false;
		try{
			result = payDAO.deletePay(payNo);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("삭제 오류");
		}
		return result;
	}
	public static boolean deleteRoom(String roomName) {
		boolean result = false;
		try{
			result = roomDAO.deleteRoom(roomName);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("삭제 오류");
		}
		return result;
	}
	public static boolean deletePensionReserve(int reserveNo) {
		boolean result = false;
		try{
			result = reserveDAO.deletePensionReserve(reserveNo);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("삭제 오류");
		}
		return result;
	}
}
