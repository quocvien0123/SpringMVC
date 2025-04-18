package com.example.app.controller;

import com.example.app.dto.request.ThongTinSinhVienRequest;
import com.example.app.entity.SinhVien;
import com.example.app.service.SinhVienService;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class TimKiemController {
    @Autowired
    SinhVienService sinhVienService;
    @GetMapping("/search")
    public String timKiem(Model model){
        model.addAttribute("keyword", new ThongTinSinhVienRequest() );
        return "TimKiemCoBan";
    }
    @GetMapping("/search-result")
    public String timKiemResult(@ModelAttribute("sinhVien") ThongTinSinhVienRequest request, BindingResult result, Model model){
        model.addAttribute("sinhVien", sinhVienService.searchAllFields(request.getSoCMND()));
        model.addAttribute("keyword",new ThongTinSinhVienRequest());
        return "TimKiemCoBan";
    }
}
