package py.com.tickets.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import py.com.tickets.component.UserConverter;
import py.com.tickets.entity.User;
import py.com.tickets.entity.UserRol;
import py.com.tickets.model.UserModel;
import py.com.tickets.service.RoleService;
import py.com.tickets.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactController.
 */
@Controller
public class UserController {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(UserController.class);

	/** The contact service. */
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@Autowired
	@Qualifier("roleServiceImpl")
	private RoleService roleService;

	@Autowired
	private UserConverter userConverter;

	/**
	 * Adds nre user.
	 *
	 * @param userModel the contact model
	 * @param model     the model
	 * @return the string
	 */
	@PostMapping("/addNewUser")
	public String addNewUser(UserModel userModel) {
		LOG.info("--METHOD: addNewUser() --PARAMS:  " + userModel.toString());
		if (userService.findByUsername(userModel.getUsername()) != null) {
			return "admin/customers/customerexists";
		}
		//Primero se inserta el usuario
		userService.insert(userConverter.convertUserModel2User(userModel));
		//Despues se carga el rol
		roleService.insert(new UserRol(userConverter.convertUserModel2User(userModel), userModel.getUserRol()));
		
		return "redirect:/users";
	}

	@GetMapping("/delete/{username}")
	public String delete(@PathVariable String username) {
		User user = userService.findByUsername(username);
		if(user != null) {			
			userService.deleteObj(user);
		}
		return "redirect:/users";
	}

	@GetMapping("/edit/{username}")
	public String editUser(User user, Model model) {
		user = userService.findByUsername(user.getUsername());
		model.addAttribute("user", user);
		return "admin/customers/editcustomer";
	}

	@PostMapping({ "/saveEditUser" })
	public String saveEditUser(User user) {
		userService.insert(user);
		return "redirect:/users";
	}

}
