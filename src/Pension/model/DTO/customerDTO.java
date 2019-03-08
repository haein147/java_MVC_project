/*CREATE TABLE customer (
       customer_name     VARCHAR2(10) PRIMARY KEY,
       customer_id        VARCHAR2(20) NOT NULL,
       customer_tel     VARCHAR2(20) NOT NULL,
       customer_bank     VARCHAR2(50),
       customer_age     NUMBER(5)
);*/

package Pension.model.DTO;

public class customerDTO {
	private String customerName;
	private String customerId;
	private String customerTel;
	private String customerBank;
	private int customerAge;
	public customerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public customerDTO(String customerName, String customerId, String customerTel, String customerBank,
			int customerAge) {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
		this.customerTel = customerTel;
		this.customerBank = customerBank;
		this.customerAge = customerAge;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public String getCustomerBank() {
		return customerBank;
	}
	public void setCustomerBank(String customerBank) {
		this.customerBank = customerBank;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	@Override
	public String toString() {
		return " 고객 이름 : " + customerName + ", ID : " + customerId + ", 전화번호 : "
				+ customerTel + ", 계좌번호 : " + customerBank + ", 연령: " + customerAge + "\n";
	}
	


	
}
