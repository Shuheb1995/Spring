package com.xworkz.landrecords.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "UserRecords")
@NamedQuery(name = "ifExist" , query = "Select dto from UserDto dto where dto.email1=:eml and dto.password=:pswrd")
@NamedQuery(name = "emailExist" , query = "Select dto from UserDto dto where dto.email1=:eml")
@NamedQuery(name = "passwordExist" , query = "Select dto from UserDto dto where dto.password=:pswrd")
@NamedQuery(name = "updateOtp" , query = "update UserDto dto set dto.otp=:op where dto.email1=:eml")
@NamedQuery(name = "findOtp" , query = "Select dto from UserDto dto where dto.otp=:ot")
@NamedQuery(name = "updatePassword" , query = "update UserDto dto set dto.password=:op , dto.confirmPassword=:cp where dto.email1=:eml")

public class UserDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private String email1;
	private String mobileNumber;
	private String aadhaarNumber;
	private String password;
	private String confirmPassword;
	private String otp = null;
	
	public UserDto() {
		super();
	}
	
	public UserDto(int id, String userName, String email1, String mobileNumber, String aadhaarNumber, String password,
			String confirmPassword, String otp) {
		super();
		this.id = id;
		this.userName = userName;
		this.email1 = email1;
		this.mobileNumber = mobileNumber;
		this.aadhaarNumber = aadhaarNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.otp = otp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", userName=" + userName + ", email1=" + email1 + ", mobileNumber=" + mobileNumber
				+ ", aadhaarNumber=" + aadhaarNumber + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", otp=" + otp + "]";
	}
	
	

}
