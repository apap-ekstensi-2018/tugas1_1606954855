package com.example.service;

import org.apache.ibatis.annotations.Param;

import com.example.model.MahasiswaModel;

public interface MahasiswaService {
	MahasiswaModel searchMahasiswa (String npm);
	
	void addMahasiswa (MahasiswaModel mahasiswa); 
	
	void updateMahasiswa (MahasiswaModel mahasiswa);
	
	MahasiswaModel selectMahasiswaByProdi (int id_prodi);
	
	String selectAktifMahasiswa(String tahun_masuk, int id_prodi);
	
	String selectAktifAllMahasiswa(String tahun_masuk, int id_prodi);
	
	MahasiswaModel selectMahasiswaByNpm (String npm);
	
}
