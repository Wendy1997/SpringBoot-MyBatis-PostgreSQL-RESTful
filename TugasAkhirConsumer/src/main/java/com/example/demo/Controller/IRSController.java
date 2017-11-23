package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IRSController {

    @GetMapping("/irs/view")
    public String irsView(){
        return "lihat-irs";
    }

    @GetMapping("/irs/add")
    public String irsAdd(){
        return "ubah-irs";
    }

    @PostMapping("/irs/add")
    public String irsAddSubmit(){
        return null;
    }

    @GetMapping("/irs/update")
    public String irsUpdate(){
        return "ubah-irs";
    }

    @PostMapping("/irs/update")
    public String irsUpdateSubmit(){
        return null;
    }
}
