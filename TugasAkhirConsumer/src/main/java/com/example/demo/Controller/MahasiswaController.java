package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MahasiswaController {

    @GetMapping("/mahasiswa")
    public String mahasiswaDashboard(){
        return "dashboard-mahasiswa";
    }

    @GetMapping("/mahasiswa/riwayat")
    public String mahasiswaRiwayat(){
        return "riwayat";
    }

    @GetMapping("/mahasiswa/ringkasan")
    public String mahasiswaRingkasan(){
        return "lihat-mahasiswa";
    }
}
