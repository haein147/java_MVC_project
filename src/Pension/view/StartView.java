package Pension.view;

import java.util.Scanner;

import Pension.service.pensionController;
import Scanner.ScannerDriver;

public class StartView {
	public static void main(String[] args) {
		pensionController pc = new pensionController();
		Scanner s = ScannerDriver.getScanner();
		int reserveNo;
		String customerName;
		String reserveDate;
		String reserveHow;
		String roomName;
		int payNo;
		String customerId;
		String customerTel;
		String customerBank;
		int customerAge;


		while (true) {
			System.out.println("=============================================");
			System.out.println(" 1. 예약 조회   2. 고객 조회   3. 객실 조회   4. 결제 정보 조회 ");
			System.out.println(" 5. 고객 추가   6. 고객 수정   7. 고객 삭제  ");
			System.out.println("=============================================");
			System.out.print("번호를 입력해주세요 : ");
			int m1 = s.nextInt();

			switch (m1) {

			case 1:
				pc.getAllReserve();
				/*reserveNo = s.nextInt();
				pc.getReserve(reserveNo);*/

				break;
			case 2:
				pc.getAllCustomer();
				/*customerName = s.next();
				pc.getCustomer(customerName);*/
				break;
			case 3:
				pc.getAllRoom();
				/*roomName = s.next();
				pc.getRoom(roomName);*/
				break;
			case 4:
				pc.getAllPay();
				/*payNo = s.nextInt();
				pc.getPay(payNo);*/
				break;

			case 5:
				// 고객 추가
				System.out.println("추가 : 고객 이름, ID, 전화번호, 계좌번호, 연령대");
				customerName = s.next();
				customerId = s.next();
				customerTel = s.next();
				customerBank = s.next();
				customerAge = s.nextInt();
				pc.addCustomer(customerName, customerId, customerTel, customerBank, customerAge);
				break;
			case 6:
				// 고객 수정
				System.out.print("이름 :  ");
				customerName = s.next();
				System.out.print("수정 할 전화번호 :  ");
				customerTel = s.next();
				System.out.print("수정 할 계좌번호 :  ");
				customerBank = s.next();
				pc.updateCustomer(customerTel, customerBank, customerName);
				break;
			case 7:
				// 고객 삭제
				System.out.print("고객 이름 :  ");
				customerName = s.next();
				pc.deleteCustomer(customerName);
				break;

			}
		}
	}
}
