package loggy.servicesImple;

import org.springframework.beans.factory.annotation.Autowired;

import loggy.entities.User;
import loggy.repository.UserRepo;
import loggy.services.UserServices;

public class UserServicesImple implements UserServices {	

    private final UserRepo userRepo;
    
	@Autowired
	public UserServicesImple(UserRepo userRepo) {
		 this.userRepo = userRepo;
	}
	
	
	
	//adding user
	public int addUser(User user) {
		int addUser = this.userRepo.addUser(user);
		return addUser;
	}

	
	public int updateUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int removeUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	public User getUserById() {
		// TODO Auto-generated method stub
		return null;
	}

}
