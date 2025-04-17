package com.example.app.service;

import com.example.app.entity.Truong;
import com.example.app.repository.TruongRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class TruongService {
    TruongRepository truongRepository;
    public List<Truong> findAll(){
        return truongRepository.findAll();
    }
}
