package loggy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import loggy.entities.Post;

@Repository
public class PostRepo {

	private  JdbcTemplate jdbcTemplate;	
	@Autowired
    public PostRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }	
	
	public int addPost(Post post, int user_id) {
		String sql = "INSERT INTO post (user_id, title, content) VALUES (?, ?, ?)";		
		int addedPost = jdbcTemplate.update(sql, user_id, post.getTitle(), post.getContent());
		System.out.println("Post added");
		return addedPost;
	}
	
	
	
	
}
