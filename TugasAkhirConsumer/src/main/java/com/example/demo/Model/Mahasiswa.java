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
    String namaMahasiswa;
    long npm;
    int idProdi;
    double ip;
    double ipk;
    boolean isDapaLulus;
    boolean status;
    List<IRS> irsList;
    List<Nilai> nilaiList;
}
