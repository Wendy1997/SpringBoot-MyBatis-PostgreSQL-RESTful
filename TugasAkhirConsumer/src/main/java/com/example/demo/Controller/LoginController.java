package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping(value = {"/mahasiswa"})
    public String mahasiswaDashboard(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "dashboard-mahasiswa";
    }
 
    @GetMapping(value = "/mahasiswa/viewall")
    public String mahasiswaViewAll(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "dashboard-admin";
    }
 
    @GetMapping(value = "/login")
    public String login() {
        return "index";
    }
 
    @GetMapping(value="/logout")
    public String logout (HttpServletRequest request, HttpServletResponse response) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }
 
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
