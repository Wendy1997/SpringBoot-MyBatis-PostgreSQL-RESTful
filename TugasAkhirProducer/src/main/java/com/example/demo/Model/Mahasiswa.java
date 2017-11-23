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
    long npm;
    boolean is_dapat_lulus;
    double ip;
    double ipk;
    int id_program_studi;
    List<IRS> irsList;
}
