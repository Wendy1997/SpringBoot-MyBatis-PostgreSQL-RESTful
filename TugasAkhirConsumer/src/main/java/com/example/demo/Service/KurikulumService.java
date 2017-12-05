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
    Universitas getUniversitas(Integer id_univ);

    List<Fakultas> getFakultasList(Integer id_univ);
    Fakultas getFakultas(Integer id_univ, Integer id_fakultas);

    List<ProgramStudi> getProdiList(Integer id_univ, Integer id_fakultas);
    ProgramStudi getProdi(Integer id_univ, Integer id_fakultas, Integer id_prodi);
}
