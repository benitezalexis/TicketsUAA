package py.com.tickets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.tickets.util.ViewConstants;

/**
 * @author tola on 4/9/20
 **/

@Controller
public class DashboardController {

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
    public String customers(){
        return ViewConstants.CUSTOMERS;
    }
}
