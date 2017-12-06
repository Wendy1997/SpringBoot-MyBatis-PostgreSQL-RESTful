package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kelas {
	int id;
    int idMataKuliah;
    String namaKelas;
    
    //Untuk Riwayat
    String kode_mk; //Kode Mata Kuliah <- Sekre
    int sks; //SKS <- Sekre
    int nilai; //Nilai Angka <- Penilaian
    
//  Dari API Sekretariat :
//  "id": 1,
//	"kode_mk": "CDK1234315",
//	"nama_kelas": "Matkul",
//	"nomor_term": 1,
//	"sks": 3,
//	"periode_start": 1510922066400,
//	"periode_end": 1510922066500,
//	"jadwal": "Senin, 14.00-15.40;Rabu, 09.00-09.50",
//	"ruangan": "2303",
//	"dosen": "Je S.Kom. M.Kom."
}
