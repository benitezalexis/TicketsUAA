package py.com.tickets.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import py.com.tickets.entity.Customer;

public interface CustomerService {

	
	
	public List<Customer> listCustomers() ;

	public void safeCustomer(Customer customer);

	public void deleteCustomer(Customer customer);

	public Customer findCustomer(Customer customer);
}
