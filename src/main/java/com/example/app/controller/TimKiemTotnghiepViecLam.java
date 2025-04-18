package com.example.app.controller;

import com.example.app.dto.request.ThongTinSinhVienRequest;
import com.example.app.dto.response.TotNghiepViecLamDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TimKiemTotnghiepViecLam {
    @GetMapping("/search-totnghiep-vieclam")
    public String timkiemTotNghiepViecLam(Model model){
        model.addAttribute("keyword", new ThongTinSinhVienRequest());
        return "TimKiemTotNghiepViecLam";
    }
    @GetMapping("/search-totnghiep-vieclam-result")
    public String timKiemTotNghiepViecLamResult(@ModelAttribute("sinhVien")TotNghiepViecLamDTO request, BindingResult result, Model model){
        model.addAttribute("keyword", new ThongTinSinhVienRequest());
        model.addAttribute("result", )
        return "TimKiemTotNghiepViecLam";
    }
}
