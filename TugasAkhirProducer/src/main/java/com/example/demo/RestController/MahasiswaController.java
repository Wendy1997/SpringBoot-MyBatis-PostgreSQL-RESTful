package com.example.demo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Mahasiswa;
import com.example.demo.Service.MahasiswaService;

@RestController
@RequestMapping("/api")
public class MahasiswaController {

	@Autowired
	MahasiswaService servicemahasiswa;
	
    @GetMapping("/mahasiswa/view/{npm}")
    public Mahasiswa mahasiswaView(@PathVariable(value = "npm") String npm, Model model){
    		Mahasiswa data = servicemahasiswa.dataView(npm);
        return data;
    }

    @GetMapping("/mahasiswa/viewall")
    public List<Mahasiswa> mahasiswaViewAll(Model model){
    		List<Mahasiswa> AllMahasiswa = servicemahasiswa.selectAllMahasiswa();
        return AllMahasiswa;
    }

    @PostMapping("/mahasiswa/add")
    public Mahasiswa mahasiswaAddSubmit(@ModelAttribute Mahasiswa mahasiswa, Model model){
    		servicemahasiswa.addMahasiswa(mahasiswa);
        return mahasiswa;
    }

    @PostMapping("/mahasiswa/update")
    public Mahasiswa mahasiswaUpdateSubmit(@ModelAttribute Mahasiswa mahasiswa, Model model){
    		servicemahasiswa.updateMahasiswa(mahasiswa);
        return mahasiswa;
    }


    @GetMapping("/mahasiswa/riwayat")
    public String mahasiswaRiwayat(){
        return null;
    }

    @GetMapping("/mahasiswa/riwayat/all")
    public String mahasiswaRiwayatAll(){
        return null;
    }
}
