package com.example.demo.RestService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Model.Fakultas;
import com.example.demo.Model.Universitas;
import com.example.demo.Service.FakultasService;
public class FakultasServiceRest implements FakultasService {
	
	@Autowired
	private FakultasService fakultas;

	@Override
	public Map<String, Object> namaUniv(Integer id_univ) {
		// TODO Auto-generated method stub
		return fakultas.namaUniv(id_univ);
	}

	@Override
	public Map<String, Object> namaFakultas(Integer id_univ, Integer id_fakultas) {
		// TODO Auto-generated method stub
		return fakultas.namaFakultas(id_univ, id_fakultas);
	}

	@Override
	public Map<String, Object> namaProdi(Integer id_univ, Integer id_fakultas, Integer id_prodi) {
		// TODO Auto-generated method stub
		return fakultas.namaProdi(id_univ, id_fakultas, id_prodi);
	}

	@Override
	public Map<String, Object> listUniv() {
		// TODO Auto-generated method stub
		return fakultas.listUniv();
	}

	@Override
	public List<Fakultas> listFakultas(Integer id_univ) {
		// TODO Auto-generated method stub
		return fakultas.listFakultas(id_univ);
	}

	@Override
	public List<Fakultas> listProdi(Integer id_univ, Integer id_fakultas) {
		// TODO Auto-generated method stub
		return fakultas.listProdi(id_univ, id_fakultas);
	}

	
	
	
}
