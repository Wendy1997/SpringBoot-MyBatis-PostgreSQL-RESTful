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

import com.example.demo.Service.KelasService;

@Controller
public class MahasiswaController {

    @GetMapping("/mahasiswa/riwayat")
    public String mahasiswaRiwayat(){
        return "riwayat";
    }
    
    @GetMapping("/mahasiswa/ringkasan")
    public String mahasiswaRingkasan(){
        return "lihat-mahasiswa";
    }
}
