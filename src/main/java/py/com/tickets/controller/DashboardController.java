package py.com.tickets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.tickets.component.UserConverter;
import py.com.tickets.entity.Customer;
import py.com.tickets.repository.RoleRepository;
import py.com.tickets.repository.UserRepository;
import py.com.tickets.service.CustomerService;
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
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private UserConverter userConver;

    @RequestMapping({"/dashboard","/"})
    public String dashboard(){
        return ViewConstants.DASHBOARD; 
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')") //AUTORIZACION A NIVEL DE METODO POR TIPO DE ROLE
    @RequestMapping({"/dashboard/users/","/users"})
    public String users(Model model){
    	List<py.com.tickets.entity.User> user = userRepo.findAll();
    	List<py.com.tickets.entity.UserRol> rol = roleRepo.findAll();
    	/*List<UserModel> userModel;
    	
    	for (int i = 0; i < user.size(); i++) {
    		userModel = userConver.convertUser2UserModel(user.get(i), null);
		}*/
    	
    	model.addAttribute("users", user);
    	model.addAttribute("roles", rol);
    	
    	model.addAttribute("user", new py.com.tickets.entity.User());
    	model.addAttribute("rol", new py.com.tickets.entity.UserRol());
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
