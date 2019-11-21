package com.tkksys.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tkksys.backendninja.model.Persona;

@Controller
@RequestMapping("/demos3")
public class My3Controller {
	
	/**
	 * Constante en la que guardamos la vista, para modificar posteriormente desde aqui si cambia el nombre
	 * de la vista
	 */
	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";
	
	
	@GetMapping("/showForm")
	public String showForm(Model modelo) {
		modelo.addAttribute("persona", new Persona());
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute("persona") Persona p) {
		ModelAndView mav = new ModelAndView(RESULT_VIEW);
		mav.addObject("persona", p);
		return mav;
	}
}
