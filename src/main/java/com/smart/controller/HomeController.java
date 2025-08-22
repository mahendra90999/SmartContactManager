package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.dao.UserRepository;
import com.smart.entities.User;
import com.smart.helper.Messages;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
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
		model.addAttribute("user",new User());
		return "signup";
	}
	
	@RequestMapping(value="/do_register",method = RequestMethod.POST )
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result1,@RequestParam(value="aggriment",defaultValue = "false") boolean agriment,Model model,HttpSession session) {
		
		try {
			if(!agriment) {
				
				System.out.println("You have not aggred the terms and conditions.");
				throw new Exception("You have not aggred the terms and conditions.");
			}
			
			if(result1.hasErrors())
			{
				System.out.println("ERROR "+ result1.toString());
				model.addAttribute("user",user);
				return "signup";
			}
			
			
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("default.jpg");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			
			System.out.println(agriment);
			System.out.println(user);
			
			User result = this.userRepository.save(user);
			
			
			
			model.addAttribute("user",result);
			
			model.addAttribute("user",new User());
			
			session.setAttribute("message",new Messages("successfully register a new user","alert-success"));
			return "signup";
		} catch (Exception e) {
			
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message",new Messages("something Went wrong..!!"+e.getMessage(),"alert-danger"));
		}
		
		return "signup";
	}
	
//	handler for custom login
	@GetMapping("/signin")	
	public String customLogin(Model model) {
		model.addAttribute("title","signIn");
		return "login";
	}
}
