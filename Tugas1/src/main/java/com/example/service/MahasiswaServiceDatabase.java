package com.example.service;

//import java.util.Date;
//import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MahasiswaMapper;
import com.example.model.MahasiswaModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MahasiswaServiceDatabase implements MahasiswaService{
	@Autowired
    private MahasiswaMapper mahasiswaMapper;


    @Override
    public MahasiswaModel searchMahasiswa (String npm)
    {
        log.info ("select mahasiswa with npm {}", npm);
        MahasiswaModel mahasiswa = mahasiswaMapper.searchMahasiswa(npm);
//		Date now = new Date();
//		long diff = now.getTime() - mahasiswa.getTangggl_lahir().getTime();
//		int umur = (int)(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS))/365;
//		mahasiswa.setUmur(umur);
		return mahasiswa;
		
//		return mahasiswaMapper.searchMahasiswa (npm);
    }
    
    @Override
	public void addMahasiswa(MahasiswaModel mahasiswa) {
		//log.info ("insert student with nomor {}", mahasiswa.getNomor());
		mahasiswaMapper.addMahasiswa(mahasiswa);
	}
    
    @Override
    public void updateMahasiswa (MahasiswaModel mahasiswa)
    {
    		log.info("mahasiswa " + mahasiswa.getNpm() + " updated");
    		mahasiswaMapper.updateMahasiswa(mahasiswa);
    }
}
