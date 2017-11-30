package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Mahasiswa;

@Service
public interface MahasiswaService {
	
	List<Mahasiswa> selectAllMahasiswa ();
	void addMahasiswa (Mahasiswa mahasiswa);
	Mahasiswa dataView(String npm);
	void updateMahasiswa (Mahasiswa mahasiswa);
	void deleteMahasiswa (Mahasiswa mahasiswa);
	Mahasiswa lulus(String lulus);
	
}
