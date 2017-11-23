package com.example.demo.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MahasiswaController {

    @GetMapping("/mahasiswa/view")
    public String mahasiswaView(){
        return null;
    }

    @GetMapping("/mahasiswa/viewall")
    public String mahasiswaViewAll(){
        return null;
    }

    @PostMapping("/mahasiswa/add")
    public String mahasiswaAddSubmit(){
        return null;
    }

    @PostMapping("/mahasiswa/update")
    public String mahasiswaUpdateSubmit(){
        return null;
    }

    @PostMapping("/mahasiswa/delete")
    public String mahasiswaDeleteSubmit(){
        return null;
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
