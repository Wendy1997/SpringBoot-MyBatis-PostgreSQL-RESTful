package com.example.demo.RestService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.DAO.IRSDAO;
import com.example.demo.Model.IRS;
import com.example.demo.Model.MataKuliah;
import com.example.demo.Service.MataKuliahService;

public class MataKuliahServiceRest implements MataKuliahService {
	
	@Autowired
    private RestTemplate restTemplate;

	@Autowired
    private IRSDAO irsdao;

    @Override
    public MataKuliah getMatkul(String id) {
        MataKuliah matkul = restTemplate.getForObject("http://localhost:8080/api/getMataKuliahById/view/" + id, MataKuliah.class);
        return matkul;
    }

}
