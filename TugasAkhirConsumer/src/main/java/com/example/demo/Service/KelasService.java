package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Kelas;

@Service
public interface KelasService {
	Kelas getKelas(String id);
}
