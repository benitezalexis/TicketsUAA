package com.tkksys.backendninja.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * Para que Spring sepa que esta clase se encarga de la captura de errores lo anotamos con el 
 * @ControllerAdvice
 * @author DellInspiron
 *
 */
@ControllerAdvice
public class ErrorsController {
	
	public static final String ISE_VIEW = "error/500";//constante de la vista
	
	/**
	 * Con el @ExceptionHandler le indicamos a Spring que debe pasar 
	 * por aca cuando ocurra un error del tipo 500
	 * @return ISE_VIEW, que es la vista de la pagina del error
	 */
	@ExceptionHandler(Exception.class)
	public String showInternalServerError() {
		return ISE_VIEW;
	}
}
