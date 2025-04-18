package com.example.app.service;

import com.example.app.entity.SinhVien;
import com.example.app.repository.SinhVienRepositoty;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SinhVienService {
    SinhVienRepositoty sinhVienRepositoty;
    public List<SinhVien> searchAllFields(String keyword){
        return sinhVienRepositoty.searchAllFields(keyword);
    }

}
