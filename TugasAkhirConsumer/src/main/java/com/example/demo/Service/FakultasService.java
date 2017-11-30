package com.example.demo.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Fakultas;
import com.example.demo.Model.Universitas;

@Service
public interface FakultasService {
	
	Map<String, Object> namaUniv (Integer id_univ);
	Map<String, Object> namaFakultas (Integer id_univ, Integer id_fakultas);
	Map<String, Object> namaProdi (Integer id_univ, Integer id_fakultas, Integer id_prodi);
	
	String listUniv ();
	List<Fakultas> listFakultas (Integer id_univ);
	List<Fakultas> listProdi (Integer id_univ, Integer id_fakultas);
	
	
}
