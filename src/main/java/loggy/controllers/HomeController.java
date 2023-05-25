package loggy.controllers;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import loggy.entities.Post;
import loggy.entities.User;
import loggy.helpers.ServerMessage;
import loggy.services.PostServices;
import loggy.services.UserServices;
import loggy.servicesImple.PostServicesImple;

@Controller
public class HomeController {

    private final UserServices userServices;
    private final PostServices postServices;
    
    
    @Autowired    
    public HomeController(UserServices userServices, PostServices postServices) {
        this.userServices = userServices;
        this.postServices = postServices;
    } 
    
	
	//home page
	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("Calling papa");
		
		ServerMessage sm = null;
		model.addAttribute("postMsg", sm);		
		model.addAttribute("title", "");
		model.addAttribute("content","");
		
		List<Post> allPosts = postServices.getAllPosts();
		System.out.println("Post COunt is " + allPosts);
		
		for(Post post : allPosts) {
			System.out.println("Post title is : "+post.getTitle());
			System.out.println(post.getUser().getName());
			System.out.println(post.getPostMultimedia());
		}
		
		model.addAttribute("allPosts",allPosts);		
		
		
		return "home";
	}	
	

	
	//profile Controllers
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
		}else if(session.getAttribute("user")!= null) {			
			User user  = (User) session.getAttribute("user");
			model.addAttribute("visitedUser", user);
		}else {			
			return "redirect:/home";
		}
		
		return "profile";
	}
	
	
	
	
}
