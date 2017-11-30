package com.example.demo.DatabaseService;

import com.example.demo.Model.IRS;
import com.example.demo.Service.IRSService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRSServiceDatabase implements IRSService {
    @Override
    public IRS getIRS(String id_mahasiswa, String id_term) {
        return null;
    }

    @Override
    public List<IRS> getAllIRS(String id_mahasiswa) {
        return null;
    }

    @Override
    public void addIRS(IRS irs, List<String> id_kelas) {

    }

    @Override
    public void updateIRS(IRS irs, List<String> id_kelas) {

    }
}