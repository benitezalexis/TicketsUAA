package py.com.tickets.component;

import java.util.Set;

import org.springframework.stereotype.Component;

import py.com.tickets.entity.User;
import py.com.tickets.entity.UserRol;
import py.com.tickets.model.UserModel;

// TODO: Auto-generated Javadoc
/**
 * The Class UserConverter.
 */
@Component("userConverter")
public class UserConverter {

	/**
	 * nos devolvera una entidad user.
	 *
	 * @param userModel the user model
	 * @return the user
	 */
	@SuppressWarnings("unchecked")
	public User convertUserModel2User(UserModel userModel) {
		User user = new User();
		//user.setId(userModel.getId());
		user.setUsername(userModel.getUsername());
		user.setPassword(userModel.getPassword());
		user.setEnabled(userModel.isEnabled());
		user.setUserRole((Set<UserRol>) userModel.getUserRol());
		return user;
	}
	
	/**
	 * Convert user 2 user model.
	 *
	 * @param user the user
	 * @return the user model
	 */
	public UserModel  convertUser2UserModel(User user) {
		UserModel userModel = new UserModel();
		//userModel.setId(user.getId());
		userModel.setUsername(user.getUsername());
		userModel.setPassword(user.getPassword());
		userModel.setEnabled(user.isEnabled());
		userModel.setUserRol((UserRol) user.getUserRole());
		return userModel;
	}
}
