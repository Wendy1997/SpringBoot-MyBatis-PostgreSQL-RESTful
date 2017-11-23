package com.example.demo.DAO;

import com.example.demo.Model.IRS;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface IRSDAO {
    @Select("select * from irs where id_mahasiswa = #{id_mahasiswa} order by id desc limit 1")
    IRS selectIRS(String id_mahasiswa);

    @Select("select * from irs where id_mahasiswa = #{id_mahasiswa}")
    List<IRS> selectAllIRS(String id_mahasiswa);

    @Select("select id_kelas from irs, irs_kelas where irs.id = irs_kelas.id_irs and irs.id = #{id_irs}")
    List<String> selectKelas(String id_irs);
}
