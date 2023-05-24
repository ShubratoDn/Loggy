package loggy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import loggy.helpers.ServerMessage;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("Calling papa");
		
		ServerMessage sm = null;
		model.addAttribute("postMsg", sm);		
		model.addAttribute("title", "");
		model.addAttribute("content","");
		
		
		return "home";
	}		

	
	@GetMapping("/profile/")
	public String homxe() {
		return "";
	}
	
	
	
	
}
