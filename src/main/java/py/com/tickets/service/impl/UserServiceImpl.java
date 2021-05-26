package py.com.tickets.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.tickets.entity.User;
import py.com.tickets.repository.UserRepository;
import py.com.tickets.service.UserService;

@Service
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserRepository getRepository() {
		// TODO Auto-generated method stub
		return userRepository;
	}
}
