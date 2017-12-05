package com.example.demo.RestService;

import com.example.demo.DAO.IRSDAO;
import com.example.demo.Model.IRS;
import com.example.demo.Model.Kelas;
import com.example.demo.Model.ProgramStudi;
import com.example.demo.Service.IRSService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class IRSServiceRest implements IRSService {

	@Autowired
    private RestTemplate restTemplate;

	@Autowired
    private IRSDAO irsdao;

    @Override
    public IRS getIRS(String id_mahasiswa) {
        IRS irs = new IRS();
        Map<String, Object> result = restTemplate.getForObject("http://localhost:8080/api/irs/view/" + id_mahasiswa, Map.class);
        try {
            JSONObject jsonResult = new JSONObject(result);
            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {
                JSONObject jsonProdi = jsonResult.getJSONObject("result");

                JSONArray jsonKelas = jsonProdi.getJSONArray("kelas_list");
                List<String> kelasList= new ArrayList<>();
                System.out.println(jsonKelas.get(1).toString());
                for(int j = 0; j < jsonKelas.length(); j++){
                    kelasList.add((String)jsonKelas.get(j));
                }

                irs = new IRS(
                        jsonProdi.getInt("id"),
                        jsonProdi.getInt("id_mahasiswa"),
                        jsonProdi.getBoolean("_disetujui"),
                        jsonProdi.getString("id_term"),
                        kelasList);

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return irs;
    }

    @Override
    public List<IRS> getAllIRS(String id_mahasiswa) {
        List<IRS> irsList = new ArrayList<>();
        try {
            Map<String, Object> result = restTemplate.getForObject("http://localhost:8080/api/irs/viewall/" + id_mahasiswa, Map.class);

            JSONObject jsonResult = new JSONObject(result);
            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {
                JSONArray jsonProdi = jsonResult.getJSONArray("result");
                for(int i = 0; i < jsonProdi.length(); i++){

                    JSONArray jsonKelas = jsonProdi.getJSONObject(i).getJSONArray("kelas_list");
                    List<String> kelasList= new ArrayList<>();

                    for(int j = 0; j < jsonKelas.length(); j++){
                        kelasList.add((String)jsonKelas.get(j));
                    }

                    irsList.add(new IRS(
                            jsonProdi.getJSONObject(i).getInt("id"),
                            jsonProdi.getJSONObject(i).getInt("id_mahasiswa"),
                            jsonProdi.getJSONObject(i).getBoolean("_disetujui"),
                            jsonProdi.getJSONObject(i).getString("id_term"),
                            kelasList));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return irsList;
    }

    @Override
    public void addIRS(IRS irs) {
        irsdao.addIrs(irs);

        String id_irs = irsdao.selectIRS(irs.getId_mahasiswa() + "").getId() + "";

        for(int i = 0 ; i < irs.getKelas_list().size(); i++){
            irsdao.addIrsKelas(id_irs, irs.getKelas_list().get(i));
        }
    }

    @Override
    public void updateIRS(IRS irs) {
        String id_irs = irsdao.selectIRS(irs.getId_mahasiswa() + "").getId() + "";
        System.out.println(id_irs);
        irsdao.deleteIrsKelas(id_irs);

        for(int i = 0 ; i < irs.getKelas_list().size(); i++){
            System.out.println(id_irs + " " + irs.getKelas_list().get(i));
            irsdao.addIrsKelas(id_irs, irs.getKelas_list().get(i));
        }
    }
}
