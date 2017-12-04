package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kelas {
    int id;
    int idMataKuliah;
    String namaKelas;
    
    //Untuk Riwayat
    String kodeMatkul;
    int sks;
}
