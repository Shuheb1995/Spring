package com.xworkz.landrecords.repo;

import java.util.List;

import com.xworkz.landrecords.dto.AdminDto;
import com.xworkz.landrecords.dto.LandRecordsDto;

public interface LandRecordsRepo {
	
	public AdminDto findByEmail(String email);
	
	public boolean updateOtpByEmail(String otp , String email);
	
	public AdminDto findOtp(String otp);
	
	public boolean saveRecords(LandRecordsDto dto);
	
	public boolean updateDetailsByHissaAndSurveyNumber(String ownerName, String mobileNumber, String aadhaarNumber, String year, String hissaNumber, String surveyNumber , int status);
	
	public boolean deleteBySurveyNumber(String hissaNumber, String surveyNumber ,  int status );
	
	public List<LandRecordsDto> findByVillage(String village , int status);
	
	public LandRecordsDto ifExist(String hissaNumber , String surveyNumber , int status);
	
	public List<LandRecordsDto> findByHobliAndVillage(String hobli , String village);

}
