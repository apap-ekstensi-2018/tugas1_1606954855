package com.example.dao;

//import java.util.Date;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.ProgramStudiModel;
import com.example.model.MahasiswaModel;
import com.example.model.FakultasModel;
import com.example.model.UniversitasModel;


public interface MahasiswaMapper {
	@Select("select * from mahasiswa where npm = #{npm}")
	@Results(value = {
			@Result(property="npm", column="npm"),
			@Result(property="nama", column="nama"),
			@Result(property="tempat_lahir", column="tempat_lahir"),
			@Result(property="tanggal_lahir", column="tanggal_lahir"),
			@Result(property="jenis_kelamin", column="jenis_kelamin"),
			@Result(property="agama", column="agama"),
			@Result(property="golongan_darah", column="golongan_darah"),
			@Result(property="tahun_masuk", column="tahun_masuk"),
			@Result(property="jalur_masuk", column="jalur_masuk"),
			@Result(property="status", column="status"),
			@Result(property="id_prodi", column="id_prodi"),
			@Result(property="univ", column="id_prodi",
				javaType = UniversitasModel.class,
				many=@Many(select="searchUniv")),
			@Result(property="fakultas", column="id_prodi",
			javaType = FakultasModel.class,
			many=@Many(select="searchFakultas")),
			@Result(property="prodi", column="id_prodi",
				javaType = ProgramStudiModel.class,
				many=@Many(select="searchProdi"))
	})MahasiswaModel searchMahasiswa (@Param("npm") String npm);
}
