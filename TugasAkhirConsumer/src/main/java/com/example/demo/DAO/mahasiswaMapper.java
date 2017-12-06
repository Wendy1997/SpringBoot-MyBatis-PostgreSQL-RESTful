package com.example.demo.DAO;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
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
	
	@Select("select id_mahasiswa from users where username = #{username}")
	String getId(String username);
	
	@Insert("Insert into users (username, password, enabled, id_mahasiswa) "
			+ "VALUES (#{username}, 'password', 1, #{id_mahasiswa})")
	@Results(value = {
			@Result(property="username", column="username"),
			@Result(property="id_mahasiswa", column="id_mahasiswa")})
	void addUser(@Param("username") String username, @Param("id_mahasiswa") int id_mahasiswa);
	
	@Insert("Insert into user_roles (user_role_id, username, role) "
			+ "VALUES (#{user_role_id}, #{username}, 'ROLE_USER')")
	@Results(value = {
			@Result(property="username", column="username"),
			@Result(property="user_role_id", column="user_role_id")})
	void addUserRole(@Param("user_role_id")int user_role_id, @Param("username") String username);
}
