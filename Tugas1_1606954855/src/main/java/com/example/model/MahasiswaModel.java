package com.example.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MahasiswaModel {
	private String npm;
	private String nama;
	private String tempat_lahir;
	private Date tanggal_lahir;
	private int jenis_kelamin;
	private String agama;
	private String golongan_darah;
	private String status;
	private String tahun_masuk;
	private String jalur_masuk;
	private int id_prodi;
	private FakultasModel fakultas;
	private UniversitasModel univ;
	private ProgramStudiModel prodi;
}
