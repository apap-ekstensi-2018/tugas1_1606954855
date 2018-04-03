package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.UniversitasModel;
import com.example.service.UniversitasService;

@Controller
public class UniversitasController {
	@Autowired
    UniversitasService univDAO;
	
	@RequestMapping("/univ/cari")
    public String view (Model model)
    {
//		List<UniversitasModel> universitas = univDAO.getAllUniv();
//        model.addAttribute ("universitas", universitas);
        return "universitas/search-univ";
    }
}
