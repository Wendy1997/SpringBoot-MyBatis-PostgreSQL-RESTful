package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgramStudi {
    int id_univ;
    int id_fakultas;
    int id_prodi;
    String nama_prodi;
}
