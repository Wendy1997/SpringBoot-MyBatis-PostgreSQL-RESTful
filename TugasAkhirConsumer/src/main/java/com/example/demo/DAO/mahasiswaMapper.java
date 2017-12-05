package com.example.demo.DAO;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Model.Mahasiswa;

@Mapper
public interface mahasiswaMapper {

	@Insert("Insert into mahasiswa (nama, npm, is_dapat_lulus, ip, ipk, sks_total, id_univ, id_fakultas, id_program_studi) "
			+ "VALUES (#{nama}, #{npm}, 0, 0.00, 0.00, 0, #{id_univ}, #{id_fakultas}, #{id_program_studi})")
	void add(Mahasiswa mahasiswa);
	
	@Update("Update mahasiswa SET nama=#{nama}, npm=#{npm}, id_univ=#{id_univ}, id_fakultas=#{id_fakultas}, id_program_studi="
			+ "#{id_program_studi} where npm=#{npm}")
	void update(Mahasiswa mahasiswa);
	
}
