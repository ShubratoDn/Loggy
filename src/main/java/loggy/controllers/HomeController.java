package loggy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		System.out.println("Calling papa");
		return "home";
	}
	
	
	@RequestMapping("")
	public String test() {
		System.out.println("Calling papa");
		return "home";
	}
	

}
