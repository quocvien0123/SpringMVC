package com.example.app.repository;

import com.example.app.entity.TotNghiep;
import com.example.app.entity.TotNghiepId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TotNghiepRepository extends JpaRepository<TotNghiep, TotNghiepId> {
}
