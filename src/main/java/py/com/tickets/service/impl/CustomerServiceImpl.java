package py.com.tickets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.com.tickets.entity.Customer;
import py.com.tickets.repository.CustomerRepository;
import py.com.tickets.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Customer> listCustomers() {
		
		return (List<Customer>)customerRepository.findAll();
	}

	@Override
	@Transactional
	public void safeCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Customer findCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customer.getCi()).orElse(null);
	}

	
	
}
