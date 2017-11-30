package com.example.demo.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IRSController {

    @GetMapping("/irs/view")
    public String irsView(){
        return "ululululu";
    }

    @GetMapping("/irs/viewall")
    public String irsViewAll(){
        return null;
    }

    @PostMapping("/irs/add")
    public String irsAddSubmit(){
        return null;
    }

    @PostMapping("/irs/update")
    public String irsUpdateSubmit(){
        return null;
    }
}
