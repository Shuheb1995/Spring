package com.xworkz.landrecords.service;

import java.util.List;

import org.springframework.ui.Model;

import com.xworkz.landrecords.dto.AdminDto;
import com.xworkz.landrecords.dto.LandRecordsDto;

public interface LandRecordsService {
	
	public AdminDto findByEmail(String email , Model model);
	
	public boolean signIn(String email , Model model);
	
	public AdminDto otpValidator(String otp , Model model);
	
	public boolean validate(LandRecordsDto dto , Model model);
	
	public boolean saveRecords(LandRecordsDto dto , Model model);
	
	public boolean sendOtpToEmail(String otp , String email , Model model);
	
	public boolean updateDetailsByHissaAndSurveyNumber(LandRecordsDto dto, Model model);

	public boolean deleteBySurveyNumber( String hissaNumber, String surveyNumber);
	
	public List<LandRecordsDto> findByVillage(String village , Model model);
	
	public LandRecordsDto ifExist(String hissaNumber , String surveyNumber , int status , Model model);


	
	


}
