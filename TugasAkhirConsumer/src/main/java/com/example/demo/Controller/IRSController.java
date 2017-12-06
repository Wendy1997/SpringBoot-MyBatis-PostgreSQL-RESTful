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

    @GetMapping("/irs/add/submit")
    public void irsAddSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException{
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

        response.getWriter().println(request.getParameter("id_mahasiswa"));
    }

    @GetMapping("/irs/update/{id}")
    public String irsUpdate(@PathVariable(value="id") String id, Model model){
        IRS irs = irsService.getIRS(id);
        String kelas = "";
        if(irs.getKelas_list().size() > 0){
            for(int i = 0 ; i < irs.getKelas_list().size(); i++){
                if(i < irs.getKelas_list().size() - 1){
                    kelas += irs.getKelas_list().get(i) + ",";
                } else{
                    kelas += irs.getKelas_list().get(i);
                }
            }
        }

        model.addAttribute("irs", irs);
        model.addAttribute("kelas", kelas);
        return "ubah-irs";
    }

    @GetMapping("/irs/update/submit")
    public void irsUpdateSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException{
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

        irsService.updateIRS(irs);

        response.getWriter().println(request.getParameter("id_mahasiswa"));
    }
}
