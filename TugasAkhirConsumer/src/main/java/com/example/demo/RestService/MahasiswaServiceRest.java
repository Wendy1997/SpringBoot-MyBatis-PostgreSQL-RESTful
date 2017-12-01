package com.example.demo.RestService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Mahasiswa;
import com.example.demo.Service.MahasiswaService;


@Service
public class MahasiswaServiceRest implements MahasiswaService {

	@Autowired
	private MahasiswaService mahasiswaDAO;
	
	@Override
	public List<Mahasiswa> selectAllMahasiswa() {
		// TODO Auto-generated method stub
		return mahasiswaDAO.selectAllMahasiswa();
	}

	@Override
	public void add(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		mahasiswaDAO.add(mahasiswa);
	}

	@Override
	public Mahasiswa dataView(String npm) {
		// TODO Auto-generated method stub
		return mahasiswaDAO.dataView(npm);
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

	
}
