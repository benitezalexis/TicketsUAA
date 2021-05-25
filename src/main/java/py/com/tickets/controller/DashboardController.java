package py.com.tickets.controller;


import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.tickets.entity.Customer;
import py.com.tickets.repository.CustomerRepository;
import py.com.tickets.util.ViewConstants;

/**
 * @author tola on 4/9/20
 **/

@Controller
public class DashboardController {
    @Autowired

    private CustomerRepository cliente;


    @RequestMapping({"/dashboard","/"})
    public String dashboard(){
        return ViewConstants.DASHBOARD; 
    }

    @RequestMapping({"/dashboard/users/","/users"})
    public String users(){
        return ViewConstants.USERS;
    }
    
    @RequestMapping({"/dashboard/tickets/","/tickets"})
    public String tickets(){
        return ViewConstants.TICKETS;
    }
    

    @RequestMapping({"/dashboard/customers/","/customers"})
    public String customers(Model model){
    	List<Customer> clientes= cliente.findAll();
    	model.addAttribute("clientes", clientes);
        return ViewConstants.CUSTOMERS;
    }
}
