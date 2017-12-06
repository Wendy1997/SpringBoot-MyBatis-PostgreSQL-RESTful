package com.example.demo.RestService;

import com.example.demo.Model.Kelas;
import com.example.demo.Model.MataKuliah;
import com.example.demo.Service.KelasService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KelasServiceRest implements KelasService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Kelas> getAllKelas() {
        List<Kelas> kelasList = new ArrayList<>();
        try {
            Map<String, Object> result = restTemplate.getForObject("http://localhost:8090/api/kelas/get-all", Map.class);

            JSONObject jsonResult = new JSONObject(result);
            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {
                JSONArray jsonKelas = jsonResult.getJSONArray("result");

                for(int i = 0; i < jsonKelas.length(); i++){
                    kelasList.add( new Kelas(
                            jsonKelas.getJSONObject(i).getInt("id"),
                            jsonKelas.getJSONObject(i).getString("kode_mk"),
                            jsonKelas.getJSONObject(i).getString("nama_kelas"),
                            jsonKelas.getJSONObject(i).getInt("nomor_term"),
                            jsonKelas.getJSONObject(i).getInt("sks"),
                            jsonKelas.getJSONObject(i).getInt("periode_start"),
                            jsonKelas.getJSONObject(i).getInt("periode_end"),
                            jsonKelas.getJSONObject(i).getString("jadwal"),
                            jsonKelas.getJSONObject(i).getString("ruangan"),
                            jsonKelas.getJSONObject(i).getString("dosen"),
                            0,
                            "E"
                    ));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return kelasList;
    }

    @Override
    public Kelas getKelas(String id) {
        Kelas kelas = new Kelas();
        try {
            Map<String, Object> result = restTemplate.getForObject("http://localhost:8090/api/kelas/detail/"+id, Map.class);

            JSONObject jsonResult = new JSONObject(result);
            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {
                JSONObject jsonKelas = jsonResult.getJSONObject("result");

                kelas = new Kelas(
                        jsonKelas.getInt("id"),
                        jsonKelas.getString("kode_mk"),
                        jsonKelas.getString("ama_kelas"),
                        jsonKelas.getInt("nomor_term"),
                        jsonKelas.getInt("sks"),
                        jsonKelas.getInt("periode_start"),
                        jsonKelas.getInt("periode_end"),
                        jsonKelas.getString("jadwal"),
                        jsonKelas.getString("ruangan"),
                        jsonKelas.getString("dosen"),
                        0,
                        "E"
                );
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return kelas;
    }
}
