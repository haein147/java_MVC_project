/*CREATE TABLE reserve (
	       reserve_no           NUMBER(5)  PRIMARY KEY,
	       customer_name         VARCHAR2(10) NOT NULL,
	       reserve_date         DATE NOT NULL,
	       reserve_how          VARCHAR2(30) NOT NULL,
	       room_name            VARCHAR2(20) NOT NULL,
	       pay_no               NUMBER(5) NOT NULL
	 );
*/
package Pension.model.DTO;

import java.sql.Date;

public class reserveDTO {
	private int reserveNo;
	private String customerName;
	private Date reserveDate;
	private String reserveHow;
	private String roomName; 
	private int payNo;
	public reserveDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public reserveDTO(int reserveNo, String customerName, Date reserveDate, String reserveHow, String roomName,
			int payNo) {
		super();
		this.reserveNo = reserveNo;
		this.customerName = customerName;
		this.reserveDate = reserveDate;
		this.reserveHow = reserveHow; 
		this.roomName = roomName;
		this.payNo = payNo;
	}
	public int getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(int reserveNo) {
		this.reserveNo = reserveNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}
	public String getReserveHow() {
		return reserveHow;
	}
	public void setReserveHow(String reserveHow) {
		this.reserveHow = reserveHow;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getPayNo() {
		return payNo;
	}
	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}
	@Override
	public String toString() {
		return "예약 번호 : " + reserveNo + ", 고객 이름 : " + customerName + ", 예약 날짜 : " + reserveDate
				+ ", 예약 방법 : " + reserveHow + ", 객실 이름 : " + roomName + ", 결제 번호 : " + payNo + "\n";
	}



}
