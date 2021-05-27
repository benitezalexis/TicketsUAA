package py.com.tickets.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import py.com.tickets.entity.Customer;
import py.com.tickets.service.CustomerService;


@Controller
public class CustomerController {

	 @Autowired
     private CustomerService customerService;
	
	
	 
	 
	 @PostMapping({"/addCustomer"})
	    public String addCustomer(Customer customer){
		 if(customerService.findCustomer(customer)!=null) {
			 return "admin/customers/customerexists";
		 }
		 customerService.safeCustomer(customer);
	    return "redirect:/customers";
	    }
	    
	 
	 @GetMapping("/delete/{ci}")
	 public String deleteCustomer(Customer customer) {
		 customerService.deleteCustomer(customer);
		 return "redirect:/customers";
	 }
	
	 
	 @GetMapping("/edit/{ci}")
	 public String editCustomer(Customer customer, Model model) {
		 customer = customerService.findCustomer(customer);
		 model.addAttribute("customer", customer );
		 return "admin/customers/editcustomer";
	 }
	 
	 @PostMapping({"/saveEditCustomer"})
	    public String saveEditCustomer(Customer customer){
		customerService.safeCustomer(customer);
	    return "redirect:/customers";
	    }
	    
	 
	 

}
