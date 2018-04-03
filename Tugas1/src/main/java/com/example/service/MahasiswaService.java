package com.example.service;

import org.apache.ibatis.annotations.Param;

import com.example.model.FakultasModel;
import com.example.model.MahasiswaModel;
import com.example.model.ProgramStudiModel;
import com.example.model.UniversitasModel;

public interface MahasiswaService {
	MahasiswaModel searchMahasiswa (String npm);
	
	void addMahasiswa (MahasiswaModel mahasiswa); 
	
	void updateMahasiswa (MahasiswaModel mahasiswa);
	
	MahasiswaModel selectMahasiswaByProdi (int id_prodi);
	
	MahasiswaModel selectMahasiswaByNpm (String npm);
	
	ProgramStudiModel searchProdi (String kode_prodi);
	
	ProgramStudiModel selectProdi(Integer id_prodi);
    
    FakultasModel selectFakultas(Integer id_fakultas);
    
    UniversitasModel selectUniversitas(Integer id_univ);
    
    public String selectNpm (String npm);
    
    public Integer jumlahMahasiwaLulus(String tahun_masuk, Integer id_prodi);
    
    public Integer totalMahasiswa(String tahun_masuk, Integer id_prodi);
	
}
