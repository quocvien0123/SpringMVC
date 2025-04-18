package com.example.app.controller;

import com.example.app.dto.request.ThongTinSinhVienRequest;
import com.example.app.dto.response.TotNghiepViecLamDTO;
import com.example.app.service.SinhVienService;
import com.example.app.service.TotNghiepViecLamService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TimKiemTotnghiepViecLam {

    @Autowired
    TotNghiepViecLamService totNghiepViecLamService;

    @GetMapping("/search-totnghiep-vieclam")
    public String timkiemTotNghiepViecLam(Model model){
        model.addAttribute("keyword", new ThongTinSinhVienRequest());
        return "TimKiemTotNghiepViecLam";
    }

    @GetMapping("/search-totnghiep-vieclam-result")
    public String timKiemTotNghiepViecLamResult(@ModelAttribute("sinhVien")TotNghiepViecLamDTO request, BindingResult result, Model model){
        model.addAttribute("keyword", new ThongTinSinhVienRequest());
        model.addAttribute("sinhVien", totNghiepViecLamService.ketQuaTimKiem(request.getSoCMND()));
        return "TimKiemTotNghiepViecLam";
    }
}
