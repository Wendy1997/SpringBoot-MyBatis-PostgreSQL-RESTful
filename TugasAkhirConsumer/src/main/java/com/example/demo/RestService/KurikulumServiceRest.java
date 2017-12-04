package com.example.demo.RestService;

import com.example.demo.Model.Fakultas;
import com.example.demo.Model.ProgramStudi;
import com.example.demo.Model.Universitas;
import com.example.demo.Service.KurikulumService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.ibatis.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
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
        Gson gson = new Gson();
        Map<String, Object> json = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getUniversitasList/", Map.class);
        Map<String, Object> map = gson.fromJson(json.get("result").toString().replace(" ", ""), new TypeToken<Map<String, Object>>(){}.getType());
        List<Universitas> universitasList = gson.fromJson(map.get("univList").toString(), new TypeToken<ArrayList<Universitas>>(){}.getType());
        return universitasList;
    }


    @Override
    public Universitas getUniversitas(String id_univ) {
        Gson gson = new Gson();
        Map<String, Object> json = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getUniversitas/" + id_univ, Map.class);
        Map<String, Object> map = gson.fromJson(json.get("result").toString().replace(" ", ""), new TypeToken<Map<String, Object>>(){}.getType());
        Universitas universitas = gson.fromJson(map.get("universitas").toString(), Universitas.class);
        return universitas;
    }

    @Override
    public List<Fakultas> getFakultasList(String id_univ) {
        Gson gson = new Gson();
        Map<String, Object> json = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getFakultasList/" + id_univ, Map.class);
        Map<String, Object> map = gson.fromJson(json.get("result").toString().replace(" ", ""), new TypeToken<Map<String, Object>>(){}.getType());
        List<Fakultas> fakultasList = gson.fromJson(map.get("fakultasList").toString(), new TypeToken<ArrayList<Fakultas>>(){}.getType());
        return fakultasList;
    }

    @Override
    public Fakultas getFakultas(String id_univ, String id_fakultas) {
        Gson gson = new Gson();
        Map<String, Object> json = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getFakultas/" + id_univ + "/" + id_fakultas, Map.class);
        Map<String, Object> map = gson.fromJson(json.get("result").toString().replace(" ", ""), new TypeToken<Map<String, Object>>(){}.getType());
        Fakultas fakultas = gson.fromJson(map.get("fakultas").toString(), Fakultas.class);
        return fakultas;
    }

    @Override
    public List<ProgramStudi> getProdiList(String id_univ, String id_fakultas) {
        Gson gson = new Gson();
        Map<String, Object> json = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getProdiList/" + id_univ + "/" + id_fakultas, Map.class);
        Map<String, Object> map = gson.fromJson(json.get("result").toString().replace(" ", ""), new TypeToken<Map<String, Object>>(){}.getType());
        List<ProgramStudi> prodiList = gson.fromJson(map.get("prodiList").toString(), new TypeToken<ArrayList<ProgramStudi>>(){}.getType());
        return prodiList;
    }

    @Override
    public ProgramStudi getProdi(String id_univ, String id_fakultas, String id_prodi) {
        Gson gson = new Gson();
        Map<String, Object> json = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getProdi/" + id_univ + "/" + id_fakultas + "/" + id_prodi, Map.class);
        Map<String, Object> map = gson.fromJson(json.get("result").toString().replace(" ", ""), new TypeToken<Map<String, Object>>(){}.getType());
        ProgramStudi prodi = gson.fromJson(map.get("prodi").toString(), ProgramStudi.class);
        return prodi;
    }
}
