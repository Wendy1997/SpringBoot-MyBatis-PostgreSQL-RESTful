package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MahasiswaDatabaseController {

    @GetMapping("/mahasiswa/view")
    public String mahasiswaView(){
        return "lihat-mahasiswa";
    }

//    @GetMapping("/mahasiswa/viewall")
//    public String mahasiswaViewAll(){
//        return "dashboard-admin";
//    }

    @GetMapping("/mahasiswa/add")
    public String mahasiswaAdd(){
        return "ubah-mahasiswa";
    }

    @PostMapping("/mahasiswa/add")
    public String mahasiswaAddSubmit(){
        return null;
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
