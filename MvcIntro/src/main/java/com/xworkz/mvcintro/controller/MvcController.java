package com.xworkz.mvcintro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MvcController {
	
	public MvcController() {
		System.out.println("MvcController Constructor is running");
	}
	
	@RequestMapping(value = "/message" , method = RequestMethod.GET)
	public String getMessage(Model model) {
		System.out.println("getMessage method is running");
		model.addAttribute("welcome" , "This is Welcome Page");
		return "Welcome";
		
	}

}
