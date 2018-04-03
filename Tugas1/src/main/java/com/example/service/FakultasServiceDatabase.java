package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MahasiswaMapper;
import com.example.dao.UniversitasMapper;
import com.example.model.FakultasModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FakultasServiceDatabase implements FakultasService{
	
	@Autowired
    private UniversitasMapper fakultasMapper;
	private MahasiswaMapper mahasiswaMapper;
	
	@Override
   	public FakultasModel selectFakultas(int id_fakultas) {
    		log.info ("select  univ");
    		return mahasiswaMapper.selectFakultas(id_fakultas);
    }
}
