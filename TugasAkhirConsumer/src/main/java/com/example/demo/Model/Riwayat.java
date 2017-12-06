package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Riwayat {
    int id;
    int idMataKuliah;
    String namaKelas;
    
    //Untuk Riwayat
    String kode_mk; //Kode Mata Kuliah <- Sekre
    int sks; //SKS <- Sekre
    int nilai; //Nilai Angka <- Penilaian
    
}
