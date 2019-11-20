/**
 * <h1>Cabecera de la documentacion</h1>
 * Cuerpo de la documentacion
 *
 * @author wilson ferreira
 * @version 1.0.0
 * @date 20 nov. 2019
 * @since 1.0.0
 * @lastupdate 20 nov. 2019 - 08:15:55
 * 
 */
 
package com.tkksys.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/say")
public class HolaMundoController {
	
	@GetMapping("holamundo")
	public String holaMundo() {
		return "index";
	}
}
