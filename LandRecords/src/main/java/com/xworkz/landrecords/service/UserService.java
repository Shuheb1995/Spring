package com.xworkz.landrecords.service;

import org.springframework.ui.Model;

import com.xworkz.landrecords.dto.UserDto;

public interface UserService {
	
	public boolean saveUser(UserDto dto , Model model) throws Exception;
	
	public boolean validateUser(UserDto dto , Model model);
	
	public UserDto mailExist(String email1);
	
	public UserDto passwordExist(String password);
	
	public UserDto ifExist(String email1 , String password , Model model);
	
	public UserDto signIn(String email1 , String password , Model model);
	
	public String randomOtp(int length);
	
	public boolean checkOtp(String email1 , Model model);
	
	public UserDto otpValidate(String otp , Model model);
	
	public boolean updatePasswordByEmail(String password , String confirmPassword , String email1 , Model model);
	
    public String encryptPWD(String password, String Secretkey)  throws Exception;
	
	public String decryptPWD(String encryptPwd,String Secretkey);


}
