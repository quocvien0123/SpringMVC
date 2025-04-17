package com.example.app.controller;

import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TimKiemController {
    @GetMapping("/search")
    public String timKiem(Model model){
        model.addAttribute("keyword","");
        return "TimKiemCoBan";
    }
}
