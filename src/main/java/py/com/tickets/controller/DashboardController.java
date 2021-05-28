package py.com.tickets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.tickets.entity.Customer;
import py.com.tickets.repository.UserRepository;
import py.com.tickets.service.CustomerService;
import py.com.tickets.service.UserService;
import py.com.tickets.util.ViewConstants;

/**
 * @author tola on 4/9/20
 **/

@Controller
public class DashboardController {
	
	@Autowired
    private CustomerService cliente;
		
	@Autowired
	private UserRepository userRepo;

    @RequestMapping({"/dashboard","/"})
    public String dashboard(){
        return ViewConstants.DASHBOARD; 
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')") //AUTORIZACION A NIVEL DE METODO POR TIPO DE ROLE
    @RequestMapping({"/dashboard/users/","/users"})
    public String users(Model model){
    	List<py.com.tickets.entity.User> user = userRepo.findAll();

    	model.addAttribute("users", user);

    	model.addAttribute("user", new py.com.tickets.entity.User());
        return ViewConstants.USERS;
    }
    
    @RequestMapping({"/dashboard/tickets/","/tickets"})
    public String tickets(){
        return ViewConstants.TICKETS;
    }
    
    @ModelAttribute("username")
    public String messages() {
    	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String username = user.getUsername();
        return username;
    }

    @RequestMapping({"/dashboard/customers/","/customers"})
    public String customers(Model model){
    	List<Customer> clientes= cliente.listCustomers();

    	model.addAttribute("customers", clientes);

    	model.addAttribute("customer", new Customer());
        return ViewConstants.CUSTOMERS;
    }
}
