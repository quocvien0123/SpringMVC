package com.example.app.repository;

import com.example.app.entity.CongViec;
import com.example.app.entity.CongViecId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CongViecRepositoty extends JpaRepository<CongViec, CongViecId> {
    @Query("SELECT c FROM CongViec c WHERE c.id.soCMND = :soCMND")
    List<CongViec> findBySoCMND(@Param("soCMND") String soCMND);
}
