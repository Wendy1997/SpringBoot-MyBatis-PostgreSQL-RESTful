package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kelas {
    int id;
    String kode_mk;
    String nama_kelas;
    int nomor_term;
    int sks;
    int periode_start;
    int periode_end;
    String jadwal;
    String ruangan;
    String dosen;
    
    //Penilaian
    double nilaiAngka;
    String nilaiHuruf;
    
    public Kelas(int id) {
    	this.id = id;
    }

}
