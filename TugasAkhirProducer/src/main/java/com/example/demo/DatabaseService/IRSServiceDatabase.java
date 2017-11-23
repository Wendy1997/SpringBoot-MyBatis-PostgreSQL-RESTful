package com.example.demo.DatabaseService;

import com.example.demo.DAO.IRSDAO;
import com.example.demo.Model.IRS;
import com.example.demo.Service.IRSService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRSServiceDatabase implements IRSService {

    @Autowired
    IRSDAO irsdao;

    @Override
    public IRS getIRS(String id_mahasiswa) {
        IRS irs = irsdao.selectIRS(id_mahasiswa);
        irs.setKelasList(irsdao.selectKelas(irs.getId() + ""));

        return irs;
    }

    @Override
    public List<IRS> getAllIRS(String id_mahasiswa) {
        List<IRS> irsList = irsdao.selectAllIRS(id_mahasiswa);

        for(int i = 0 ; i < irsList.size(); i++){
            irsList.get(i).setKelasList(irsdao.selectKelas(irsList.get(i).getId() + ""));
        }

        return irsList;
    }

    @Override
    public void addIRS(IRS irs, List<String> id_kelas) {
        irsdao.addIrs(irs);

        String id_irs = irsdao.selectIRS(irs.getId_mahasiswa() + "").getId() + "";

        for(int i = 0 ; i < id_kelas.size(); i++){
            irsdao.addIrsKelas(id_irs, id_kelas.get(i));
        }

    }

    @Override
    public void updateIRS(IRS irs, List<String> id_kelas) {
        irsdao.deleteIrsKelas(irs.getId() + "");

        String id_irs = irsdao.selectIRS(irs.getId_mahasiswa() + "").getId() + "";

        for(int i = 0 ; i < id_kelas.size(); i++){
            irsdao.addIrsKelas(id_irs, id_kelas.get(i));
        }
    }
}