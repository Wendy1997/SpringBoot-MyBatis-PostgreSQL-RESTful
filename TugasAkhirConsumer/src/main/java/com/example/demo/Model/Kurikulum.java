package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kurikulum {
    int id;
    String nama_kurikulum;
    int jumlahSksWajib;
    int jumlahSksPilihan;
    String kodeUniv;
    String kodeFakultas;
    String kodeProdi;
    String tahunMulai;
    String tahunAkhir;
    List<MataKuliah> listMatkulWajib;
    List<MataKuliah> listMatkulPilihan;
}