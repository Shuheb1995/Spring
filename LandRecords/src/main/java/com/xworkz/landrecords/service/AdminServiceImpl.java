package com.xworkz.landrecords.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.landrecords.dto.AdminDto;
import com.xworkz.landrecords.repo.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo repo;

	@Override
	public boolean saveAdmin(AdminDto dto) {
		if(dto.getAdminName()!=null) {
			if(dto.getEmail()!=null) {
				if(dto.getOtp()!=null) {
					System.out.println("Admin is ready to save");
					return repo.saveAdmin(dto);
				}
				System.out.println("otp is invalid");
				return false;
			}
			System.out.println("Email is inavalid");
			return false;
		}
		System.out.println("Admin Name is invalid");
		return false;
	}

}
