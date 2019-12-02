package com.tkksys.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.tkksys.backendninja.model.Persona;
import com.tkksys.backendninja.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{
	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Persona> getListPeople() {
		List<Persona> gente = new ArrayList<>();
		gente.add(new Persona("Luis", 23));
		gente.add(new Persona("Carlos", 34));
		gente.add(new Persona("Ana", 45));
		gente.add(new Persona("Luz", 12));
		LOG.info("Hola desde el service");
		return gente;
	}

}
