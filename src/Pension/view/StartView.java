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
			System.out.println(" 1. ���� ��ȸ   2. �� ��ȸ   3. ���� ��ȸ   4. ���� ���� ��ȸ ");
			System.out.println(" 5. �� �߰�   6. �� ����   7. �� ����  ");
			System.out.println("=============================================");
			System.out.print("��ȣ�� �Է����ּ��� : ");
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
				// �� �߰�
				System.out.println("�߰� : �� �̸�, ID, ��ȭ��ȣ, ���¹�ȣ, ���ɴ�");
				customerName = s.next();
				customerId = s.next();
				customerTel = s.next();
				customerBank = s.next();
				customerAge = s.nextInt();
				pc.addCustomer(customerName, customerId, customerTel, customerBank, customerAge);
				break;
			case 6:
				// �� ����
				System.out.print("�̸� :  ");
				customerName = s.next();
				System.out.print("���� �� ��ȭ��ȣ :  ");
				customerTel = s.next();
				System.out.print("���� �� ���¹�ȣ :  ");
				customerBank = s.next();
				pc.updateCustomer(customerTel, customerBank, customerName);
				break;
			case 7:
				// �� ����
				System.out.print("�� �̸� :  ");
				customerName = s.next();
				pc.deleteCustomer(customerName);
				break;

			}
		}
	}
}
