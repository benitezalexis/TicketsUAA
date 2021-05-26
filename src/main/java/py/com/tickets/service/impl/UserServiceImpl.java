package py.com.tickets.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import py.com.tickets.component.UserConverter;
import py.com.tickets.entity.User;
import py.com.tickets.model.UserModel;
import py.com.tickets.repository.UserRepository;
import py.com.tickets.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConverter;
	
	/**
	 * Al trabajar con un model tenemos que crear un converter que nos permita
	 * transformar de contactModel a entidadContact
	 */
	@Override
	public UserModel insert(UserModel userModel) {
		User user = userRepository.save(userConverter.convertUserModel2User(userModel));
		return userConverter.convertUser2UserModel(user);
	}

	@Override
	public List<UserModel> findAll() {
		List<User> users = userRepository.findAll();//nos devuelve un List de ContactEntity
		List<UserModel> userModel = new ArrayList<UserModel>();
		for(User user : users) {//POR CADA contact IN contacts
			userModel.add(userConverter.convertUser2UserModel(user));//transformamos de contact a contactModel y lo agregamos a dicha lista
		}
		return userModel;//UNA VEZ QUE HAYA RECORRIDO TODA LA LISTA DE CONTACTS Y LOS HAYA TRANSFORMADO A MODEL LO DEVOLVEMOS
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public UserModel findByUserModel(String id) {
		return userConverter.convertUser2UserModel(findByUsername(id));
	}

	@Override
	public void remove(String username) {
		User user = findByUsername(username);
		if(null != user) {
			userRepository.delete(user);
		}
	}


}
