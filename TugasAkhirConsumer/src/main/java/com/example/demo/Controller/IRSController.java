package com.example.demo.Controller;

import com.example.demo.Model.IRS;
import com.example.demo.Service.IRSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IRSController {

    @Autowired
    IRSService irsService;

    @GetMapping("/irs/view/{id}")
    public String irsView(@PathVariable(value="id") String id){
        return "lihat-irs";
    }

    @GetMapping("/irs/add")
    public String irsAdd(Model model){

        model.addAttribute("id_mahasiswa", "1");
        model.addAttribute("id_term", "6");
        return "isi-irs";
    }

    @PostMapping("/irs/add")
    public void irsAddSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println(request.getParameter("irs_list"));
        IRS irs = new IRS();
        irs.set_disetujui(false);
        irs.setId_mahasiswa(Integer.parseInt(request.getParameter("id_mahasiswa")));
        irs.setId_term(request.getParameter("id_term"));

        String[] irs_list = request.getParameter("irs_list").split(",");
        List<String> kelas_list = new ArrayList<>();
        for(String kelas : irs_list){
            kelas_list.add(kelas);
        }

        irs.setKelas_list(kelas_list);

        irsService.addIRS(irs);

        response.getWriter().println(irsService.getIRS(irs.getId_mahasiswa() + "").getId());
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
