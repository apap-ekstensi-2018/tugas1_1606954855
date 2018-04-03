package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.MahasiswaMapper;
import com.example.dao.UniversitasMapper;
import com.example.model.FakultasModel;
import com.example.model.ProgramStudiModel;
import com.example.model.UniversitasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UniversitasServiceDatabase implements UniversitasService {
	@Autowired
    private UniversitasMapper universitasMapper;
	private MahasiswaMapper mahasiswaMapper;


    @Override
	public List<UniversitasModel> getAllUniv () {
		log.info ("select all univ");
        List<UniversitasModel> universitas = universitasMapper.getAllUniv();
        return universitasMapper.getAllUniv();
	}
    
    @Override
   	public UniversitasModel selectUniversitas(int id_univ) {
    		log.info ("select  univ");
    		return mahasiswaMapper.selectUniversitas(id_univ);
    }
    
}
