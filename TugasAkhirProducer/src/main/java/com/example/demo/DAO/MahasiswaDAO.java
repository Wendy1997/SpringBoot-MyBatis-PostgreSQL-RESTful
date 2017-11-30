package com.example.demo.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Model.Mahasiswa;

@Mapper
public interface MahasiswaDAO {
	
	@Insert("Insert into mahasiswa (nama, npm, is_dapat_lulus, ip, ipk, id_program_studi) VALUES"
			+ "(#{nama}, #{npm}, 0, 0, 0, #{id_program_studi})")
	void add(Mahasiswa mahasiswa);
	
	@Delete("Delete from mahasiswa where id = #{id}")
	void delete(Mahasiswa mahasiswa);
	
	@Update("Update mahasiswa set nama=#{nama}, npm=#{npm}, is_dapat_lulus=#{is_dapat_lulus}, "
			+ "ip=#{ip}, ipk=#{ipk}, id_program_studi=#{id_program_studi}")
	void update(Mahasiswa mahasiswa);
	
	@Select("Select * from mahasiswa where npm = #{npm}")
	Mahasiswa dataView (@Param("npm") String npm);
	
	@Update("Update mahasiswa set is_dapat_lulus = 1 where id = #{id} ")
	Mahasiswa lulus(@Param("lulus") String lulus);
	
	@Select("Select * from mahasiswa")
	List<Mahasiswa> mahasiswa();
	
	@Select("Select * from fakultas")
	List<Mahasiswa> fakultas();
	
	@Select("Select nama from program_studi where id_fakultas = #{id}")
	List<Mahasiswa> program_studi(@Param("id") Integer id);
}
