package com.example.service;

import com.example.model.MahasiswaModel;

public interface MahasiswaService {
	MahasiswaModel searchMahasiswa (String npm);
	
	void addMahasiswa (MahasiswaModel mahasiswa); 
	
	void updateMahasiswa (MahasiswaModel mahasiswa);
}
