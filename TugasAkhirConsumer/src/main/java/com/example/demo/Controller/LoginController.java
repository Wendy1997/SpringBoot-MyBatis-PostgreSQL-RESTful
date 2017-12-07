package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Mahasiswa;
import com.example.demo.Service.FakultasService;
import com.example.demo.Service.MahasiswaService;

@Controller
public class LoginController {
	
	@Autowired
	MahasiswaService mahasiswaDAO;
	
	@Autowired
	FakultasService fakultasDAO;
	
    @GetMapping("/mahasiswa/viewall")
    public String mahasiswaViewAll(Model model, ModelMap modelMap){
    	
    	List<Mahasiswa> viewall = mahasiswaDAO.selectAllMahasiswa();
    	String username = "";
    	int counter = 0;
    	
    	String[] nama = viewall.get(viewall.size()-1).getNama().split(" ");
		if(nama.length > 1) {
			username = nama[0].toLowerCase() + "." + nama[1].toLowerCase();
		} else {
			username = nama[0].toLowerCase();
		}
		
		for(int i = 0; i < viewall.size(); i++) {
			if(i != viewall.size()) {
				String[] namaTemp = viewall.get(i).getNama().split(" ");
				String usernameTemp = "";
				if(namaTemp.length > 1) {
					usernameTemp = namaTemp[0].toLowerCase() + "." + namaTemp[1].toLowerCase();
					if(username.equalsIgnoreCase(usernameTemp)) {
						counter = counter + 1;
					}
				} else {
					usernameTemp = namaTemp[0].toLowerCase();
					if(username.equalsIgnoreCase(usernameTemp)) {
						counter = counter + 1;
					}
				}
			}
			
			Map<String, Object> fakultas = fakultasDAO.namaFakultas(viewall.get(i).getId_univ(), viewall.get(i).getId_fakultas());
			Map<String, Object> resultFakultas = (Map<String, Object>) fakultas.get("result");
			Map<String, Object> namafakultas = (Map<String, Object>) resultFakultas.get("fakultas");
			
			String namaFakultas = namafakultas.get("nama_fakultas").toString();
//			System.out.println(namaFakultas);
			viewall.get(i).setNama_fakultas(namaFakultas);
			
			Map<String, Object> prodi = fakultasDAO.namaProdi(viewall.get(i).getId_univ(), viewall.get(i).getId_fakultas(), viewall.get(i).getId_program_studi());
	   	    Map<String, Object> resultProdi = (Map<String, Object>) prodi.get("result");
			Map<String, Object> namaprodi = (Map<String, Object>) resultProdi.get("prodi");
			
			String namaProdi = namaprodi.get("nama_prodi").toString();
			viewall.get(i).setNama_prodi(namaProdi);
		}
		
		if(counter > 1) {
			username = username + counter + "";
		}
		System.out.println(counter);
		
		String id = mahasiswaDAO.getId(username) + "";
		System.out.println(id);
		if(Integer.parseInt(id) <= 0) {
			System.out.println(username);
			mahasiswaDAO.addUser(username, viewall.get(viewall.size()-1).getId());
			mahasiswaDAO.addUserRole(viewall.get(viewall.size()-1).getId(), username);			
		}
		
		model.addAttribute("mahasiswa", viewall);
    	model.addAttribute("user", getPrincipal());    		
        return "dashboard-admin";
    }
    
	@GetMapping(value = "/mahasiswa")
    public String mahasiswaDashboard(ModelMap model) {
        Mahasiswa mahasiswa = mahasiswaDAO.view(mahasiswaDAO.getId(getPrincipal()));
		
        System.out.println(mahasiswa);
		
        Map<String, Object> fakultas = fakultasDAO.namaFakultas(mahasiswa.getId_univ(), mahasiswa.getId_fakultas());
		Map<String, Object> resultFakultas = (Map<String, Object>) fakultas.get("result");
		Map<String, Object> namafakultas = (Map<String, Object>) resultFakultas.get("fakultas");
		
		String namaFakultas = namafakultas.get("nama_fakultas").toString();
		mahasiswa.setNama_fakultas(namaFakultas);
		
		Map<String, Object> prodi = fakultasDAO.namaProdi(mahasiswa.getId_univ(), mahasiswa.getId_fakultas(), mahasiswa.getId_program_studi());
   	    Map<String, Object> resultProdi = (Map<String, Object>) prodi.get("result");
		Map<String, Object> namaprodi = (Map<String, Object>) resultProdi.get("prodi");
		
		String namaProdi = namaprodi.get("nama_prodi").toString();
		mahasiswa.setNama_prodi(namaProdi);
		
        model.addAttribute("user", getPrincipal());
		model.addAttribute(mahasiswa);
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
        return "redirect:/login?logout";
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
