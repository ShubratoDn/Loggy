package loggy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import loggy.entities.User;

@Repository
public class UserRepo {		

	private  JdbcTemplate jdbcTemplate;
	
	@Autowired
    public UserRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	
	
	//add User
	public int addUser(User user) {		
		String sql = "INSERT INTO user (name, email, password, image) VALUES (?, ?, ?,?)";		
		int update = jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getImage());
		return update;
	}
	
	
	
	
}
