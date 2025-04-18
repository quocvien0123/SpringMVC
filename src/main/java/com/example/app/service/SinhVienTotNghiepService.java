package com.example.app.service;

import com.example.app.dto.request.ThongTinSinhVienRequest;
import com.example.app.entity.*;
import com.example.app.repository.NganhRepository;
import com.example.app.repository.SinhVienRepositoty;
import com.example.app.repository.TotNghiepRepository;
import com.example.app.repository.TruongRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class SinhVienTotNghiepService {
    SinhVienRepositoty sinhVienRepositoty;
    TotNghiepRepository totNghiepRepository;
    NganhRepository nganhRepository;
    TruongRepository truongRepository;

    @Transactional
    public void thongTinSinhVien(ThongTinSinhVienRequest request){
        SinhVien sinhVien = new SinhVien();
        sinhVien.setSoCMND(request.getSoCMND());
        sinhVien.setHoTen(request.getHoTen());
        sinhVien.setEmail(request.getEmail());
        sinhVien.setSoDT(request.getSoDT());
        sinhVien.setDiaChi(request.getDiaChi());
        sinhVienRepositoty.save(sinhVien);

        SinhVien sv = sinhVienRepositoty.findById(request.getSoCMND()).orElseThrow();
        Nganh nganh = nganhRepository.findById(request.getMaNganh()).orElseThrow();
        Truong truong = truongRepository.findById(request.getMaTruong()).orElseThrow();

        TotNghiepId totNghiepId = new TotNghiepId(
                sv.getSoCMND(),
                nganh.getMaNganh(),
                truong.getMaTruong()
        );

        TotNghiep totNghiep = new TotNghiep();
        totNghiep.setId(totNghiepId);
        totNghiep.setSoCMND(sv);
        totNghiep.setMaTruong(truong);
        totNghiep.setMaNghanh(nganh);
        totNghiep.setHeTN(request.getHeTN());
        totNghiep.setNgayTN(request.getNgayTN());
        totNghiep.setLoaiTN(request.getLoaiTN());
        totNghiepRepository.save(totNghiep);
    }
}
