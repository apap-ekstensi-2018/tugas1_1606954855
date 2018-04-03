package com.example.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.example.model.FakultasModel;
import com.example.model.MahasiswaModel;
import com.example.model.ProgramStudiModel;
import com.example.model.UniversitasModel;

@Mapper
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
			@Result(property="univ", column="kode_univ",
				javaType = UniversitasModel.class,
				many=@Many(select="searchUniv")),
			@Result(property="fakultas", column="id_fakultas",
				javaType = FakultasModel.class,
				many=@Many(select="searchFakultas")),
			@Result(property="prodi", column="id_prodi",
				javaType = ProgramStudiModel.class,
				many=@Many(select="searchProdi"))
	})MahasiswaModel searchMahasiswa (@Param("npm") String npm);
	
	@Select("select kode_univ, nama_univ from universitas where id = (select id_univ from fakultas where id = (select id_fakultas from program_studi where id = #{kode_prodi}))")
	UniversitasModel searchUniv (@Param("kode_prodi") String kode_prodi);
	
	@Select("select kode_fakultas, nama_fakultas from fakultas where id = (select id_fakultas from program_studi where id = #{kode_prodi})")
	UniversitasModel searchFakultas (@Param("kode_prodi") String kode_prodi);
	
	@Select("select kode_prodi, nama_prodi from program_studi where id = #{kode_prodi}")
	ProgramStudiModel searchProdi (@Param("kode_prodi") String kode_prodi);
	
	@Select("select max(npm) from mahasiswa where npm like CONCAT(#{npm},'%') limit 1")
    String selectNpm (@Param("npm") String npm);
    
    @Select("SELECT COUNT(mahasiswa.npm) as jlh_mahasiswa FROM mahasiswa WHERE status = 'Lulus'"
    		+ "and tahun_masuk = #{tahun_masuk} AND id_prodi = #{id_prodi}")
    Integer getJumlahMhsLulus(@Param("tahun_masuk") String tahun_masuk, @Param("id_prodi") Integer id_prodi);
    
    @Select("SELECT COUNT(mahasiswa.npm) as jlh_mahasiswa FROM mahasiswa WHERE "
    		+ "tahun_masuk = #{tahun_masuk} AND id_prodi = #{id_prodi}")
    Integer getTotalMahasiswa(@Param("tahun_masuk") String tahun_masuk, @Param("id_prodi") Integer id_prodi);
    
    @Select("select id, kode_univ, nama_univ from universitas")
    List<UniversitasModel> selectAllUniversitas();
	
    @Select("select id, kode_prodi, nama_prodi, id_fakultas from program_studi where id = #{id_prodi}")
    ProgramStudiModel selectProdi (@Param("id_prodi") Integer id_prodi);
    
    @Select("select id, kode_fakultas, nama_fakultas, id_univ from fakultas where id = #{id_fakultas}")
    FakultasModel selectFakultas (@Param("id_fakultas") Integer id_fakultas);
    
    @Select("select id, kode_univ, nama_univ from universitas where id = #{id_univ}")
    UniversitasModel selectUniversitas (@Param("id_univ") Integer id_univ);
    
	@Select("select * from mahasiswa where id_prodi = #{id_prodi} order by id desc limit 1")
    @Results( value = {
            @Result(property = "npm", column = "npm"),
            @Result(property = "nama", column = "nama"),
            @Result(property = "tempat_lahir", column = "tempat_lahir"),
            @Result(property = "tanggal_lahir", column = "tanggal_lahir"),
            @Result(property = "jenis_kelamin", column = "jenis_kelamin"),
            @Result(property = "agama", column = "agama"),
            @Result(property = "golongan_darah", column = "golongan_darah"),
            @Result(property = "status", column = "status"),
            @Result(property = "tahun_masuk", column = "tahun_masuk"),
            @Result(property = "jalur_masuk", column = "jalur_masuk"),
            @Result(property = "prodi", column = "id_prodi", one = @One(select = "selectProdi"))
    })
    MahasiswaModel selectMahasiswaByProdi (@Param("id_prodi") int id_prodi);
	
	@Select("select * from mahasiswa where npm LIKE #{npm} order by npm desc limit 1")
    @Results( value = {
            @Result(property = "npm", column = "npm")
    })
    MahasiswaModel selectMahasiswaByNpm (@Param("npm") String npm);
    
	
	@Insert("INSERT INTO mahasiswa (npm, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, agama, golongan_darah, tahun_masuk, jalur_masuk, id_prodi) "
			+ "VALUES (#{mahasiswa.npm}, #{mahasiswa.nama}, #{mahasiswa.tempat_lahir},  #{mahasiswa.tanggal_lahir}, #{mahasiswa.jenis_kelamin}, #{mahasiswa.agama}, #{mahasiswa.golongan_darah}, #{mahasiswa.tahun_masuk}, #{mahasiswa.jalur_masuk}, #{mahasiswa.id_prodi})")
    void addMahasiswa (@Param("mahasiswa") MahasiswaModel mahasiswa);
	
	@Update("UPDATE mahasiswa SET nama = #{nama}, tempat_lahir = #{tempat_lahir},jenis_kelamin = #{jenis_kelamin},agama = #{agama},golongan_darah = #{golongan_darah},tahun_masuk = #{tahun_masuk},jalur_masuk = #{jalur_masuk},id_prodi = #{id_prodi}  WHERE npm = #{npm}")
    void updateMahasiswa (MahasiswaModel mahasiswa);
}
