package com.tkksys.backendninja.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tkksys.backendninja.model.ContactModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	@GetMapping("/checkrest")
	public ResponseEntity<ContactModel> checkRest(){
		ContactModel cm = new ContactModel(3, "Saul", "Goodman", "123123123", "Caacupe");
		return new ResponseEntity<ContactModel>(cm, HttpStatus.OK);
	}

}
