package com.example.demo.Service;

import com.example.demo.Model.IRS;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRSService {
    IRS getIRS(String id_mahasiswa);
    List<IRS> getAllIRS(String id_mahasiswa);
    void addIRS(IRS irs);
    void updateIRS(IRS irs, List<String> id_kelas);
}
