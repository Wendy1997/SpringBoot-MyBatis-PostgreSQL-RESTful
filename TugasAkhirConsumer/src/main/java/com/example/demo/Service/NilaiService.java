package com.example.demo.Service;

import com.example.demo.Model.Nilai;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NilaiService {

    Nilai getNilai(String npm, String kode_mk);
}
