package loggy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
		int addeduser = jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getImage());
		return addeduser;
	}
	
	
	//get user by email
	public User getUserByEmail(String email) {		
		String sql = "select * from user where email=?";		
		RowMapper<User> rowMapper = new UserRowMapperImple();
		
		try {
			User user = this.jdbcTemplate.queryForObject(sql,rowMapper,email);
			return user;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	
}
