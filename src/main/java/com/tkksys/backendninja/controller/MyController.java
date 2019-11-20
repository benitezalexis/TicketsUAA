/**
 * <h1>Controller</h1>
 * Es la clase que nos permite obtener las distintas vistas de la aplicacion
 *
 * @author wilson ferreira
 * @version 1.0.0
 * @date 20 nov. 2019
 * @since 1.0.0
 * @lastupdate 20 nov. 2019 - 10:38:55
 * 
 */
 
package com.tkksys.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tkksys.backendninja.util.Util;

@Controller
@RequestMapping("/demos")
public class MyController extends Util{
	
	/**
	 * Metodo de tipo String para obtener una vista, es la manera mas sencilla, pero arcaica
	 * @return index, que es la pagina de inicio en este caso
	 */
	@GetMapping("holamundo")
	public String holaMundo() {
		return "index";
	}
	
	/**
	 * Metodo de tipo String para obtener una vista, utilizado cuando se realizan redirecciones
	 * y no se necesitan insertar datos o muy pocos
	 * @return PAGE_EXAMPLE, en este caso es una constante que se encuentra en otra clase
	 * esto facilita que a la hora de cambiar el nombre de una pagina, solamente la tengas 
	 * que realizar en una constante y no en todos los metodos donde fue invocado.
	 */
	@GetMapping("/primeraForma")
	public String pagina1() {
		return PAGE_EXAMPLE;
	}
	
	/**
	 * Metodo de tipo ModelAndView para obtener una vista, mas utilizado cuando hay que insertar datos 
	 * en la plantilla
	 * @return new ModelAndView(PAGE_EXAMPLE), en este caso es un objeto con constante como parametro
	 * el cual se encuentra en otra clase
	 * esto facilita que a la hora de cambiar el nombre de una pagina, solamente la tengas 
	 * que realizar en una constante y no en todos los metodos donde fue invocado.
	 */
	@GetMapping("/segundaForma")
	public ModelAndView pagina2() {
		return new ModelAndView(PAGE_EXAMPLE) ;
	}
}
