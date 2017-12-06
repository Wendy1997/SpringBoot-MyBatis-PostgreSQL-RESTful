package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MataKuliah {
    int id;
    String namaMatkul;
    String kodeMatkul;
    int jumlahSks;
    String deskripsi;
    int prasyaratSks;
    List<MataKuliah> mataKuliahs;
    List<Kelas> kelas_list;
    
    public MataKuliah(int id, String namaMatkul, String kodeMatkul, int jumlahSks, String deskripsi,int prasyaratSks, List<MataKuliah> mataKuliahs) {
    	this.id = id;
    	this.namaMatkul = namaMatkul;
    	this.kodeMatkul = kodeMatkul;
    	this.jumlahSks = jumlahSks;
    	this.deskripsi = deskripsi;
    	this.prasyaratSks = prasyaratSks;
    	this.mataKuliahs = mataKuliahs;
    }
}
