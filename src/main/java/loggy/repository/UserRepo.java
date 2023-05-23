package loggy.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepo {	
	private  JdbcTemplate jdbcTemplate;
	
	public int addUser() {
		String sql = "INSERT INTO user (name, email) VALUES (?, ?) 	";
		
		int update = jdbcTemplate.update(sql, "Shubrato", "test");
		System.out.println("User inserted");
		return 0;
	}
	
}
