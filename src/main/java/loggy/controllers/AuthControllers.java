package loggy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import loggy.repository.UserRepo;

@Controller
public class AuthControllers {

	@GetMapping("/login")
	public String loginForm() {	
		return "login";		
	}	
	
	@GetMapping("/test")
	public String addUser() {	
		
		System.out.println("Calling");
		UserRepo userRepo = new UserRepo();
		userRepo.addUser();
		return "login";
	}
	
}
