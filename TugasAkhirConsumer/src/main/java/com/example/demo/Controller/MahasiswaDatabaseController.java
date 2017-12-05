package com.example.demo.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.Service.KurikulumService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Fakultas;
import com.example.demo.Model.Mahasiswa;
import com.example.demo.Model.ProgramStudi;
import com.example.demo.Model.Universitas;
import com.example.demo.RestService.KurikulumServiceRest;
import com.example.demo.Service.FakultasService;
import com.example.demo.Service.MahasiswaService;
import com.google.gson.Gson;

@Controller
public class MahasiswaDatabaseController {

	@Autowired
	MahasiswaService mahasiswaDAO;
	
	@Autowired
	FakultasService fakultasDAO;

	@Autowired
    KurikulumService kurikulumService;
	
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
    		System.out.println(resultFakultas.get("fakultas"));
    		
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

//    @GetMapping("/mahasiswa/viewall")
//    public String mahasiswaViewAll(Model model){
//    		List<Mahasiswa> viewall = mahasiswaDAO.selectAllMahasiswa();
//    		for(int i = 0; i < viewall.size(); i++) {
//    			System.out.println(viewall.get(i).getId_univ() +" "+ viewall.get(i).getId_fakultas());
//    			Map<String, Object> fakultas = fakultasDAO.namaFakultas(viewall.get(i).getId_univ(), viewall.get(i).getId_fakultas());
//    			Map<String, Object> resultFakultas = (Map<String, Object>) fakultas.get("result");
//    			Map<String, Object> namafakultas = (Map<String, Object>) resultFakultas.get("fakultas");
//    			
//    			String namaFakultas = namafakultas.get("nama_fakultas").toString();
//    			System.out.println(namaFakultas);
//    			viewall.get(i).setNama_fakultas(namaFakultas);
//    			
//    			Map<String, Object> prodi = fakultasDAO.namaProdi(viewall.get(i).getId_univ(), viewall.get(i).getId_fakultas(), viewall.get(i).getId_program_studi());
//    	   	    Map<String, Object> resultProdi = (Map<String, Object>) prodi.get("result");
//    			Map<String, Object> namaprodi = (Map<String, Object>) resultProdi.get("prodi");
//    			
//    			String namaProdi = namaprodi.get("nama_prodi").toString();
//    			viewall.get(i).setNama_prodi(namaProdi);
//    		}
//    		
//    		model.addAttribute("mahasiswa", viewall);
//        return "dashboard-admin";
//    }

    @GetMapping("/mahasiswa/add")
    public String mahasiswaAdd(@RequestParam(value = "id_univ", required = false) Integer id_univ, Model model){

    List<Universitas> listUniv = kurikulumService.getUniversitasList();
    model.addAttribute("univ", listUniv);
        return "tambah-mahasiswa";
    }
    
    @PostMapping("/mahasiswa/add/fakultas")
    public void mahasiswaAddFakultas(HttpServletRequest request, HttpServletResponse response) throws IOException {
    		
    List<Fakultas> fakultas = kurikulumService.getFakultasList(Integer.parseInt(request.getParameter("namafakultas")));
    
    Gson gson = new Gson();
    String hasil = gson.toJson(fakultas);
    
    PrintWriter out = response.getWriter();
    out.println(hasil);
    }
    
    @PostMapping("/mahasiswa/add/prodi")
    public void mahasiswaAddprodi(HttpServletRequest request, HttpServletResponse response) throws IOException {
    		
    List<ProgramStudi> prodi = kurikulumService.getProdiList(Integer.parseInt(request.getParameter("namafakultas")), Integer.parseInt(request.getParameter("namaprodi")));
    
    Gson gson = new Gson();
    String hasil = gson.toJson(prodi);
    
    PrintWriter out = response.getWriter();
    out.println(hasil);
    }

    @PostMapping("/mahasiswa/update/fakultas")
    public void mahasiswaUpdateFakultas(HttpServletRequest request, HttpServletResponse response) throws IOException {
    		
	    List<Fakultas> fakultas = kurikulumService.getFakultasList(Integer.parseInt(request.getParameter("namafakultas")));
	    
	    Gson gson = new Gson();
	    String hasil = gson.toJson(fakultas);
	    
	    PrintWriter out = response.getWriter();
	    out.println(hasil);
    }
    
    
    @PostMapping("/mahasiswa/update/prodi")
    public void mahasiswaUpdateprodi(HttpServletRequest request, HttpServletResponse response) throws IOException {
    		
    	List<ProgramStudi> prodi = kurikulumService.getProdiList(Integer.parseInt(request.getParameter("namafakultas")), Integer.parseInt(request.getParameter("namaprodi")));
        
        Gson gson = new Gson();
        String hasil = gson.toJson(prodi);
        
        PrintWriter out = response.getWriter();
        out.println(hasil);
    }


    @PostMapping("/mahasiswa/add")
    public String mahasiswaAddSubmit(@ModelAttribute Mahasiswa mahasiswa, Model model){
    		mahasiswaDAO.add(mahasiswa);
    		
        return "dashboard-mahasiswa";
    }

    @GetMapping("/mahasiswa/update/{npm}")
    public String mahasiswaUpdate(@PathVariable(value = "npm") String npm, Model model ){
    		Mahasiswa mahasiswa = mahasiswaDAO.dataView(npm);
    		model.addAttribute("data", mahasiswa);
    		List<Universitas> listUniv = kurikulumService.getUniversitasList();
    		model.addAttribute("univ", listUniv);
        return "ubah-mahasiswa";
    }

    @PostMapping("/mahasiswa/update")
    public String mahasiswaUpdateSubmit(@ModelAttribute Mahasiswa mahasiswa, Model model){
    		mahasiswaDAO.update(mahasiswa);
    		return "dashboard-mahasiswa";
    }

    @PostMapping("/mahasiswa/delete")
    public String mahasiswaDeleteSubmit(){
        return null;
    }
}
