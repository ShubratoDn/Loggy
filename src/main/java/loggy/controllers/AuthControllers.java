package loggy.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import loggy.entities.User;
import loggy.services.UserServices;

@Controller
public class AuthControllers {

    private final UserServices userServices;
    @Autowired
    public AuthControllers(UserServices userServices) {
        this.userServices = userServices;
    }
    
    
    
   
	@GetMapping("/login")
	public String loginForm() {	
		return "login";		
	}	
	
	@GetMapping("/register")
	public String registerForm() {
		return "register";
	}
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {		
		
		
//		userServices.addUser(user);
		System.out.println(user);
		System.out.println("User inserted");
		
		return "register";
	}
	
}
