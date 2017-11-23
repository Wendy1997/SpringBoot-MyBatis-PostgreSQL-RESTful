package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MataKuliah {
    int id;
    int idProdi;
    String namaMatkul;
    int sks;
    String namaDosen;
}
