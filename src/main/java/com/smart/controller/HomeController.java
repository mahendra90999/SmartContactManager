package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.dao.UserRepository;
import com.smart.entities.User;

@RestController
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String test(){
		
		
		User user = new User();
		user.setName("mahendra");
		user.setEmail("mahendra@mai.com");
		
		userRepository.save(user);
		
		return "Hii this is home handler";
	}
}
