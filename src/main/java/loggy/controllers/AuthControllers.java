package loggy.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import loggy.entities.User;
import loggy.helpers.ServerMessage;
import loggy.services.FileServices;
import loggy.services.UserServices;

@Controller
public class AuthControllers {

    private final UserServices userServices;
    private final FileServices fileServices;
    
    @Autowired
    public AuthControllers(UserServices userServices, FileServices fileServices) {
        this.userServices = userServices;
        this.fileServices = fileServices;
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
	
	
	

	
	//Register
	@PostMapping("/register")
	public String addUser(@ModelAttribute User user, 
			@RequestParam("user_image") CommonsMultipartFile file,	
			HttpSession session,
			Model model) {
		
		String path = session.getServletContext().getRealPath("/");
		System.out.println(path);
		
		ServerMessage sm ;
		List<String> userValidation = userServices.userValidation(user);

		
		if(!userValidation.isEmpty()) {
			sm = new ServerMessage(""+ userValidation, "error","alert-danger");
			model.addAttribute("serverMsg", sm);
			return "register";
		}
			
		//file validation	
		List<String> userImageValidation = fileServices.userImageValidation(file);
		if(!userImageValidation.isEmpty()) {
			System.out.println("File is not ok");
		}else {
			System.out.println("File is ok");
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
