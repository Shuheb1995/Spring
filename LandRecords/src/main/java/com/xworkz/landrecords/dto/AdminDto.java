package com.xworkz.landrecords.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "admin_data")
@NamedQuery(name = "findEmail" , query = "Select dto from AdminDto dto where dto.email=:em")
@NamedQuery(name = "updateOtp" , query = "update AdminDto dto set dto.otp=:op where dto.email=:eml")
@NamedQuery(name = "findOtp" , query = "Select dto from AdminDto dto where dto.otp=:ot")
public class AdminDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String adminName;
	private String email;
	private String otp;
	private String adminImagePath;
	
	public AdminDto() {
		super();
	}

	public AdminDto(int id, String adminName, String email, String otp , String adminImagePath) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.email = email;
		this.otp = otp;
		this.adminImagePath = adminImagePath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	public String getAdminImagePath() {
		return otp;
	}

	public void setAdminImagePath(String adminImagePath) {
		this.adminImagePath = adminImagePath;
	}

	@Override
	public String toString() {
		return "LandRecordsDto [id=" + id + ", adminName=" + adminName + ", email=" + email + ", otp=" + otp + " , adminImagePath=" + adminImagePath + "]";       
	}
	
	

}
