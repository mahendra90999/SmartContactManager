package com.smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String Home(Model model) {
		
		model.addAttribute("title","Smart Contact Manager");
		return "home";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		
		model.addAttribute("title","About");
		return "about";
	}
	
	@RequestMapping("/signup")
	public String signUp(Model model) {
		
		model.addAttribute("title","Register new User");
		return "signup";
	}
}
