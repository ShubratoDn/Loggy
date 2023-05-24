package loggy.services;

import java.util.List;

import loggy.entities.User;

public interface UserServices {	
	
	List<String> userValidation(User user);
	
	int addUser(User user);
	int updateUser();
	int removeUser();
	User getUserById();
	
}
