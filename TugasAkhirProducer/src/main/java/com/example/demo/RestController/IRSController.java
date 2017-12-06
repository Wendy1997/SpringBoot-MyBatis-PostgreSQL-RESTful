package com.example.demo.RestController;

import com.example.demo.DatabaseService.IRSServiceDatabase;
import com.example.demo.Model.IRS;
import com.example.demo.Service.IRSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class IRSController {

    @Autowired
    IRSService irsService;

    @GetMapping("/irs/view/{id}")
    public ResponseEntity<Object> irsView(@PathVariable(value="id") String id){
        Map<String, Object> responseJSON = new LinkedHashMap<>();
        try {
            IRS irs = irsService.getIRS(id);
            System.out.println(irs);
            if(irs == null) {
                responseJSON.put("status", HttpStatus.NOT_FOUND.value());
                responseJSON.put("msg", "irs tidak ditemukan");
            }else {
                responseJSON.put("status", HttpStatus.OK.value());
                responseJSON.put("msg", "success");
                responseJSON.put("result", irs);
            }
        }catch (Exception e) {
            e.printStackTrace();
            responseJSON.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseJSON.put("msg", "internal server error");
        }
        return ResponseEntity.status((Integer) responseJSON.get("status")).body(responseJSON);
    }

    @GetMapping("/irs/viewall/{id}")
    public ResponseEntity<Object> irsViewAll(@PathVariable(value="id") String id){
        Map<String, Object> responseJSON = new LinkedHashMap<>();
        try {
            List<IRS> irsList = irsService.getAllIRS(id);

            if(irsList.size() == 0) {
                responseJSON.put("status", HttpStatus.NOT_FOUND.value());
                responseJSON.put("msg", "list irs tidak ditemukan");
            }else {
                responseJSON.put("status", HttpStatus.OK.value());
                responseJSON.put("msg", "success");
                responseJSON.put("result", irsList);
            }
        }catch (Exception e) {
            e.printStackTrace();
            responseJSON.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseJSON.put("msg", "internal server error");
        }
        return ResponseEntity.status((Integer) responseJSON.get("status")).body(responseJSON);
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
