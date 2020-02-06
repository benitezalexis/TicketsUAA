package com.tkksys.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tkksys.backendninja.model.ContactModel;
import com.tkksys.backendninja.service.ContactService;
import com.tkksys.backendninja.util.ViewConstants;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	@GetMapping("/cancel")
	private String cancel() {
		return "redirect:/contacts/showcontacts";
	}
	
	@GetMapping("/contactsform")
	private String redirectoContactForm(Model model) {
		model.addAttribute("contactModel", new ContactModel());
		return ViewConstants.CONTACT_FORM;
	}
	
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
	
	@GetMapping("/showcontacts")
	public ModelAndView showContact() {
		ModelAndView mav = new ModelAndView(ViewConstants.CONTACTS);//PASAMOS LA VISTA DE LA PAGINA CONTACTS AL MAV
		mav.addObject("contacts", contactService.findAllContacts());//AGREGAMOS COMO OBJETO contacts DESDE EL SERVICE CON EL METODO findAllContacts()
		return mav;
	}
	
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name="id", required=true) int id) {
		contactService.removeContact(id);
		return showContact();
	}
}
