package com.example.app.controller;

import com.example.app.dto.request.ThongTinSinhVienRequest;
import com.example.app.service.NganhService;
import com.example.app.service.SinhVienTotNghiepService;
import com.example.app.service.TruongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;

@Controller
@RequestMapping("/")
public class ThongTinSVController {
    @Autowired
    TruongService truongService;
    @Autowired
    NganhService nganhService;
    @Autowired
    SinhVienTotNghiepService sinhVienTotNghiepService;

    @GetMapping("/")
    public String ThongTinSinhVien(Model model) {
        model.addAttribute("sinhVien", new ThongTinSinhVienRequest());
        model.addAttribute("truongs",truongService.findAll());
        model.addAttribute("nganhs", nganhService.findAll());
        return "ThongTinSinhVien";
    }
    @PostMapping("/add")
    public String submitForm(@Valid @ModelAttribute("sinhVien") ThongTinSinhVienRequest request , BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("truongs",truongService.findAll());
            model.addAttribute("nganhs", nganhService.findAll());
            model.addAttribute("error",  bindingResult.getAllErrors());
            return "ThongTinSinhVien";
        }
        try {
            System.out.println(request);
            sinhVienTotNghiepService.thongTinSinhVien(request);
        } catch (Exception e) {
            model.addAttribute("sinhVien", new ThongTinSinhVienRequest());
            model.addAttribute("truongs",truongService.findAll());
            model.addAttribute("nganhs", nganhService.findAll());
            model.addAttribute("error", e.getMessage());
            return "ThongTinSinhVien";
        }
        return "redirect:/";
    }


}
