package com.smart.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smart.dao.UserRepository;
import com.smart.dao.contactRepository;
import com.smart.entities.Contact;
import com.smart.entities.User;
import com.smart.helper.Messages;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private contactRepository contactRepository;
	
//method for adding common data for handler methods
	@ModelAttribute
	public void addCommonData(Model model,Principal principal) {
		String username = principal.getName();
		System.out.println(username);
		
//		get the user details from database
		
		User user = userRepository.getUserByname(username);
		
//		send to view
		
		model.addAttribute(user);
	}
	
//	dashboard
	@RequestMapping("/index")
	public String dashboard(Model model,Principal principal) {
		String username = principal.getName();
		System.out.println(username);
		
//		get the user details from database
		
		User user = userRepository.getUserByname(username);
		
//		send to view
		
		model.addAttribute(user);
		model.addAttribute("title","dashboard");
		
		return "normal/user_dashboard";
	}
	
	
//	adding contacts
	@GetMapping("/add_contacts")
	public String  openAddContactForm(Model model) {
		
		model.addAttribute("title","Add contacts");
		model.addAttribute("contact",new Contact());
		
		return "normal/add_contact_form";
	}
	
	
	@PostMapping("/process_contact")
	public String processContact(@ModelAttribute Contact contact,@RequestParam("profileImage") MultipartFile file,Principal principal,Messages messages,Model model) {
		try {
			String name = principal.getName();
			User user = this.userRepository.getUserByname(name);
			
//			processing and uploading file
			if(file.isEmpty()) {
				System.out.println("file is emplty");
				model.addAttribute("messages", new Messages("your image is empty","danger"));
			}else {
				contact.setImage(file.getOriginalFilename());
				
				
				String uploadDir = "uploads/images"; // create this folder manually outside static

				File saveDir = new File(uploadDir);
				if (!saveDir.exists()) {
				    saveDir.mkdirs(); // create dirs if not exist
				}

				// Build file path
				Path path = Paths.get(uploadDir, file.getOriginalFilename());

				// Copy file
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

				System.out.println("Image uploaded to: " + path.toString());

			}
			
			
			user.getContacts().add(contact);
			contact.setUser(user);
			
			
			
			
			this.userRepository.save(user);
			System.out.println("added to database.");
			model.addAttribute("message2", new Messages("Contact saved successfully..", "success"));
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			String m = "something went wrong \n"+e.getMessage();
			model.addAttribute("message2", new Messages(m, "danger"));
		}
		
		
		
		return("normal/add_contact_form");
	}
	
	
	@GetMapping("/show_contacts")
	public String showContacts(Model model,Principal principal) {
		
		String username = principal.getName();
		User user = userRepository .getUserByname(username);
		
		List<Contact> contacts = contactRepository.findContactByUser(user.getId());
		
		model.addAttribute("contacts",contacts);
		System.out.println(contacts);
		return "normal/show_contacts";
	}
	
	
	
	
}
