package com.xworkz.session.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.session.dto.SessionDto;
import com.xworkz.session.service.SessionService;

@RestController
public class SessionController {
	
	@Autowired
	private SessionService service;
	
	public SessionController() {
		System.out.println("Controller Constructor is started");
	}
	
	@GetMapping("/get")
	public String getSession() {
		System.out.println("Getting Data");
		return "Shuheb";
	}
	
	@GetMapping("/getDto")
	public SessionDto getDto() {
		System.out.println("Dto method is running");
		return new SessionDto(0, "Shuheb" , "Spring Boot" , "Abhishek", 2);
		
	}
	
	@PostMapping("/save")
	public String saveData(@RequestBody SessionDto dto) {
		
		SessionDto save = service.addData(dto);
		if(save!=null) {
			return "Data saved successfully";
		}
		return "Data not saved";
		
	}
	
	@GetMapping("/find/{id}")
	public Optional<SessionDto> findById(@PathVariable int id){
		
		Optional<SessionDto> search = service.findById(id);
		return search;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		
		boolean delete = service.deleteById(id);
		if(delete) {
			return "Data Deleted";
		}
		return "Data not deleted";
		
	}
	
	@GetMapping("/read")
	public Iterable<SessionDto> readAll(){
		Iterable<SessionDto> read = service.readAll();
		return read;
	}
	
	@PutMapping("/update/{id}")
	public String updateCourseById(@PathVariable int id , @RequestParam String course) {
		
		int update = service.updateCourseById(id, course);
		if(update == 1) {
			return "Updated Successfully";
		}
		return "Not updated";
		
	}

}
