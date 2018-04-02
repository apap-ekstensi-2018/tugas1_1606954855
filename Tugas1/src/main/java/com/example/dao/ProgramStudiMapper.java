package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.model.MahasiswaModel;
import com.example.model.ProgramStudiModel;
import com.example.model.UniversitasModel;

@Mapper
public interface ProgramStudiMapper {
	@Select("select * from program_studi where id_prodi = #{id_prodi}")
	@Results(value = {
			@Result(property="kode_univ", column="kode_univ"),
			@Result(property="kode_prodi", column="kode_prodi"),
			@Result(property="nama_prodi", column="nama_prodi"),
			@Result(property="univ", column="kode_univ",
				javaType = UniversitasModel.class,
				many=@Many(select="searchUniv")),
			@Result(property="peserta", column="kode_prodi",
				javaType = List.class,
				many=@Many(select="selectProdiByPeserta"))
	})ProgramStudiModel searchProdi (@Param("id_prodi") String kode_prodi);
	
	@Select("select * from universitas where kode_univ = #{kode_univ}")
	UniversitasModel searchUniv (@Param("kode_univ") String kode_univ);
	
	@Select("select * from mahasiswa where kode_prodi = #{kode_prodi}")
    List<MahasiswaModel> selectProdiByMahasiswa (@Param("kode_prodi") String kode_prodi);
}
