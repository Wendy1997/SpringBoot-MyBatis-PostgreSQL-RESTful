package com.example.demo.Service;

import com.example.demo.Model.Kurikulum;
import com.example.demo.Model.MataKuliah;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MataKuliahService {
    MataKuliah getMatkul(String id_matkul);
    List<MataKuliah> getListMatkul(String id_univ, String id_fakultas, String id_prodi);

    Kurikulum getKurikulum(String id, String id_univ, String id_fakultas, String id_prodi);
    List<Kurikulum> getAllKurikulum(String id_univ, String id_fakultas, String id_prodi);
}
