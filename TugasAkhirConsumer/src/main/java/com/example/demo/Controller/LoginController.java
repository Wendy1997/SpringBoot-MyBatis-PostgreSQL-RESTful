package com.example.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Model.Mahasiswa;
import com.example.demo.Service.MahasiswaService;

@Controller
public class LoginController {
	
	@Autowired
	MahasiswaService mahasiswaDAO;
	
    @GetMapping("/mahasiswa/viewall")
    public String mahasiswaViewAll(Model model, ModelMap modelMap){
    	modelMap.addAttribute("user", getPrincipal());
    	
//    	List<Mahasiswa> viewall = mahasiswaDAO.selectAllMahasiswa();
//    	model.addAttribute("mahasiswa", viewall);
    		
        return "dashboard-admin";
    }
    
	@GetMapping(value = "/mahasiswa")
    public String mahasiswaDashboard(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "dashboard-mahasiswa";
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
    
    @GetMapping(value="/")
    public String index () {
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
