package loggy.services;

import loggy.entities.User;

public interface UserServices {

	int addUser(User user);
	int updateUser();
	int removeUser();
	User getUserById();
	
}
