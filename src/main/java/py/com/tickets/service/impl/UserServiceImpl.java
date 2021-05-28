package py.com.tickets.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.com.tickets.component.UserConverter;
import py.com.tickets.entity.User;
import py.com.tickets.model.UserModel;
import py.com.tickets.repository.UserRepository;
import py.com.tickets.service.UserService;

@Service
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public UserRepository getRepository() {
		return userRepository;
	}
	
	@Transactional
	public UserModel findByUserModel(UserModel userModel) {
		return userConverter.convertUser2UserModel(userRepository.findByUsername(userModel.getUsername()));
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
