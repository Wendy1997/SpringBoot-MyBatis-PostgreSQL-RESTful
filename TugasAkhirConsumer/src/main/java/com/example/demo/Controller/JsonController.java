package com.example.demo.Controller;

import com.example.demo.Model.Kurikulum;
import com.example.demo.Model.Mahasiswa;
import com.example.demo.Model.MataKuliah;
import com.example.demo.Service.MataKuliahService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class JsonController {

    @Autowired
    MataKuliahService mataKuliahService;

    @GetMapping("/json")
    public String getJson(Model model){
        Gson gson = new Gson();

        Kurikulum tes = mataKuliahService.getKurikulum("1", "1","1","1");
        String json = gson.toJson(tes);
        model.addAttribute("json", json);
        return "tesAPI";
    }
}
