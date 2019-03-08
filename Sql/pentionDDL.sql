-- ����
DROP TABLE reserve cascade constraint;

-- ��
DROP TABLE room cascade constraint;

-- ��
DROP TABLE customer cascade constraint;

-- ����
DROP TABLE pay cascade constraint;

CREATE TABLE reserve (
	       reserve_no           NUMBER(5)  PRIMARY KEY,
	       customer_name         VARCHAR2(10) NOT NULL,
	       reserve_date         DATE,
	       reserve_how          VARCHAR2(30),
	       room_name            VARCHAR2(20) NOT NULL,
	       pay_no               NUMBER(5) NOT NULL
	 );
CREATE TABLE room (
       room_name            VARCHAR2(20) PRIMARY KEY,
       room_limit            NUMBER(2),
       clean_ok            VARCHAR2(20)
);


CREATE TABLE customer (
       customer_name     VARCHAR2(10) PRIMARY KEY,
       customer_id        VARCHAR2(20),
       customer_tel     VARCHAR2(50),
       customer_bank     VARCHAR2(50),
       customer_age     NUMBER(5)
);
CREATE TABLE pay (
      pay_no           NUMBER(5) PRIMARY KEY,
      pay_how          VARCHAR2(30),
      price			   VARCHAR2(30)
);
--�� ���� ������ ����Ǵ� ������̺�
CREATE TABLE back_customer (
       customer_name     VARCHAR2(10) PRIMARY KEY,
       customer_id        VARCHAR2(20),
       customer_tel     VARCHAR2(50),
       customer_bank     VARCHAR2(50),
       customer_age     NUMBER(5)
);


--�ܷ�Ű ����
ALTER TABLE reserve  ADD FOREIGN KEY (room_name) REFERENCES room(room_name);
ALTER TABLE reserve ADD FOREIGN KEY (customer_name)  REFERENCES customer(customer_name);
ALTER TABLE reserve ADD FOREIGN KEY (pay_no) REFERENCES pay(pay_no);
