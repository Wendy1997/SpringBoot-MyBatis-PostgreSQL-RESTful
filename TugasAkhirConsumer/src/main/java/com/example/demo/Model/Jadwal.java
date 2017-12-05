package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jadwal {
    int id;
    int idKelas;
    String hari;
    String jamMulai;
    String jamSelesai;
    String ruangan;
}
