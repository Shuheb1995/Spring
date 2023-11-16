package com.xworkz.landrecords.repo;

import com.xworkz.landrecords.dto.UserDto;

public interface UserRepo {
	
	public boolean saveUser(UserDto dto);
	
	public UserDto ifExist(String email1, String password);
	
	public UserDto emailExist(String email1) ;
	
	public UserDto passwordExist(String password) ;
	
	public boolean updateOtpByEmail(String otp , String email1);
	
	public UserDto findOtp(String otp);
	
	public boolean updatePasswordByEmail(String password , String confirmPassword , String email1);
	
	

}
