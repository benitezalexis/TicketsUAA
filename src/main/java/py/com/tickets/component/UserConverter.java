package py.com.tickets.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import py.com.tickets.entity.User;
import py.com.tickets.model.UserModel;
import py.com.tickets.util.MyUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class UserConverter.
 */
@Component("userConverter")
public class UserConverter {
	
	@Autowired
	private MyUtil myUtil;

	/**
	 * nos devolvera una entidad user.
	 *
	 * @param userModel the user model
	 * @return the user
	 */
	public User convertUserModel2User(UserModel userModel) {
		User user = new User();
		//user.setId(userModel.getId());
		user.setUsername(userModel.getUsername());
		user.setPassword(myUtil.encriptarPass(userModel.getPassword()));
		user.setEnabled(userModel.isEnabled());
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
		/*if(user.getUsername().equals(rol.getUser())) {			
			userModel.setUserRol(rol.getRole());
		}*/
		
		return userModel;
	}
}
