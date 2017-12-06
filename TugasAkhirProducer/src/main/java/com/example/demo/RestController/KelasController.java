package com.example.demo.RestController;

import com.example.demo.DatabaseService.IRSServiceDatabase;
import com.example.demo.Model.IRS;
import com.example.demo.Model.Kelas;
import com.example.demo.Service.IRSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KelasController {

    @Autowired
    IRSService irsService;

    @GetMapping("/api/kelas/detail/{id}")
    public Kelas viewKelas(@PathVariable(value="id") String id){
        Kelas kelas = new Kelas();
        
        //Dummy
        kelas.setId(1);
        kelas.setIdMataKuliah(1);
        kelas.setKode_mk("CSC123456");
        kelas.setSks(6);
        kelas.setNamaKelas("Kuliner Lanjut");
        return kelas;
    }
}

