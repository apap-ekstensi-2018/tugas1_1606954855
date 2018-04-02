package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MahasiswaMapper;
import com.example.model.MahasiswaModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MahasiswaServiceDatabase implements MahasiswaMapper{
	@Autowired
    private MahasiswaMapper mahasiswaMapper;


    @Override
    public MahasiswaModel searchMahasiswa (String npm)
    {
        log.info ("select mahasiswa with npm {}", npm);
        return mahasiswaMapper.searchMahasiswa(npm);
    }
}
