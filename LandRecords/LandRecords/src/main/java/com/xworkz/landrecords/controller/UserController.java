package com.xworkz.landrecords.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.landrecords.dto.UserDto;
import com.xworkz.landrecords.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/userSave", method = RequestMethod.POST)
	public String saveUser(UserDto dto, Model model) throws Exception {

		boolean save = service.saveUser(dto, model);
		if (save) {
			model.addAttribute("registering", dto);
			return "UserSuccess";
		}
		model.addAttribute("register", "Not Registered");
		return "UserRegister";
	}

	@RequestMapping(value = "/userSignIn", method = RequestMethod.POST)
	public String signIn(@RequestParam String email1, @RequestParam String password, Model model) {

		UserDto dto = service.signIn(email1, password, model);
		System.out.println(email1);
		if (dto != null) {
				model.addAttribute("signIn", dto);
				return "UserView";
			
		}
		model.addAttribute("signFailed", "No account found");
		return "UserLogIn";
	}

	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public String sendOtp(@RequestParam String email1, Model model) {

		boolean check = service.checkOtp(email1, model);
		if (check) {
			model.addAttribute("otp", check);
			return "ForgotPassword";
		}
		return "ForgotPassword";
	}

	@RequestMapping(value = "/otpValidate", method = RequestMethod.POST)
	public String otpValidate(@RequestParam String otp, Model model) {

		UserDto validate = service.otpValidate(otp, model);
		if (validate != null) {
			model.addAttribute("checkOTP", validate);
			return "UpdatePassword";
		}
		return "ForgotPassword";

	}
	@RequestMapping(value = "/updatingPassword" , method = RequestMethod.POST)
	public String updatePassword(@RequestParam String password, @RequestParam String confirmPassword, @RequestParam String email1, Model model) {
		
		boolean update = service.updatePasswordByEmail(password, confirmPassword, email1, model);
		if(update) {
			model.addAttribute("psrdUpdate", "Password is updated successfully");
			return "UserLogIn";
		}
		model.addAttribute("updateFailed", "Check the password");
		return "UpdatePassword";
		
	}
	
//	@RequestMapping(value = "/viewUser" , method = RequestMethod.POST)
//	public String userView(@RequestParam String village , Model model) {
//		
//		
//		
//		return null;
//		
//	}

}
