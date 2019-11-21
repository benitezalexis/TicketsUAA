package com.tkksys.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tkksys.backendninja.util.Util;

@Controller
@RequestMapping("/demos2")
public class My2Controller extends Util{

	/**
	 * Primera forma de realizar un request de tipo GET
	 * "localhost:8080/demos2/request1?nm=JON"
	 * @return
	 */
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name = "nm", required = false, defaultValue = "NULL") String name) {
		ModelAndView mav = new ModelAndView(PAGE_EXAMPLE2);
		mav.addObject("nm_in_model", name);
		return mav;
	}
	
	/**
	 * Segunda forma de realizar un request de tipo GET
	 * "localhost:8080/demos2/request2/JON"
	 * @return
	 */
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable("nm") String name) {
		ModelAndView mav = new ModelAndView(PAGE_EXAMPLE2);
		mav.addObject("nm_in_model", name);
		return mav;
	}
}
