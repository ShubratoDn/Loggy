package loggy.servicesImple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import loggy.entities.Post;
import loggy.repository.PostRepo;
import loggy.services.PostServices;

public class PostServicesImple implements PostServices{

    private final PostRepo postRepo;
    
	@Autowired
	public PostServicesImple(PostRepo postRepo) {
		this.postRepo = postRepo;
	}

	
	
	//post validation
	@Override
	public List<String> postValidation(Post post) {

		List<String> error = new ArrayList<String>();
		if(post.getTitle().isEmpty()) {
			error.add("Title Can not be null");
		}else if(post.getTitle().length() > 60) {
			error.add("Title should not exceed 60 character");
		}
		
		if(post.getContent().isEmpty()) {
			error.add("Content Can not be null");
		}else if(post.getContent().length() > 120) {
			error.add("Content should not exceed 120 character");
		}
			
		return error;
	}
	
	
	//add Post
	public int addPost(Post post, int userId) {
		int addPost = this.postRepo.addPost(post, userId);
		return addPost;
	}
	
	public int addPostMultimedia(Post post, int userId, String fileType, String filePath) {
		int addPostMultimedia = this.postRepo.addPostMultimedia(post, userId, fileType, filePath);
		return addPostMultimedia;
	}



	
	public List<Post> getAllPosts(){
		List<Post> allPosts = this.postRepo.getAllPosts();
		return allPosts;
	}




	
}
