package loggy.services;

import loggy.entities.Post;

public interface PostServices {

	int addPost(Post post, int userId);
	
}
