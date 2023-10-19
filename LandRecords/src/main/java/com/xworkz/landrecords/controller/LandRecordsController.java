package com.xworkz.landrecords.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.landrecords.dto.AdminDto;
import com.xworkz.landrecords.dto.LandRecordsDto;
import com.xworkz.landrecords.service.LandRecordsService;

@Controller
public class LandRecordsController {

	@Autowired
	private LandRecordsService service;

	@RequestMapping(value = "/getOtp", method = RequestMethod.GET)
	public String generateOtp(AdminDto dto, @RequestParam String email, Model model) {

		boolean result = service.signIn(email, model);
		System.out.println(email);
		if (result) {
			System.out.println("Email Verified ,Enter the OTP");
			model.addAttribute("dto", result);
			return "Home";
		}
		System.out.println("Email is not found");
		model.addAttribute("AccountNotExist", "Email not Found");
		return "Home";

	}

	@RequestMapping(value = "/checkOtp", method = RequestMethod.POST)
	public String otpValidator(@RequestParam String otp, Model model) {

		AdminDto dto = service.otpValidator(otp, model);
		if (dto != null) {
			System.out.println("OTP is Verified");
			model.addAttribute("dto", dto);
			return "Admin";
		}
		System.out.println("Otp is Incorrect");
		return "Home";

	}

	@RequestMapping(value = "/saving", method = RequestMethod.POST)
	public String saveRecords(LandRecordsDto dto, Model model) {
		boolean save = service.saveRecords(dto, model);
		if (save) {
			model.addAttribute("save", dto);
			return "Success";
		} else {
			return "Add";
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteDto(@RequestParam String hissaNumber, @RequestParam String surveyNumber, Model model) {

		boolean remove = service.deleteBySurveyNumber(hissaNumber, surveyNumber);
		System.out.println(remove);
		if (remove) {
			model.addAttribute("dlt", remove);
			model.addAttribute("remove", "Record deleted successfully");
		}
		return "Read";
	}

	@RequestMapping(value = "/editing", method = RequestMethod.POST)
	public String editDto(LandRecordsDto dto, Model model) {
		System.out.println(dto);

		boolean update = service.updateDetailsByHissaAndSurveyNumber(dto, model);
		if (update) {
			model.addAttribute("edit", "Updated Successfully");
			return "Edit";
		} else {
			model.addAttribute("edits", "Not Updated");
			return "Edit";
		}
	}

	@RequestMapping(value = "/readVillage", method = RequestMethod.POST)
	public String findByVillage(@RequestParam String village, Model model) {

		List<LandRecordsDto> dto = service.findByVillage(village, model);
		if (dto != null) {
			model.addAttribute("vlg", dto);
			return "Read";
		} else {
			model.addAttribute("vlg", "Data not found");
			return "Read";
		}
	}
	@GetMapping(value = "/getNumber")
	public String autoReadNumber(@RequestParam String hissaNumber ,@RequestParam String surveyNumber , Model model) {
		LandRecordsDto exist = service.ifExist(hissaNumber, surveyNumber, 0, model);
		if(exist!=null) {
			return "Edit";
		}
		return null;
		
	}

}
