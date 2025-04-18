package com.example.app.service;

import com.example.app.dto.response.TotNghiepViecLamDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TotNghiepViecLamService {
    SinhVienService sinhVienService;

    @Transactional
    public void ketQuaTimKiem(TotNghiepViecLamDTO request){

    }
}
