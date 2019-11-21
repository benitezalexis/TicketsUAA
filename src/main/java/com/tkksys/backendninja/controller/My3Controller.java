package com.tkksys.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
	
	/**
	 * Primera forma de redirigir a una direccion
	 * @return la direccion a la cual sera redirigida el usuario
	 */
	/*@GetMapping("/")
	public String redirect() {
		return "redirect:/demos3/showForm";
	}*/
	
	/**
	 * La segunda forma de redireccionar es utilizando el RedirectView que nos proporcion Spring
	 * @return un nuevo objeto de tipo RedirectView con el path como parametro
	 */
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/demos3/showForm");
	}
	
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
