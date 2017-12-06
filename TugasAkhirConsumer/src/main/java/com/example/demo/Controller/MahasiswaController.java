package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.DAO.MahasiswaDAOImpl;
import com.example.demo.Model.IRS;
import com.example.demo.Model.Mahasiswa;
import com.example.demo.RestService.IRSServiceRest;
import com.example.demo.RestService.KelasServiceRest;
import com.example.demo.Service.FakultasService;
import com.example.demo.Service.IRSService;
import com.example.demo.Service.MahasiswaService;

@Controller
public class MahasiswaController {
	
	@Autowired
    IRSServiceRest irsService;
	
	@Autowired
    KelasServiceRest kelasService;
	
    @GetMapping("/mahasiswa")
    public String mahasiswaDashboard(){
        return "dashboard-mahasiswa";
    }

    @GetMapping("/mahasiswa/riwayat/{id}")
    public String mahasiswaRiwayat(
    		@PathVariable(value="id") String id,
    		Model model){
    	
    	//Get IRS
    	List<IRS> irs = irsService.getAllIRS(id);	
    	model.addAttribute("irs", irs);
    	
    	//Get Kelas
   
        return "riwayat";
    }
    
    @GetMapping("/mahasiswa/ringkasan")
    public String mahasiswaRingkasan(){
        return "lihat-mahasiswa";
    }
}
