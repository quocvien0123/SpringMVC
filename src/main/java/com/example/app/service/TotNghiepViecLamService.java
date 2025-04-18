package com.example.app.service;

import com.example.app.dto.response.TotNghiepViecLamDTO;
import com.example.app.entity.CongViec;
import com.example.app.entity.SinhVien;
import com.example.app.entity.TotNghiep;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TotNghiepViecLamService {

    SinhVienService sinhVienService;
    CongViecService congViecService;
    TotNghiepService totNghiepService;

    public TotNghiepViecLamDTO ketQuaTimKiem(String soCMND) {
        System.out.println(soCMND);
        TotNghiepViecLamDTO totNghiepViecLamDTO = new TotNghiepViecLamDTO();
        Optional<SinhVien> sinhVien = sinhVienService.findById(soCMND);
        if (sinhVien.isPresent()) {
            List<CongViec> congViec = congViecService.findBySoCMND(soCMND);
            List<TotNghiep> totNghiep = totNghiepService.findBySoCMND(soCMND);
            totNghiepViecLamDTO.setSoCMND(soCMND);
            totNghiepViecLamDTO.setHoTen(sinhVien.get().getSoCMND());
            totNghiepViecLamDTO.setHoTen(sinhVien.get().getHoTen());
            totNghiepViecLamDTO.setMaNganh(totNghiep.get(0).getMaNghanh().getMaNganh());
            totNghiepViecLamDTO.setMaTruong(totNghiep.get(0).getMaTruong().getMaTruong());
            totNghiepViecLamDTO.setTenCongTy(congViec.get(0).getTenCongTy());
            totNghiepViecLamDTO.setThoiGianLamViec(congViec.get(0).getThoiGianLamViec());
        } else {
            return null;
        }

        return totNghiepViecLamDTO;
    }

}
