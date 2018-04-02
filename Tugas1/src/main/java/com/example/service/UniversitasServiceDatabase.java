package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.UniversitasMapper;
import com.example.model.UniversitasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UniversitasServiceDatabase implements UniversitasService {
	@Autowired
    private UniversitasMapper universitasMapper;


    @Override
	public UniversitasModel getAllUniv () {
		log.info ("select all univ");
        UniversitasModel universitas = universitasMapper.getAllUniv();
        return universitas;
	}
}
