package com.example.app.service;

import com.example.app.entity.SinhVien;
import com.example.app.repository.SinhVienRepositoty;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SinhVienService {
    SinhVienRepositoty sinhVienRepositoty;
    public List<SinhVien> searchAllFields(String keyword){
        return sinhVienRepositoty.searchAllFields(keyword);
    }
    public Optional<SinhVien> findById(String soCMND){
        return sinhVienRepositoty.findById(soCMND);
    }

}
