package com.example.demo.DatabaseService;

import com.example.demo.DAO.MahasiswaDAO;
import com.example.demo.Model.Mahasiswa;
import com.example.demo.Service.MahasiswaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MahasiswaServiceDatabase implements MahasiswaService {

	@Autowired
	MahasiswaDAO mahasiswaDao;
	
	@Override
	public List<Mahasiswa> selectAllMahasiswa() {
		return mahasiswaDao.mahasiswa();
	}

	@Override
	public void addMahasiswa(Mahasiswa mahasiswa) {
		mahasiswaDao.add(mahasiswa);
	}

	@Override
	public void updateMahasiswa(Mahasiswa mahasiswa) {
		mahasiswaDao.update(mahasiswa);
	}

	@Override
	public void deleteMahasiswa(Mahasiswa mahasiswa) {
		mahasiswaDao.delete(mahasiswa);
	}

	@Override
	public Mahasiswa lulus(String lulus) {
		return mahasiswaDao.lulus(lulus);
	}

	@Override
	public Mahasiswa dataView(String npm) {
		return mahasiswaDao.dataView(npm);
	}
	
	@Override
	public Mahasiswa view(int id) {
		return mahasiswaDao.view(id);
	}
}
