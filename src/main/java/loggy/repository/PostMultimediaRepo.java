package loggy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import loggy.entities.PostMultimedia;


@Repository
public class PostMultimediaRepo {

	private  JdbcTemplate jdbcTemplate;	
	
	@Autowired
	public PostMultimediaRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }	
	

	public PostMultimedia getPostMultimediaByPostId(int postId) {		
		String sql = "select * from post_multimedia where post_id=?";
		PostMultimedia multimedia = null;
		try {
			multimedia = this.jdbcTemplate.queryForObject(sql, new PostMultimediaRowMapperImple(), postId);			
			return multimedia;
		}catch (Exception e) {
			System.out.println("File not available for the post " + postId);
			return multimedia;
		}
	}
	
	
}
