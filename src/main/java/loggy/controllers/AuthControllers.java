package loggy.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String addUser(@ModelAttribute User user, Model model) {
		
		ServerMessage sm ;
		List<String> userValidation = userServices.userValidation(user);
		
		//default field values
		model.addAttribute("name",user.getName());
		model.addAttribute("email",user.getEmail());
				
		
		if(!userValidation.isEmpty()) {
			sm = new ServerMessage(""+ userValidation, "error","alert-danger");
			model.addAttribute("serverMsg", sm);
			return "register";
		}
		
		sm = new ServerMessage("Register Success", "success","alert-success");
		model.addAttribute("serverMsg", sm);
		
		
//		userServices.addUser(user);
		System.out.println(user);
		System.out.println("User inserted");
		
		return "register";
	}
	
}
