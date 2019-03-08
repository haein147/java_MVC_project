-- 예약
DROP TABLE reserve cascade constraint;

-- 방
DROP TABLE room cascade constraint;

-- 고객
DROP TABLE customer cascade constraint;

-- 결제
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
--고객 정보 삭제시 저장되는 백업테이블
CREATE TABLE back_customer (
       customer_name     VARCHAR2(10) PRIMARY KEY,
       customer_id        VARCHAR2(20),
       customer_tel     VARCHAR2(50),
       customer_bank     VARCHAR2(50),
       customer_age     NUMBER(5)
);


--외래키 설정
ALTER TABLE reserve  ADD FOREIGN KEY (room_name) REFERENCES room(room_name);
ALTER TABLE reserve ADD FOREIGN KEY (customer_name)  REFERENCES customer(customer_name);
ALTER TABLE reserve ADD FOREIGN KEY (pay_no) REFERENCES pay(pay_no);
