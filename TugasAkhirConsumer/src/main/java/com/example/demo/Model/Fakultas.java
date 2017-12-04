package com.example.demo.Model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fakultas {
    Integer id_univ;
    Integer id_fakultas;
    String nama_fakultas;
    List<Fakultas> daftarUniv;
    List<Fakultas> daftarFakultas;
    List<Fakultas> daftarProdi;
}
