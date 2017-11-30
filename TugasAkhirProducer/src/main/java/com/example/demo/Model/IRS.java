package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IRS {
    int id;
    boolean is_disetujui;
    String id_term;
    int id_mahasiswa;
    List<Kelas> kelasList;
}
