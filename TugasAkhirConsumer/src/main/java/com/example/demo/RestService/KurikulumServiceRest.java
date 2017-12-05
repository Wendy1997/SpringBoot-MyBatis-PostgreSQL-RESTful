package com.example.demo.RestService;

import com.example.demo.Model.Fakultas;
import com.example.demo.Model.ProgramStudi;
import com.example.demo.Model.Universitas;
import com.example.demo.Service.KurikulumService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.ibatis.type.TypeReference;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class KurikulumServiceRest implements KurikulumService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Universitas> getUniversitasList() {

        List<Universitas> universitasList = new ArrayList<>();
        try {
            Map<String, Object> result = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getUniversitasList/", Map.class);

            JSONObject jsonResult = new JSONObject(result);
            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {
                JSONArray jsonProdi = jsonResult.getJSONObject("result").getJSONArray("univList");
                for(int i = 0; i < jsonProdi.length(); i++){
                    universitasList.add(new Universitas(Integer.parseInt(jsonProdi.getJSONObject(i).getString("id_univ")),
                            jsonProdi.getJSONObject(i).getString("nama_univ")));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return universitasList;
    }


    @Override

    public Universitas getUniversitas(String id_univ) {
        Universitas universitas = new Universitas();
        try {
            Map<String, Object> result = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getUniversitas/" + id_univ, Map.class);

            JSONObject jsonResult = new JSONObject(result);
            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {
                JSONObject jsonProdi = jsonResult.getJSONObject("result").getJSONObject("universitas");
                universitas = new Universitas(Integer.parseInt(jsonProdi.getString("id_univ")),
                            jsonProdi.getString("nama_univ")
                );

            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return universitas;
    }

    @Override
    public List<Fakultas> getFakultasList(String id_univ) {
        List<Fakultas> fakultasList = new ArrayList<>();
        try {
            Map<String, Object> result = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getFakultasList/" + id_univ, Map.class);

            JSONObject jsonResult = new JSONObject(result);
            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {
                JSONArray jsonProdi = jsonResult.getJSONObject("result").getJSONArray("fakultasList");
                for(int i = 0; i < jsonProdi.length(); i++){
                    fakultasList.add(new Fakultas(
                            Integer.parseInt(jsonProdi.getJSONObject(i).getString("id_univ")),
                            Integer.parseInt(jsonProdi.getJSONObject(i).getString("id_fakultas")),
                            jsonProdi.getJSONObject(i).getString("nama_fakultas")));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return fakultasList;
    }

    @Override
    public Fakultas getFakultas(String id_univ, String id_fakultas) {
        Fakultas fakultas = new Fakultas();
        try {
            Map<String, Object> result = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getFakultas/" + id_univ + "/" + id_fakultas, Map.class);

            JSONObject jsonResult = new JSONObject(result);
            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {
                JSONObject jsonProdi = jsonResult.getJSONObject("result").getJSONObject("fakultas");
                fakultas = new Fakultas(Integer.parseInt(jsonProdi.getString("id_univ")),
                        Integer.parseInt(jsonProdi.getString("id_fakultas")),
                        jsonProdi.getString("nama_fakultas")
                );

            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return fakultas;
    }

    @Override
    public List<ProgramStudi> getProdiList(String id_univ, String id_fakultas) {
        List<ProgramStudi> programStudiList = new ArrayList<>();
        try {
            Map<String, Object> result = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getProdiList/" + id_univ + "/" + id_fakultas, Map.class);

            JSONObject jsonResult = new JSONObject(result);
            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {
                JSONArray jsonProdi = jsonResult.getJSONObject("result").getJSONArray("prodiList");
                for(int i = 0; i < jsonProdi.length(); i++){
                    programStudiList.add(new ProgramStudi(
                            Integer.parseInt(jsonProdi.getJSONObject(i).getString("id_univ")),
                            Integer.parseInt(jsonProdi.getJSONObject(i).getString("id_fakultas")),
                            Integer.parseInt(jsonProdi.getJSONObject(i).getString("id_prodi")),
                            jsonProdi.getJSONObject(i).getString("nama_prodi")));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return programStudiList;
    }

    @Override
    public ProgramStudi getProdi(String id_univ, String id_fakultas, String id_prodi) {

        ProgramStudi programStudi = new ProgramStudi();
        try {
            Map<String, Object> result = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getProdi/" + id_univ + "/" + id_fakultas + "/" + id_prodi, Map.class);

            JSONObject jsonResult = new JSONObject(result);
            if(jsonResult.getInt("status") == HttpStatus.OK.value()) {
                JSONObject jsonProdi = jsonResult.getJSONObject("result").getJSONObject("prodi");
                programStudi = new ProgramStudi(Integer.parseInt(jsonProdi.getString("id_univ")),
                        Integer.parseInt(jsonProdi.getString("id_fakultas")),
                        Integer.parseInt(jsonProdi.getString("id_prodi")),
                        jsonProdi.getString("nama_prodi")
                );

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return programStudi;
    }
}
