package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nilai {
    int idMahasiswa;
    int idMataKuliah;
    char nilaiHuruf;
    double nilaiAngka;
}
