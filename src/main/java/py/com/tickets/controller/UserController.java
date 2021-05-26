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
	
	/** The contact service. */
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	/**
	 * Cancel.
	 *
	 * @return the string
	 */
	@GetMapping("/cancel")
	private String cancel() {
		return "redirect:/contacts/showcontacts";
	}
	
	/**
	 * Redirecto contact form.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") //AUTORIZACION A NIVEL DE METODO POR TIPO DE ROLE
	@GetMapping("/contactsform")
	private String redirectoContactForm(@RequestParam(name="username", required=false) String username, Model model) { //ES required=false PARA QUE EL FORMULARIO PUEDA SER USADO AL AGREGAR NUEVO CONTACTO
		UserModel userModel = new UserModel(); 
		if(username != null) {
			userModel = userService.findByUserModel(username);
		}
		model.addAttribute("userModel", userModel);
		return ViewConstants.USERS;
	}
	
	/**
	 * Adds the contact.
	 *
	 * @param userModel the contact model
	 * @param model the model
	 * @return the string
	 */
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name="contactModel") UserModel userModel, Model model) { //El String name del @ModelAttribute debe ser igual al th:object del html y el objeto como la clase java
		LOG.info("--METHOD: addContact() --PARAMS:  "+userModel.toString());
		
		if(null != userService.insert(userModel)) {			
			model.addAttribute("result", 1);
		}else {
			model.addAttribute("result", 0);
		}
		return "redirect:/contacts/showcontacts";
	}
	
	/**
	 * Show contact.
	 *
	 * @return the model and view
	 */
	@GetMapping("/showAll")
	public ModelAndView showAll() {
		ModelAndView mav = new ModelAndView(ViewConstants.USERS);//PASAMOS LA VISTA DE LA PAGINA CONTACTS AL MAV
		mav.addObject("users", userService.findAll());//AGREGAMOS COMO OBJETO contacts DESDE EL SERVICE CON EL METODO findAllContacts()
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		return mav;
	}
	
	/**
	 * Removes the contact.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@GetMapping("/remove")
	public ModelAndView remove(@RequestParam(name="username", required=true) String username) {
		userService.remove(username);
		return showAll();
	}
}
