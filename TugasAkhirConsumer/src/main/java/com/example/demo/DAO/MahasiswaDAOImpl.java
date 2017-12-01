package com.example.demo.DAO;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.Fakultas;
import com.example.demo.Model.Mahasiswa;
import com.example.demo.Model.Universitas;
import com.example.demo.Service.FakultasService;
import com.example.demo.Service.MahasiswaService;

@Service
@Primary
public class MahasiswaDAOImpl implements MahasiswaService, FakultasService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	mahasiswaMapper mahasiswamapper;
	
	@Override
	public List<Mahasiswa> selectAllMahasiswa() {
		// TODO Auto-generated method stub
		ResponseEntity<Mahasiswa[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/mahasiswa/viewall", Mahasiswa[].class);
		return Arrays.asList(responseEntity.getBody());
	}

	@Override
	public void add(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		mahasiswamapper.add(mahasiswa);
		
	}

	@Override
	public Mahasiswa dataView(String npm) {
		// TODO Auto-generated method stub
		Mahasiswa mahasiswa = restTemplate.getForObject("http://localhost:8080/api/mahasiswa/view/" + npm, Mahasiswa.class);
		return mahasiswa;
	}
	
	

	@Override
	public void updateMahasiswa(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMahasiswa(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Mahasiswa lulus(String lulus) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Map<String, Object> namaUniv(Integer id_univ) {
		// TODO Auto-generated method stub
		Map<String, Object> universitas = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getUniversitas/" + id_univ, Map.class);
		return universitas;
	}
	
	@Override
	public Map<String, Object> namaFakultas(Integer id_univ, Integer id_fakultas) {
		// TODO Auto-generated method stub
		Map<String, Object> fakultas = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getFakultas/" + id_univ + "/" + id_fakultas, Map.class);
		return fakultas;
	}

	@Override
	public Map<String, Object> namaProdi(Integer id_univ, Integer id_fakultas, Integer id_prodi) {
		// TODO Auto-generated method stub
		Map<String, Object> prodi = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getProdi/" + id_univ + "/" + id_fakultas + "/" + id_prodi, Map.class);
		return prodi;
	}

	@Override
	public String listUniv() {
		// TODO Auto-generated method stub
		
//		ResponseEntity<List<Universitas>> responseEntity = restTemplate.exchange("https://apap2017-univ-apps.herokuapp.com/getUniversitasList", HttpMethod.GET, null, new ParameterizedTypeReference<List<Universitas>>() {
//		});
		//System.out.println("nana = " +responseEntity.toString());
		Map<String, Object> universitas = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getUniversitasList", Map.class);
		Map<String, Object> nama = (Map<String, Object>) universitas.get("result");
		String[] hasil = nama.get("univList").toString().split("[{}]");
		String [] listUniv = new String[] {hasil[1], hasil[3], hasil[5]};
 		System.out.println(listUniv.toString());
		return nama.get("univList").toString();
	}

	@Override
	public List<Fakultas> listFakultas(Integer id_univ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fakultas> listProdi(Integer id_univ, Integer id_fakultas) {
		// TODO Auto-generated method stub
		return null;
	}

}
