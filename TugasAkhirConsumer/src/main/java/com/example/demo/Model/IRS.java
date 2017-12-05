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
    int id_mahasiswa;
    boolean is_disetujui;
    String id_term;
    List<String> kelas_list;
}
