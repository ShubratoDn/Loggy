package loggy.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import loggy.entities.Post;
import loggy.entities.User;
import loggy.helpers.FileServices;
import loggy.helpers.ServerMessage;
import loggy.services.PostServices;

@Controller
public class PostController {

	private final PostServices postServices;
    
    @Autowired
    public PostController(PostServices postServices) {
    	this.postServices = postServices;
    }
	
	//inserting post
	@PostMapping("/write-post")
	public String writeBlog(@ModelAttribute Post post, @RequestParam("file") CommonsMultipartFile file,HttpSession session ,Model model) {		
		
		ServerMessage sm = new ServerMessage();		
		model.addAttribute("title", post.getTitle());
		model.addAttribute("content",post.getContent());
		
		User user = (User) session.getAttribute("user");		
		if(user==null) {
			System.out.println("User Not Logged In for upload Post");
			return "home";
		}
		
		//input validation
		List<String> postValidation = postServices.postValidation(post);		
		if(!postValidation.isEmpty()) {
			sm = new ServerMessage(postValidation,"error","alert-danger");
			model.addAttribute("postMsg", sm);
			System.out.println(postValidation);
			return "home";
		}		
		
		//file validation
		FileServices fileServices = new FileServices();
		String postFileType = fileServices.postFileType(file);
		System.out.println("Post File type" + postFileType);
		
		
//		postServices.addPost(post, 1);

		
		System.out.println(post);
		
		return "home";		
	}
	
}
