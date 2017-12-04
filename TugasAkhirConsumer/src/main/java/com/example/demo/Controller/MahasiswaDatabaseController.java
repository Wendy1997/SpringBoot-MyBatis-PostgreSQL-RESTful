package com.example.demo.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/mahasiswa/viewall")
    public String mahasiswaViewAll(Model model){
    	
    		List<Mahasiswa> viewall = mahasiswaDAO.selectAllMahasiswa();
    		model.addAttribute("mahasiswa", viewall);
        return "dashboard-admin";
    }

    @GetMapping("/mahasiswa/add")
    public String mahasiswaAdd(Model model){
<<<<<<< HEAD
    Map<String, Object> list = fakultasDAO.listUniv();
    Map<String, Object> nama = (Map<String, Object>) list.get("result");
	//ArrayList<String> hasil = (ArrayList<String>) nama.get("univList");
	//String listUniv = hasil.toString().replace("[", "").replace("]", "");
	

    	

=======
    	Gson gson = new Gson();
//    	List<Universitas> univ = kurikulumService.getUniversitasList();
        System.out.println(kurikulumService.getUniversitasList().toString());
        System.out.println(kurikulumService.getUniversitas("1").toString());
        System.out.println(kurikulumService.getFakultasList("1").toString());
        System.out.println(kurikulumService.getFakultas("1", "1").toString());
        System.out.println(kurikulumService.getProdiList("1","1").toString());
        System.out.println(kurikulumService.getProdi("1","1","1").toString());
>>>>>>> 87c4de1418e93356aab8ff16f14243e279919f3b
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
