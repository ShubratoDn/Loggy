package loggy.servicesImple;

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

	
	public int addPost(Post post, int userId) {
		int addPost = this.postRepo.addPost(post, userId);
		return addPost;
	}

	
}
