package py.com.tickets.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import py.com.tickets.component.ContactConverter;
import py.com.tickets.entity.Contact;
import py.com.tickets.model.ContactModel;
import py.com.tickets.repository.ContactRepository;
import py.com.tickets.service.ContactService;

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

	@Override
	public List<ContactModel> findAllContacts() {
		List<Contact> contacts = contactRepository.findAll();//nos devuelve un List de ContactEntity
		List<ContactModel> contactModel = new ArrayList<ContactModel>();
		for(Contact contact : contacts) {//POR CADA contact IN contacts
			contactModel.add(contactConverter.convertContact2ContactModel(contact));//transformamos de contact a contactModel y lo agregamos a dicha lista
		}
		return contactModel;//UNA VEZ QUE HAYA RECORRIDO TODA LA LISTA DE CONTACTS Y LOS HAYA TRANSFORMADO A MODEL LO DEVOLVEMOS
	}

	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}
	
	public ContactModel findContactByIdModel(int id) {
		return contactConverter.convertContact2ContactModel(findContactById(id));
	}

	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		if(null != contact) {
			contactRepository.delete(contact);
		}
	}

}
