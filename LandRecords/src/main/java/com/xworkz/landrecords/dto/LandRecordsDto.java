package com.xworkz.landrecords.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "Land_Records")
//@NamedQuery(name = "findNum" , query = "Select dto from LandRecordsDto dto where dto.mobileNumber=:mn and dto.status=st")
@NamedQuery(name = "updateDto" , query = "update LandRecordsDto dto set dto.ownerName=:on, dto.mobileNumber=:mn, dto.aadhaarNumber=:an, dto.year=:yr where dto.hissaNumber=:hn and surveyNumber=:sn and dto.status=:st")         
@NamedQuery(name = "delete" , query = "update LandRecordsDto dto set dto.status=1 where dto.hissaNumber=:hn and dto.surveyNumber=:sn")
@NamedQuery(name = "findVillage" , query = "Select dto from LandRecordsDto dto where dto.village=:vg and dto.status=:st")
@NamedQuery(name = "ifExist" , query = " Select dto from LandRecordsDto dto where dto.hissaNumber=:hn and dto.surveyNumber=:sn and dto.status=:st")
public class LandRecordsDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String state;
	private String district;
	private String taluk;
	private String hobli;
	private String village;
	private String ownerName;
	private String mobileNumber;
	private String aadhaarNumber;
	private String hissaNumber;
	private String surveyNumber;
	private String year;
	private int status = 0;
	
	public LandRecordsDto() {
		super();
	}

	public LandRecordsDto(int id, String state, String district, String taluk, String hobli, String village,
			String ownerName, String mobileNumber, String aadhaarNumber, String hissaNumber, String surveyNumber,
			String year) {
		super();
		this.id = id;
		this.state = state;
		this.district = district;
		this.taluk = taluk;
		this.hobli = hobli;
		this.village = village;
		this.ownerName = ownerName;
		this.mobileNumber = mobileNumber;
		this.aadhaarNumber = aadhaarNumber;
		this.hissaNumber = hissaNumber;
		this.surveyNumber = surveyNumber;
		this.year = year;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public String getHobli() {
		return hobli;
	}

	public void setHobli(String hobli) {
		this.hobli = hobli;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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

	public String getHissaNumber() {
		return hissaNumber;
	}

	public void setHissaNumber(String hissaNumber) {
		this.hissaNumber = hissaNumber;
	}

	public String getSurveyNumber() {
		return surveyNumber;
	}

	public void setSurveyNumber(String surveyNumber) {
		this.surveyNumber = surveyNumber;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "LandRecordsDto [id=" + id + ", state=" + state + ", district=" + district + ", taluk=" + taluk
				+ ", hobli=" + hobli + ", village=" + village + ", ownerName=" + ownerName + ", mobileNumber="
				+ mobileNumber + ", aadhaarNumber=" + aadhaarNumber + ", hissaNumber=" + hissaNumber + ", surveyNumber="
				+ surveyNumber + ", year=" + year + "]";
	}
	
	
	
	

}
