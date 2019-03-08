/*CREATE TABLE pay (
      pay_no           NUMBER(5) PRIMARY KEY,
      pay_how          VARCHAR2(30) NOT NULL,
      pay			   VARCHAR2(30) NOT NULL
);*/

package Pension.model.DTO;

public class payDTO {
	
	private int payNo;
	private String payHow;
	private String price;
	public payDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public payDTO(int payNo, String payHow, String pay) {
		super();
		this.payNo = payNo;
		this.payHow = payHow;
		this.price = pay;
	}
	public int getPayNo() {
		return payNo;
	}
	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}
	public String getPayHow() {
		return payHow;
	}
	public void setPayHow(String payHow) {
		this.payHow = payHow;
	}
	public String getPay() {
		return price;
	}
	public void setPay(String pay) {
		this.price = pay;
	}
	@Override
	public String toString() {
		return " 결제 번호 : " + payNo + ", 결제 방법 : " + payHow + ", 금액 : " + price + "\n";
	}

		
}
