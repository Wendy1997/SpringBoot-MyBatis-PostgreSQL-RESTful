package com.example.demo.Service;

import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public interface FakultasService {
	
	Map<String, Object> namaUniv (Integer id_univ);
	Map<String, Object> namaFakultas (Integer id_univ, Integer id_fakultas);
	Map<String, Object> namaProdi (Integer id_univ, Integer id_fakultas, Integer id_prodi);
	
}
