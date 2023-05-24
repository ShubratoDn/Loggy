package loggy.controllers;


import java.util.Arrays;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import loggy.entities.User;
import loggy.helpers.FileServices;
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
	public String loginForm(Model model) {	
		ServerMessage sm = new ServerMessage();
		model.addAttribute("serverMsg", sm);
		model.addAttribute("email", "");
		return "login";		
	}	
	
	//login user
	@PostMapping("/login")
	public String login(@ModelAttribute User user, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		
		ServerMessage sm = new ServerMessage();
		
		model.addAttribute("email",user.getEmail());
		
		User dbUser = userServices.getUserByEmail(user.getEmail());		
		if(dbUser == null) {			
			sm = new ServerMessage(Arrays.asList("Account is not registerd with this email!"), "error", "alert-danger");
			model.addAttribute("serverMsg", sm);
			return "login";
		}		
		
		
		if(!user.getPassword().equals(dbUser.getPassword())) {
			sm = new ServerMessage(Arrays.asList("Incorrect Password"), "error", "alert-danger");
			model.addAttribute("serverMsg", sm);
			return "login";
		};
		
		session.setAttribute("user", dbUser);
		sm = new ServerMessage(Arrays.asList("Logged In"), "success", "alert-success");
		model.addAttribute("serverMsg", sm);
		System.out.println("Logged In");
		
		//flusing the url, now email will not appear in the URL after redirecting
		redirectAttributes.addFlashAttribute("email", user.getEmail());
		return "redirect:/home";
	}
	
	
	
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		//setting default server message
		ServerMessage sm = new ServerMessage();
		model.addAttribute("serverMsg", sm);
		
		model.addAttribute("name","");
		model.addAttribute("email","");
		model.addAttribute("password","");
		return "register";
	}
	
	//Register
	@PostMapping("/register")
	public String addUser(@ModelAttribute User user, 
			@RequestParam("user_image") CommonsMultipartFile file,	
			HttpSession session,
			Model model) {

		//default field values
		model.addAttribute("name",user.getName());
		model.addAttribute("email",user.getEmail());
		model.addAttribute("password", user.getPassword());	
		
		
		
		ServerMessage sm ;
		List<String> userValidation = userServices.userValidation(user);

		
		if(!userValidation.isEmpty()) {
			sm = new ServerMessage(userValidation, "error","alert-danger");
			model.addAttribute("serverMsg", sm);
			return "register";
		}
			
		
		
		//file validation	
		FileServices fileServices = new FileServices();
		List<String> userImageValidation = fileServices.userImageValidation(file);
		if(!userImageValidation.isEmpty()) {			
			sm = new ServerMessage(userImageValidation, "error","alert-danger");
			model.addAttribute("serverMsg", sm);
			return "register";
		}

		
		//upload image
		String uploadUserImage = fileServices.uploadUserImage(file, session);
		if(uploadUserImage == null) {
			sm = new ServerMessage(Arrays.asList("File Upload Failed"), "error","alert-danger");
			model.addAttribute("serverMsg", sm);
			return "register";
		}	

		
		//inserting Data
		user.setImage(uploadUserImage);
		int addUser = userServices.addUser(user);		
		
		
		if(addUser > 0 ) {			
			sm = new ServerMessage(Arrays.asList("Register Success"), "success","alert-success");
			model.addAttribute("serverMsg", sm);
			model.addAttribute("name","");
			model.addAttribute("email","");			
			model.addAttribute("password","");
		}else {
			sm = new ServerMessage(Arrays.asList("Unable to Register"), "error","alert-danger");
			model.addAttribute("serverMsg", sm);
		}

		return "redirect:/login";
	}
	
	
	//logout
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
}
