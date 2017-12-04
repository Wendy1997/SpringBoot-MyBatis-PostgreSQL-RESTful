package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Model.MataKuliah;

@Service
public interface MataKuliahService {

	MataKuliah getMatkul(String id);
}
