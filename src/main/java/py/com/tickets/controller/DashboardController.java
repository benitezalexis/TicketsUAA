package py.com.tickets.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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
    
    @PreAuthorize("hasRole('ROLE_ADMIN')") //AUTORIZACION A NIVEL DE METODO POR TIPO DE ROLE
    @RequestMapping({"/dashboard/users/","/users"})
    public String users(){
        return ViewConstants.USERS;
    }
    
    @RequestMapping({"/dashboard/tickets/","/tickets"})
    public String tickets(){
        return ViewConstants.TICKETS;
    }
}
