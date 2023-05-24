package loggy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import loggy.entities.Post;
import loggy.services.PostServices;

@Controller
public class PostController {

	private final PostServices postServices;
    
    @Autowired
    public PostController(PostServices postServices) {
    	this.postServices = postServices;
    }
	
	
	@PostMapping("/write-post")
	public String writeBlog(@ModelAttribute Post post, @RequestParam("file") CommonsMultipartFile file, Model model) {		
		
		//file validation
		postServices.addPost(post, 1);
		
		System.out.println(post);
		
		return "home";		
	}
	
}
