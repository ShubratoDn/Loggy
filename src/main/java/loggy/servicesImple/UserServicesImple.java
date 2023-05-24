package loggy.servicesImple;

import java.util.ArrayList;
import java.util.List;

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


	
	//user Validation
	public List<String> userValidation(User user) {
		
		List<String> error = new ArrayList<String>();
		
		//name validation
		if(user.getName().isBlank() || user.getName() == null) {
			error.add("Please Enter the name");			
		}else {
			if(user.getName().length() < 3) {
				error.add("Name should be more than 3 char");	
			}
		}
		
		//email validation
		if(user.getEmail().isBlank()) {
			error.add("Please Enter the Email");		
		}
		
		
		if(user.getPassword().isBlank()) {
			error.add("Enter Password");
		}else {
			if(user.getPassword().length() <= 3) {
				error.add("Password need minimum 4 char");	
			}
		}
		
		return error;
	}

}
