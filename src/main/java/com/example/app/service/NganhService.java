package com.example.app.service;

import com.example.app.entity.Nganh;
import com.example.app.repository.NganhRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NganhService {
    NganhRepository nganhRepository;
    public List<Nganh> findAll(){
        return nganhRepository.findAll();
    }
}
