package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nilai {
    String idMahasiswa;
    String idMataKuliah;
    double nilaiAngka;
    char nilaiHuruf;

    public Nilai(String idMahasiswa, String idMataKuliah, double nilaiAngka){
        this.idMahasiswa = idMahasiswa;
        this.idMataKuliah = idMataKuliah;
        this.nilaiAngka = nilaiAngka;
    }
}
