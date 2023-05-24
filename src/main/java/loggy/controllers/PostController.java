package loggy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import loggy.entities.Post;

@Controller
public class PostController {

	@PostMapping("/write-post")
	public String writeBlog(@ModelAttribute Post post, @RequestParam("file") CommonsMultipartFile file, Model model) {
		
		System.out.println(post);
		
		
		return "home";		
	}
	
}
