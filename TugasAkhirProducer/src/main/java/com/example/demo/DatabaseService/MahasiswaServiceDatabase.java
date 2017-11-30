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
		// TODO Auto-generated method stub
		return mahasiswaDao.mahasiswa();
	}

	@Override
	public void addMahasiswa(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		mahasiswaDao.add(mahasiswa);
	}

	@Override
	public void updateMahasiswa(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		mahasiswaDao.update(mahasiswa);
	}

	@Override
	public void deleteMahasiswa(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		mahasiswaDao.delete(mahasiswa);
	}

	@Override
	public Mahasiswa lulus(String lulus) {
		// TODO Auto-generated method stub
		return mahasiswaDao.lulus(lulus);
	}

	@Override
	public Mahasiswa dataView(String npm) {
		// TODO Auto-generated method stub
		return mahasiswaDao.dataView(npm);
	}
}
