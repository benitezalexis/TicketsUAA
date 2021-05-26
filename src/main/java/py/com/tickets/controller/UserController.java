package py.com.tickets.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import py.com.tickets.component.UserConverter;
import py.com.tickets.model.UserModel;
import py.com.tickets.service.UserService;
import py.com.tickets.util.ViewConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactController.
 */
@Controller
@RequestMapping("/users")
public class UserController {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(UserController.class);
	
	@Autowired
	private UserConverter userConverter;
	
	/** The contact service. */
	@Autowired
	@Qualifier("contactServiceImpl")
	private UserService userService;
	
	/**
	 * Cancel.
	 *
	 * @return the string
	 */
	@GetMapping("/cancel")
	private String cancel() {
		return "redirect:/users/showusers";
	}
	
	/**
	 * Redirecto contact form.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") //AUTORIZACION A NIVEL DE METODO POR TIPO DE ROLE
	@GetMapping("/userform")
	private String redirecToUserForm(@RequestParam(name="id", required=false) Long id, Model model) { //ES required=false PARA QUE EL FORMULARIO PUEDA SER USADO AL AGREGAR NUEVO CONTACTO
		UserModel user = new UserModel(); 
		if(id != 0) {
			user = userConverter.convertUser2UserModel(userService.getById(id));
		}
		model.addAttribute("contactModel", user);
		return ViewConstants.USERS;
	}
	
	/**
	 * Adds the contact.
	 *
	 * @param contactModel the contact model
	 * @param model the model
	 * @return the string
	 */
	@PostMapping("/adduser")
	public String addUser(@ModelAttribute(name="userModel") UserModel userModel, Model model) { //El String name del @ModelAttribute debe ser igual al th:object del html y el objeto como la clase java
		LOG.info("--METHOD: addContact() --PARAMS:  "+userModel.toString());
		
		if(null != userService.insert(userConverter.convertUserModel2User(userModel))) {			
			model.addAttribute("result", 1);
		}else {
			model.addAttribute("result", 0);
		}
		return "redirect:/users/showusers";
	}
	
	/**
	 * Show contact.
	 *
	 * @return the model and view
	 */
	@GetMapping("/showusers")
	public ModelAndView showUser() {
		ModelAndView mav = new ModelAndView(ViewConstants.USERS);//PASAMOS LA VISTA DE LA PAGINA USERS AL MAV
		mav.addObject("users", userService.getList(null)); //AGREGAMOS COMO OBJETO contacts DESDE EL SERVICE CON EL METODO findAllContacts()
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		return mav;
	}
	
	/**
	 * Removes the user.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@GetMapping("/removeuser")
	public ModelAndView removeContact(@RequestParam(name="id", required=true) Long id) {
		py.com.tickets.entity.User user = userService.getById(id);
		if(null != user) {
			userService.delete(id);;
		}
		return showUser();
	}
}
