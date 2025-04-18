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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<ThongTinSinhVienRequest> getData(){
        List<ThongTinSinhVienRequest> data = new ArrayList<>();
        List<SinhVien> sinhViens = sinhVienRepositoty.findAll();
        for (SinhVien sv : sinhViens){
            ThongTinSinhVienRequest dto = new ThongTinSinhVienRequest();
            List<TotNghiep> totNghiep = totNghiepRepository.findBySoCMND(sv.getSoCMND());
            dto.setSoCMND(sv.getSoCMND());
            dto.setHoTen(sv.getHoTen());
            dto.setEmail(sv.getEmail());
            dto.setSoDT(sv.getSoDT());
            dto.setDiaChi(sv.getDiaChi());
            dto.setMaTruong(totNghiep.get(0).getMaTruong().getMaTruong());
            dto.setMaNganh(totNghiep.get(0).getMaNghanh().getMaNganh());
            dto.setHeTN(totNghiep.get(0).getHeTN());
            dto.setNgayTN(totNghiep.get(0).getNgayTN());
            dto.setLoaiTN(totNghiep.get(0).getLoaiTN());
            data.add(dto);
        }
        return data;
    }

    public ThongTinSinhVienRequest dataEdit(Optional<SinhVien> sv, List<TotNghiep> tn){
        ThongTinSinhVienRequest data = new ThongTinSinhVienRequest();
        data.setSoCMND(sv.get().getSoCMND());
        data.setHoTen(sv.get().getHoTen());
        data.setEmail(sv.get().getEmail());
        data.setDiaChi(sv.get().getDiaChi());
        data.setSoDT(sv.get().getSoDT());
        data.setMaNganh(tn.get(0).getMaNghanh().getMaNganh());
        data.setMaTruong(tn.get(0).getMaTruong().getMaTruong());
        data.setHeTN(tn.get(0).getHeTN());
        data.setNgayTN(tn.get(0).getNgayTN());
        data.setLoaiTN(tn.get(0).getLoaiTN());
        return data;
    }
}
