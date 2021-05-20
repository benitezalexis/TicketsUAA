package py.com.tickets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.tickets.util.ViewConstants;

/**
 * @author tola on 4/9/20
 **/

@Controller
public class DashboardController {

    @RequestMapping({"/dashboard","/admin"})
    public String dashboard(){
        return ViewConstants.DASHBOARD; 
    }

    @RequestMapping({"/admin/user/list","/admin/user"})
    public String listUser(){
        return "admin/user-list";
    }

    @RequestMapping("/admin/user/add")
    public String addUser(){
        return "admin/user-add";
    }

}
