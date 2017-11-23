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
    int idMahasiswa;
    boolean isDisetujui;
    String term;
    List<Kelas> kelasList;
}
