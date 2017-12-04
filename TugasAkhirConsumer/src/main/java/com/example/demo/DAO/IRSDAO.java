package com.example.demo.DAO;

import com.example.demo.Model.IRS;
import org.apache.ibatis.annotations.*;

@Mapper
public interface IRSDAO {

    @Select("select * from irs where id_mahasiswa = #{id_mahasiswa} order by id desc limit 1")
    IRS selectIRS(String id_mahasiswa);

    @Insert("insert into irs (is_disetujui, id_term, id_mahasiswa) values (#{is_disetujui}, #{id_term}, #{id_mahasiswa})")
    void addIrs(IRS irs);

    @Insert("insert into irs_kelas values (#{id}, #{kelas})")
    void addIrsKelas(@Param("id") String id, @Param("kelas") String kelas);

    @Delete("delete from irs_kelas where id_irs = #{id_irs}")
    void deleteIrsKelas(String id_irs);
}