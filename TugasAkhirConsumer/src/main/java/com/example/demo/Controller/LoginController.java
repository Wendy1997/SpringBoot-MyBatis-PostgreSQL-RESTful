package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

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
		for(int i = 0; i < viewall.size(); i++) {
//			System.out.println(viewall.get(i).getId_univ() +" "+ viewall.get(i).getId_fakultas());
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
		
		model.addAttribute("mahasiswa", viewall);
    	modelMap.addAttribute("user", getPrincipal());    		
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
