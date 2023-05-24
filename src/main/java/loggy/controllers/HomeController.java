package loggy.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import loggy.entities.User;
import loggy.helpers.ServerMessage;
import loggy.services.UserServices;

@Controller
public class HomeController {

    private final UserServices userServices;
    
    @Autowired
    public HomeController(UserServices userServices) {
        this.userServices = userServices;
    } 
    
	
	
	
	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("Calling papa");
		
		ServerMessage sm = null;
		model.addAttribute("postMsg", sm);		
		model.addAttribute("title", "");
		model.addAttribute("content","");
		
		
		return "home";
	}	
	

	
	
	@GetMapping("/profile/{userId}")
	public String profile(@PathVariable("userId") int userId, HttpSession session) {
		User user = userServices.getUserById(userId);
		if(user == null) {
			return "redirect:/home";
		}
		session.setAttribute("visitedUser", user);
		return "redirect:/profile";
	}
	
	
	@GetMapping("/profile")
	public String uprofile(Model model, HttpSession session) {		
		
		if(session.getAttribute("visitedUser") != null) {
			User user = (User) session.getAttribute("visitedUser");
			model.addAttribute("visitedUser", user);
		}else {			
			User user  = (User) session.getAttribute("user");
			model.addAttribute("visitedUser", user);
		}		
		
		return "profile";
	}
	
	
	
	
}
