package com.example.demo.Controller;

import java.io.IOException;
import java.util.ArrayList;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.carrotsearch.ant.tasks.junit4.dependencies.com.google.common.reflect.TypeToken;
import com.example.demo.Model.Fakultas;
import com.example.demo.Model.Mahasiswa;
import com.example.demo.Model.Universitas;
import com.example.demo.Service.FakultasService;
import com.example.demo.Service.MahasiswaService;
import com.google.gson.Gson;

@Controller
public class MahasiswaDatabaseController {

	@Autowired
	MahasiswaService mahasiswaDAO;
	
	@Autowired
	FakultasService fakultasDAO;
<<<<<<< HEAD

	
    @GetMapping("/mahasiswa/view/{npm}")
    public String mahasiswaView(@PathVariable(value="npm") String npm, Model model){
    		Mahasiswa view = mahasiswaDAO.dataView(npm);
    		System.out.println(view.getId_fakultas());
    		Map<String, Object> universitas = fakultasDAO.namaUniv(view.getId_univ());
    		Map<String, Object> resultUniversitas = (Map<String, Object>) universitas.get("result");
    		Map<String, Object> namauniversitas = (Map<String, Object>) resultUniversitas.get("universitas");
    		
    		String namaUniversitas = namauniversitas.get("nama_univ").toString();
    		model.addAttribute("universitas", namaUniversitas);
    		
    		Map<String, Object> fakultas = fakultasDAO.namaFakultas(view.getId_univ(), view.getId_fakultas());
    		Map<String, Object> resultFakultas = (Map<String, Object>) fakultas.get("result");
    		Map<String, Object> namafakultas = (Map<String, Object>) resultFakultas.get("fakultas");
    		
    		String namaFakultas = namafakultas.get("nama_fakultas").toString();
    		model.addAttribute("fakultas", namaFakultas);
    		

    		Map<String, Object> prodi = fakultasDAO.namaProdi(view.getId_univ(), view.getId_fakultas(), view.getId_program_studi());
       	Map<String, Object> resultProdi = (Map<String, Object>) prodi.get("result");
    		Map<String, Object> namaprodi = (Map<String, Object>) resultProdi.get("prodi");
    		
    		String namaProdi = namaprodi.get("nama_prodi").toString();
    		model.addAttribute("prodi", namaProdi);
    		
    		model.addAttribute("mahasiswa", view);
        return "lihat-mahasiswa";
    }

    @GetMapping("/mahasiswa/viewall")
    public String mahasiswaViewAll(Model model){
    	
    		List<Mahasiswa> viewall = mahasiswaDAO.selectAllMahasiswa();
    		model.addAttribute("mahasiswa", viewall);
        return "dashboard-admin";
=======

	
    @GetMapping("/mahasiswa/view/{npm}")
    public String mahasiswaView(@PathVariable(value="npm") String npm, Model model){
    		Mahasiswa view = mahasiswaDAO.dataView(npm);
    		System.out.println(view.getId_fakultas());
    		Map<String, Object> universitas = fakultasDAO.namaUniv(view.getId_univ());
    		Map<String, Object> resultUniversitas = (Map<String, Object>) universitas.get("result");
    		Map<String, Object> namauniversitas = (Map<String, Object>) resultUniversitas.get("universitas");
    		
    		String namaUniversitas = namauniversitas.get("nama_univ").toString();
    		model.addAttribute("universitas", namaUniversitas);
    		
    		Map<String, Object> fakultas = fakultasDAO.namaFakultas(view.getId_univ(), view.getId_fakultas());
    		Map<String, Object> resultFakultas = (Map<String, Object>) fakultas.get("result");
    		Map<String, Object> namafakultas = (Map<String, Object>) resultFakultas.get("fakultas");
    		
    		String namaFakultas = namafakultas.get("nama_fakultas").toString();
    		model.addAttribute("fakultas", namaFakultas);
    		

    		Map<String, Object> prodi = fakultasDAO.namaProdi(view.getId_univ(), view.getId_fakultas(), view.getId_program_studi());
       	Map<String, Object> resultProdi = (Map<String, Object>) prodi.get("result");
    		Map<String, Object> namaprodi = (Map<String, Object>) resultProdi.get("prodi");
    		
    		String namaProdi = namaprodi.get("nama_prodi").toString();
    		model.addAttribute("prodi", namaProdi);
    		
    		model.addAttribute("mahasiswa", view);
        return "lihat-mahasiswa";
>>>>>>> login
    }

    @GetMapping("/mahasiswa/add")
    public String mahasiswaAdd(Model model){
    	Gson gson = new Gson();
    	String univ = fakultasDAO.listUniv();
    	List<Universitas> namaUniv = gson.fromJson(univ, null);
    	System.out.println("nama = " + univ.toString());
    	model.addAttribute("univ", univ);

        return "tambah-mahasiswa";
    }
    
    @PostMapping("/mahasiswa/add/fakultas")
    public void mahasiswaAddFakultas(HttpServletRequest request, HttpServletResponse response) throws IOException {
    		
    List<Fakultas> fakultas = fakultasDAO.listFakultas(Integer.parseInt(request.getParameter("namafakultas")));
    Gson gson = new Gson();
    String hasil = gson.toJson(fakultas);
    System.out.println(hasil);
        
    }


    @PostMapping("/mahasiswa/add")
    public String mahasiswaAddSubmit(@ModelAttribute Mahasiswa mahasiswa, Model model){
    		mahasiswaDAO.add(mahasiswa);
    		
        return "dashboard-mahasiswa";
    }

    @GetMapping("/mahasiswa/update")
    public String mahasiswaUpdate(){
        return "ubah-mahasiswa";
    }

    @PostMapping("/mahasiswa/update")
    public String mahasiswaUpdateSubmit(){
        return null;
    }

    @PostMapping("/mahasiswa/delete")
    public String mahasiswaDeleteSubmit(){
        return null;
    }
}
