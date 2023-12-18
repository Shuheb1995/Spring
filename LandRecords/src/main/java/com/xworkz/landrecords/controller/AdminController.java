package com.xworkz.landrecords.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.landrecords.dto.AdminDto;
import com.xworkz.landrecords.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService admin;
	
	@RequestMapping(value = "/addAdmin" , method =  RequestMethod.POST)
	public String saveAdmin(AdminDto dto , Model model , @RequestParam ("file") MultipartFile file) throws IllegalStateException, IOException {
		
		
		String uploadPath = "C:\\Users\\Shuheb\\OneDrive\\Desktop\\Project Images\\";
		String orgFileName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),
				file.getOriginalFilename().length());
		String uniqueName = dto.getAdminName() + orgFileName;
		file.transferTo(new File (uploadPath + uniqueName));
		
		dto.setAdminImagePath(uploadPath + uniqueName);
		
		boolean save = admin.saveAdmin(dto);
		System.out.println(save);
		return "AdminData";
	}

}
