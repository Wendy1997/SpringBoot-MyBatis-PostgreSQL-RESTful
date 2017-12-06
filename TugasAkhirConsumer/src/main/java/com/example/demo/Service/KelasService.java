package com.example.demo.Service;

import com.example.demo.Model.Kelas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KelasService {
    List<Kelas> getAllKelas();
    Kelas getKelas(String id);
}
