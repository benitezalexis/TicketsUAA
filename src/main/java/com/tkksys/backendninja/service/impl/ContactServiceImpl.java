package com.tkksys.backendninja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tkksys.backendninja.component.ContactConverter;
import com.tkksys.backendninja.entity.Contact;
import com.tkksys.backendninja.model.ContactModel;
import com.tkksys.backendninja.repository.ContactRepository;
import com.tkksys.backendninja.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	/**
	 * Al trabajar con un model tenemos que crear un converter que nos permita
	 * transformar de contactModel a entidadContact
	 */
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
		return contactConverter.convertContact2ContactModel(contact);
	}

}
