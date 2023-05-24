package loggy.repository;

import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

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
	
	
	public Long save(Post post) {
		
        String sql = "INSERT INTO post (title, content) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update( connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setString(1, post.getTitle());
                ps.setString(2, post.getContent());
                return ps;
            },
            keyHolder
        );

        return keyHolder.getKey().longValue();
    }
	
	
	
}
