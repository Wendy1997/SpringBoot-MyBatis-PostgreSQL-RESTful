package com.example.demo.DAO;

import com.example.demo.Model.IRS;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface IRSDAO {
    @Select("select * from irs where id_mahasiswa = #{id_mahasiswa} and id_term = #{id_term}")
    IRS selectIRS(String id_mahasiswa, String id_term);

    @Select("select id_kelas from irs, irs_kelas where irs.id = irs_kelas.id_irs and irs.id_mahasiswa = #{id_mahasiswa} and irs.id_term = #{id_term}")
    List<String> selectKelas(String id_mahasiswa, String id_term);
}
