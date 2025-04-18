package com.example.app.repository;

import com.example.app.entity.CongViec;
import com.example.app.entity.CongViecId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CongViecRepositoty extends JpaRepository<CongViec, CongViecId> {
}
