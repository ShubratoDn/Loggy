package loggy.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.soap.SoapFaultException;
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
			return "home";
		}		
		
		//file validation		
		FileServices fileServices = new FileServices();
		
		//getting file type
		String postFileType = "empty" ;
		if(!file.isEmpty()) {			
			postFileType = fileServices.postFileType(file);
		}
		
		//image validation
		if(postFileType.equals("image")) {
			List<String> postImageValidation = fileServices.postImageValidation(file);
			if(!postImageValidation.isEmpty()) {
				sm = new ServerMessage(postImageValidation,"error","alert-danger");
				model.addAttribute("postMsg", sm);
				return "home";
			}	
		}else if(postFileType.equals("video")) {
			//Video validation
			 List<String> postVideoValidation = fileServices.postVideoValidation(file);
			if(!postVideoValidation.isEmpty()) {
				sm = new ServerMessage(postVideoValidation,"error","alert-danger");
				model.addAttribute("postMsg", sm);
				return "home";
			}
		}else if(postFileType.equals("empty")) {
			
		}else {
			sm = new ServerMessage(Arrays.asList("Invalid file type"),"error","alert-danger");
			model.addAttribute("postMsg", sm);
			return "home";
		}
		
		
		
		//upload the file
		String filePath = "";
		if(postFileType.equals("image") || postFileType.equals("video")) {
			 filePath = fileServices.uploadPostFile(file, session);
		}	
		
		
		
		
		//Inserting data to Database
		post.setUser(user);		
		postServices.addPost(post, user.getId());		
		//uploading multimedia data if available
		if(postFileType.equals("image") || postFileType.equals("video")) {
			postServices.addPostMultimedia(post, user.getId(), postFileType, filePath);			
		}	
		
		System.out.println(post);
		
		return "home";		
	}
	
}
