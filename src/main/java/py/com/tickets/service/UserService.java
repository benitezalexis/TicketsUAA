package py.com.tickets.service;

import java.util.List;

import py.com.tickets.entity.User;
import py.com.tickets.model.UserModel;

public interface UserService {

	public abstract UserModel insert(UserModel userModel);
	
	public abstract List<UserModel> findAll();
	
	public abstract void remove(String username);
	
	public User findByUsername(String username);

	public UserModel findByUserModel(String username);
}
