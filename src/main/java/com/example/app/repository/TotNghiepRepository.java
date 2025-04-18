package com.example.app.repository;

import com.example.app.entity.TotNghiep;
import com.example.app.entity.TotNghiepId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TotNghiepRepository extends JpaRepository<TotNghiep, TotNghiepId> {
    @Query("SELECT t FROM TotNghiep t WHERE t.id.soCMND = :soCMND")
    List<TotNghiep> findBySoCMND(@Param("soCMND") String soCMND);

}
