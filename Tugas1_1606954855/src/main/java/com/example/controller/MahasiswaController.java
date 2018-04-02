package com.example.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.model.MahasiswaModel;
import com.example.service.MahasiswaService;

@Controller
public class MahasiswaController {
	@Autowired
    MahasiswaService mahasiswaDAO;
	
	@RequestMapping("/hello")
    public String index ()
    {
        return "index";
    }
	
//	@RequestMapping(value = "/search/submit", method = RequestMethod.POST)
//    public String updateSubmit (
//    		@RequestParam(value = "npm", required = true) String npm, Model model)
//    {
//	    	MahasiswaModel mahasiswa = mahasiswaDAO.searchMahasiswa(npm);
//	    	
//	    	if(mahasiswa==null){
//	    		model.addAttribute ("npm", npm);
//	    		return "mahasiswa/not-found";
//	    	}
//	    	else{
//	    		model.addAttribute ("mahasiswa", mahasiswa);
//	    		return "mahasiswa/view";
//	    	}
//    }
//	
//	@RequestMapping("/mahasiswa")
//	public String view (Model model, @RequestParam(value = "npm", required = true) String npm)
//    {
//		MahasiswaModel mahasiswa = mahasiswaDAO.searchMahasiswa(npm);
//    	if(mahasiswa==null){
//    		model.addAttribute ("nomor", npm);
//    		return "student/not-found";
//    	}
//    	else{
//    		model.addAttribute ("mahasiswa", mahasiswa);
//    		return "student/view-student";
//    	}
//    }
}
