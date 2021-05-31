package py.com.tickets.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import py.com.tickets.component.UserConverter;
import py.com.tickets.entity.User;
import py.com.tickets.entity.UserRol;
import py.com.tickets.model.UserModel;
import py.com.tickets.repository.UserRepository;
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
	private UserRepository userRepo;

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

	@GetMapping("/editUser")
	public String editUser(@RequestParam(name="username", required=true) String username, Model model, @ModelAttribute UserModel userModel) {
		User user = userService.findByUsername(username);
		if(user != null) {
			model.addAttribute("user", user);		
		}
		return "admin/users/editUsers";
		//return "redirect:/users";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(name="username", required=true) String username) {
		User user = userService.findByUsername(username);
		if(user != null) {		
			/*UserRol rol = (UserRol) rolRepo.findByUser(user);
			if(rol != null) {
				roleService.deleteObj(rol);
			}*/
			userService.deleteObj(user);
		}
		return "redirect:/users";
	}



	@PostMapping({ "/saveEditUser" })
	public String saveEditUser(User user) {
		userService.insert(user);
		return "redirect:/users";
	}

}
