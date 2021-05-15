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

import py.com.tickets.component.ContactConverter;
import py.com.tickets.entity.Contact;
import py.com.tickets.model.ContactModel;
import py.com.tickets.service.ContactService;
import py.com.tickets.util.ViewConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactController.
 */
@Controller
@RequestMapping("/contacts")
public class ContactController {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	/** The contact service. */
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
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
	private String redirectoContactForm(@RequestParam(name="id", required=false) int id, Model model) { //ES required=false PARA QUE EL FORMULARIO PUEDA SER USADO AL AGREGAR NUEVO CONTACTO
		ContactModel contact = new ContactModel(); 
		if(id != 0) {
			contact = contactService.findContactByIdModel(id);
		}
		model.addAttribute("contactModel", contact);
		return ViewConstants.CONTACT_FORM;
	}
	
	/**
	 * Adds the contact.
	 *
	 * @param contactModel the contact model
	 * @param model the model
	 * @return the string
	 */
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel, Model model) { //El String name del @ModelAttribute debe ser igual al th:object del html y el objeto como la clase java
		LOG.info("--METHOD: addContact() --PARAMS:  "+contactModel.toString());
		
		if(null != contactService.addContact(contactModel)) {			
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
	@GetMapping("/showcontacts")
	public ModelAndView showContact() {
		ModelAndView mav = new ModelAndView(ViewConstants.CONTACTS);//PASAMOS LA VISTA DE LA PAGINA CONTACTS AL MAV
		mav.addObject("contacts", contactService.findAllContacts());//AGREGAMOS COMO OBJETO contacts DESDE EL SERVICE CON EL METODO findAllContacts()
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
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name="id", required=true) int id) {
		contactService.removeContact(id);
		return showContact();
	}
}
