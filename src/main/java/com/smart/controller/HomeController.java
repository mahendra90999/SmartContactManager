package com.smart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String HomeHandler(){
		
		return "Hii this is home handler";
	}
}
