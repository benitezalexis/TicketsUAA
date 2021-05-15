package py.com.tickets.service;

import java.util.List;

import py.com.tickets.entity.Contact;
import py.com.tickets.model.ContactModel;

public interface ContactService {

	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> findAllContacts ();
	
	public abstract Contact findContactById(int id);
	
	public abstract void removeContact(int id);
	
	public ContactModel findContactByIdModel(int id);
}
