package com.example.service;

//import java.util.Date;
//import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MahasiswaMapper;
import com.example.model.FakultasModel;
import com.example.model.MahasiswaModel;
import com.example.model.ProgramStudiModel;
import com.example.model.UniversitasModel;

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
    
    @Override
    public MahasiswaModel selectMahasiswaByProdi (int id_prodi)
    {
    		log.info("select mahasiswa by prodi");
    		return mahasiswaMapper.selectMahasiswaByProdi(id_prodi);
    }
    
    @Override
	public ProgramStudiModel selectProdi(Integer id_prodi) {
		log.info ("select program studi dengan kode {}", id_prodi);
        return mahasiswaMapper.selectProdi(id_prodi);
	}


	@Override
	public FakultasModel selectFakultas(Integer id_fakultas) {
		log.info ("select fakultas dengan kode {}", id_fakultas);
		return mahasiswaMapper.selectFakultas(id_fakultas);
	}

	@Override
	public UniversitasModel selectUniversitas(Integer id_univ) {
		log.info ("select universitas dengan kode {}", id_univ);
		return mahasiswaMapper.selectUniversitas(id_univ);
	}
	
	@Override
    public String selectNpm (String npm){
    	log.info("select NPM like (to calculate)");
    	return mahasiswaMapper.selectNpm(npm);
    }


	@Override
	public Integer jumlahMahasiwaLulus(String tahun_masuk, Integer id_prodi) {
		log.info("select count() mahasiswa lulus");
		return mahasiswaMapper.getJumlahMhsLulus(tahun_masuk, id_prodi);
	}


	@Override
	public Integer totalMahasiswa(String tahun_masuk, Integer id_prodi) {
		log.info("select count() seluruh mahasiwa");
		return mahasiswaMapper.getTotalMahasiswa(tahun_masuk, id_prodi);
	}
    
    @Override
    public MahasiswaModel selectMahasiswaByNpm (String npm) {
    		log.info("select mahasiswa by npm");
    		return  mahasiswaMapper.selectMahasiswaByNpm(npm);
    }
    
    @Override
    public ProgramStudiModel searchProdi (String kode_prodi) {
    		log.info("search prodi");
		return  mahasiswaMapper.searchProdi(kode_prodi);
    }
    
}
