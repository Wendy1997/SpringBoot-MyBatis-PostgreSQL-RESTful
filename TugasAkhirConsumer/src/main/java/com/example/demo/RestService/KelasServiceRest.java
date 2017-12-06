package com.example.demo.RestService;

import com.example.demo.DAO.IRSDAO;
import com.example.demo.Model.IRS;
import com.example.demo.Model.Kelas;
import com.example.demo.Service.IRSService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Service.KelasService;

public class KelasServiceRest implements KelasService {
	
	@Autowired
    private RestTemplate restTemplate;

	@Autowired
    private IRSDAO irsdao;

	@Override
	public Kelas getKelas(String id) {
		// TODO Auto-generated method stub
		Kelas kelas = restTemplate.getForObject("http://localhost:8080/api/kelas/detail/" + id, Kelas.class);
        return kelas;
	}
	
}
