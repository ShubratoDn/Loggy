package loggy.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import loggy.entities.User;
import loggy.helpers.ServerMessage;
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
	public String registerForm(Model model) {
		//setting default server message
		ServerMessage sm = new ServerMessage();
		model.addAttribute("serverMsg", sm);
		
		model.addAttribute("name","");
		model.addAttribute("email","");
		
		return "register";
	}
	
	
	
	@PostMapping("/register")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("user_image") CommonsMultipartFile user_image,
			Model model){
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		
		if(user_image.isEmpty()) {
			System.out.println("File is empty");
		}else {
			System.out.println("Not empty");
		}
		
		System.out.println(user);
		ServerMessage sm ;
		List<String> userValidation = userServices.userValidation(user);
		

//		Part part = request.getPart("user_image");
		
		if(!userValidation.isEmpty()) {
			sm = new ServerMessage(""+ userValidation, "error","alert-danger");
			model.addAttribute("serverMsg", sm);
			return "register";
		}
		
		sm = new ServerMessage("Register Success", "success","alert-success");
		model.addAttribute("serverMsg", sm);
		
		//default field values
		model.addAttribute("name",user.getName());
		model.addAttribute("email",user.getEmail());
				
//		userServices.addUser(user);
		System.out.println(user);
		System.out.println("User inserted");
		
		return "register";
	}
	
}
