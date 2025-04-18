package com.example.app.service;

import com.example.app.entity.CongViec;
import com.example.app.repository.CongViecRepositoty;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class CongViecService {
    CongViecRepositoty  congViecRepositoty;
    public List<CongViec> findBySoCMND(String soCMND){
        return congViecRepositoty.findBySoCMND(soCMND);
    }
}
