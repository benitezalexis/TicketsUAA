package com.tkksys.backendninja.service;

import java.util.List;

import com.tkksys.backendninja.entity.Contact;
import com.tkksys.backendninja.model.ContactModel;

public interface ContactService {

	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> findAllContacts ();
	
	public abstract Contact findContactById(int id);
	
	public abstract void removeContact(int id);
	
	public ContactModel findContactByIdModel(int id);
}
