package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MahasiswaMapper;
import com.example.dao.UniversitasMapper;
import com.example.model.ProgramStudiModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProgramStudiServiceDatabase implements ProgramStudiService{
	@Autowired
    private UniversitasMapper programStudiMapper;
	private MahasiswaMapper mahasiswaMapper;
	
	 @Override
	   	public ProgramStudiModel selectProdi(int id_prodi) {
	    		log.info ("select  univ");
			return mahasiswaMapper.selectProdi(id_prodi);
	    }
}
