package loggy.services;

import java.util.List;

import loggy.entities.Post;

public interface PostServices {

	List<String> postValidation(Post post);
	
	int addPost(Post post, int userId);
	
}
