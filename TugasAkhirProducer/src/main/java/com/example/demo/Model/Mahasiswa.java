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
    int sks_total;
    Integer id_fakultas;
    Integer id_univ;
    Boolean is_dapat_lulus;
    double ip;
    double ipk;
    int id_program_studi;
    List<IRS> irsList;
}
