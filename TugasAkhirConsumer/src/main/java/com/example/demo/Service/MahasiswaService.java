package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Mahasiswa;

@Service
public interface MahasiswaService {
	List<Mahasiswa> selectAllMahasiswa();

	void add(Mahasiswa mahasiswa);

	Mahasiswa dataView(String npm);

	void update(Mahasiswa mahasiswa);

	Mahasiswa lulus(String lulus);
	
	Mahasiswa view(int id);
	
	int getId(String username);

	void addUserRole(int user_role_id, String username);

	void addUser(String username, int id_mahasiswa);

}
