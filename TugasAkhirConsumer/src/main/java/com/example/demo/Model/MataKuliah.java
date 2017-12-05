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
}
