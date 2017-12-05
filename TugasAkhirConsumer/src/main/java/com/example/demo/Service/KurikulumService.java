package com.example.demo.Service;

import com.example.demo.Model.Fakultas;
import com.example.demo.Model.Mahasiswa;
import com.example.demo.Model.ProgramStudi;
import com.example.demo.Model.Universitas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KurikulumService {

    List<Universitas> getUniversitasList();
    Universitas getUniversitas(String id_univ);

    List<Fakultas> getFakultasList(String id_univ);
    Fakultas getFakultas(String id_univ, String id_fakultas);

    List<ProgramStudi> getProdiList(String id_univ, String id_fakultas);
    ProgramStudi getProdi(String id_univ, String id_fakultas, String id_prodi);
}
