package com.ncs.test.member.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Member {
	
	
	//- Member 클래스의 필드 (생성자, get/setter, toString 작성)
//	CREATE TABLE MEMBER(
//			MEMBER_ID VARCHAR2(30) PRIMARY KEY,
//			MEMBER_PWD VARCHAR2(100) NOT NULL,
//			MEMBER_NM VARCHAR2(15) NOT NULL,
//			MEMBER_ENROLL_DT DATE DEFAULT SYSDATE
	

		private String memberId;
		private String memberPwd;
		private String memberName;
		private Date memberEnrollDate;
	
		
		@Override
		public String toString() {
			return "Member []";
		}
}
