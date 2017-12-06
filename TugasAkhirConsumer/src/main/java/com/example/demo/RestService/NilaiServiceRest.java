package com.example.demo.RestService;

import com.example.demo.Model.MataKuliah;
import com.example.demo.Model.Nilai;
import com.example.demo.Service.NilaiService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NilaiServiceRest implements NilaiService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Nilai getNilai(String npm, String kode_mk) {
        Nilai nilai = new Nilai();
        try {
            Map<String, Object> result = restTemplate.getForObject("http://localhost:8090/api/getNilaiKuliah/" + npm + "/" + kode_mk, Map.class);

            JSONObject jsonResult = new JSONObject(result);
            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {
                JSONObject jsonNilai = jsonResult.getJSONObject("result").getJSONObject("nilai_mk");

                nilai = new Nilai(
                        jsonNilai.getString("npm"),
                        jsonNilai.getString("kode_mk"),
                        jsonNilai.getDouble("nilai")
                );

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return nilai;
    }
}
