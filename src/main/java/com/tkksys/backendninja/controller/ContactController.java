package com.tkksys.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tkksys.backendninja.util.ViewConstants;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	@GetMapping("/contactsform")
	private String redirectoContactForm() {
		return ViewConstants.CONTACT_FORM;
	}
}
