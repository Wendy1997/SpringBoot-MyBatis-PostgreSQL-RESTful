package com.example.demo.RestController;

import com.example.demo.DatabaseService.IRSServiceDatabase;
import com.example.demo.Model.IRS;
import com.example.demo.Service.IRSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IRSController {

    @Autowired
    IRSService irsService;

    @GetMapping("/irs/view/{id}")
    public IRS irsView(@PathVariable(value="id") String id){
        IRS irs = irsService.getIRS(id);
        return irs;
    }

    @GetMapping("/irs/viewall/{id}")
    public List<IRS> irsViewAll(@PathVariable(value="id") String id){
        List<IRS> irsList = irsService.getAllIRS(id);
        return irsList;
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
