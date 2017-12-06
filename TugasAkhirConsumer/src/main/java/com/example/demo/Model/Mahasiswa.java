package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mahasiswa {
    int id;
    String nama;
    String npm;
    Integer sks_total;
    Integer id_fakultas;
    Integer id_program_studi;
    Integer id_univ;
    Double ip;
    Double ipk;
    Boolean is_dapat_lulus;
    boolean status;
    String nama_fakultas;
    String nama_prodi;
    String nama_univ;
    List<Fakultas> listUniv;
    List<Fakultas> listFakultas;
    List<Fakultas> listProdi;
    List<IRS> irsList;
    List<Nilai> nilaiList;
}
