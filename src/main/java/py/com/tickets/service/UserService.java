package py.com.tickets.service;

import org.springframework.stereotype.Service;

import py.com.tickets.entity.User;
import py.com.tickets.model.UserModel;

@Service
public interface UserService extends GenericService<User>{
	
	public UserModel findByUserModel(UserModel userModel);
	
	public User findByUsername(String userModel);
	
}
