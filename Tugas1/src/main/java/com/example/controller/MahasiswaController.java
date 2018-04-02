package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.example.model.FakultasModel;
import com.example.model.MahasiswaModel;
import com.example.model.ProgramStudiModel;
import com.example.model.UniversitasModel;
import com.example.service.MahasiswaService;
import com.example.service.UniversitasService;

@Controller
public class MahasiswaController {
	@Autowired
    MahasiswaService mahasiswaDAO;
	UniversitasService univDAO;
	
	@RequestMapping("/")
    public String index ()
    {
        return "index";
    }
	
	@RequestMapping("/add")
    public String add (Model model)
    {	
		model.addAttribute ("mahasiswa", new MahasiswaModel());
        return "mahasiswa/add-mahasiswa";
    }
	
	@RequestMapping("/mahasiswa/add/submit")
    public String addSubmit (@RequestParam(value = "npm", required = false) String npm,
            @RequestParam(value = "nama", required = false) String nama,
            @RequestParam(value = "tempat_lahir", required = false) String tempat_lahir,
            @RequestParam(value = "tanggal_lahir", required = false) String tanggal_lahir,
            @RequestParam(value = "jenis_kelamin", required = false) int jenis_kelamin,
            @RequestParam(value = "agama", required = false) String agama,
            @RequestParam(value = "golongan_darah", required = false) String golongan_darah,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "tahun_masuk", required = false) String tahun_masuk,
            @RequestParam(value = "jalur_masuk", required = false) String jalur_masuk,
            @RequestParam(value = "id_prodi", required = false) int id_prodi,
            @RequestParam(value = "fakultas", required = false) FakultasModel fakultas,
            @RequestParam(value = "univ", required = false) UniversitasModel univ,
            @RequestParam(value = "prodi", required = false) ProgramStudiModel prodi, Model model)
    {
		npm = tahun_masuk + univ + prodi;
	 	MahasiswaModel mahasiswa = new MahasiswaModel (npm, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, agama, golongan_darah, status, tahun_masuk,jalur_masuk, id_prodi, fakultas, univ, prodi);
		mahasiswaDAO.addMahasiswa (mahasiswa);
		model.addAttribute ("mahasiswa", mahasiswa);
        return "mahasiswa/add-success";
    }
	
	
	@RequestMapping("/mahasiswa")
	public String view (Model model, @RequestParam(value = "npm", required = true) String npm)
    {
		MahasiswaModel mahasiswa = mahasiswaDAO.searchMahasiswa(npm);
	    	if(mahasiswa!=null){
	    		model.addAttribute ("mahasiswa", mahasiswa);
	    		return "mahasiswa/view-mahasiswa";
	    	}
	    	else{
	    		model.addAttribute ("npm", npm);
	    		return "mahasiswa/not-found";	
	    	}
    }
	
	
	@RequestMapping("/mahasiswa/update/{npm}")
	public String updateMahasiswa (Model model, @PathVariable(value = "npm") String npm)
    {
		List<String> jenis_kelaminList = new ArrayList<>();
		jenis_kelaminList.add("0");
		jenis_kelaminList.add("1");
		MahasiswaModel mahasiswa = mahasiswaDAO.searchMahasiswa(npm);
		mahasiswaDAO.updateMahasiswa(mahasiswa);
		model.addAttribute ("mahasiswa", mahasiswa);
		model.addAttribute ("jenis_kelaminList", jenis_kelaminList);
        return "mahasiswa/form-update";
    }
	
	@RequestMapping(value = "/mahasiswa/update/submit", method = RequestMethod.POST)
    public String updateSubmit (@ModelAttribute MahasiswaModel mahasiswa, Model model)
    {
        mahasiswaDAO.updateMahasiswa(mahasiswa);
        model.addAttribute ("mahasiswa", mahasiswa);
        return "mahasiswa/update-success";
    }
	
	@RequestMapping("/kelulusan")
    public String persentate (Model model)
    {	
        return "mahasiswa/presentase-kelulusan";
    }
	
	@RequestMapping("/mahasiswa/cari")
    public String search (Model model)
    {	
		
        return "universitas/search-univ";
        
    }
	
}
