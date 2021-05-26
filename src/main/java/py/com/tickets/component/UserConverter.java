package py.com.tickets.component;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import py.com.tickets.entity.User;
import py.com.tickets.entity.UserRol;
import py.com.tickets.model.UserModel;
import py.com.tickets.util.LetsCryp;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactConverter.
 */
@Component("contactConverter")
public class UserConverter {

	@Autowired
	private LetsCryp generarPass;
	/**
	 * nos devolvera una entidad contact.
	 *
	 * @param contactModel the contact model
	 * @return the contact
	 */
	@SuppressWarnings("unchecked")
	public User convertUserModel2User(UserModel userModel) {
		User user = new User();
		user.setId(userModel.getId());
		user.setUsername(userModel.getUsername());
		user.setUserRole((Set<UserRol>) userModel.getUserRol());
		user.setPassword(generarPass.encrypt(userModel.getPassword()));
		user.setEnabled(true);
		return user;
	}
	
	/**
	 * Convert contact 2 contact model.
	 *
	 * @param contact the contact
	 * @return the contact model
	 */
	public UserModel  convertUser2UserModel(User user) {
		UserModel userModel = new UserModel();
		userModel.setId(user.getId());
		userModel.setUsername(user.getUsername());
		userModel.setUserRol((UserRol) user.getUserRole());
		userModel.setEnabled(true);
		return userModel;
	}
}
