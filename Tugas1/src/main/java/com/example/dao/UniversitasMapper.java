package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.model.UniversitasModel;

@Mapper
public interface UniversitasMapper {
	@Select("select * from universitas")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="kode_univ", column="kode_univ"),
			@Result(property="nama_univ", column="nama_univ")
	})List<UniversitasModel> getAllUniv ();
}
