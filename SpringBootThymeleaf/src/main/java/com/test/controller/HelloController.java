package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@GetMapping("/")
	public String simpleHomePage(Model model)
	{
		
		//ModelAndView
		
		model.addAttribute("msg", "WELCOME TO THYMELEAF");
		
		return "index";
	}
}
