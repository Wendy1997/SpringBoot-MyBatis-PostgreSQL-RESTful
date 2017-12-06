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
    List<Kelas> kelas_list;
    
    Term term;
    
    public IRS (int id, int id_mahasiswa, boolean is_disetujui, String id_term, List<Kelas> kelas_list) {
    	this.id = id;
    	this.id_mahasiswa = id_mahasiswa;
    	this.is_disetujui = is_disetujui;
    	this.id_term = id_term;
    	this.kelas_list = kelas_list;
    }
}
