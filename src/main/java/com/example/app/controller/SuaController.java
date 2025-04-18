package com.example.app.controller;

import com.example.app.dto.request.ThongTinSinhVienRequest;
import com.example.app.entity.SinhVien;
import com.example.app.entity.TotNghiep;
import com.example.app.service.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SuaController {

    @Autowired
    TruongService truongService;
    @Autowired
    NganhService nganhService;
    @Autowired
    SinhVienService sinhVienService;
    @Autowired
    TotNghiepService totNghiepService;
    @Autowired
    SinhVienTotNghiepService sinhVienTotNghiepService;

    @GetMapping("/edit")
    public String edit(@RequestParam("soCMND") String soCMND, Model model) {
        Optional<SinhVien> sv = sinhVienService.findById(soCMND);
        List<TotNghiep> tn = totNghiepService.findBySoCMND(soCMND);
        model.addAttribute("truongs", truongService.findAll());
        model.addAttribute("nganhs", nganhService.findAll());
        model.addAttribute("sinhVien", sinhVienTotNghiepService.dataEdit(sv,tn));
        return "SuaSinhVien";
    }

    @PostMapping("/edit-complete")
    public String editComplete(@ModelAttribute("sinhVien") ThongTinSinhVienRequest request, Model model, BindingResult result){
        if(result.hasErrors()) {
            model.addAttribute("truongs",truongService.findAll());
            model.addAttribute("nganhs", nganhService.findAll());
            model.addAttribute("error",  result.getAllErrors());
            return "ThongTinSinhVien";
        }
        try {
            System.out.println(request);
            totNghiepService.delete(request.getSoCMND());
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
