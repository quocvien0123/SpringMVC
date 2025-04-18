package com.example.app.service;

import com.example.app.entity.TotNghiep;
import com.example.app.repository.TotNghiepRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class TotNghiepService {
    TotNghiepRepository totNghiepRepository;
    public List<TotNghiep> findBySoCMND(String soCMND){
        return totNghiepRepository.findBySoCMND(soCMND);
    }

    public void delete(String soCMND){
        totNghiepRepository.delete(totNghiepRepository.findBySoCMND(soCMND).get(0));
    }
}
