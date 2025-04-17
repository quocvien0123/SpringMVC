package com.example.app.repository;

import com.example.app.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SinhVienRepositoty extends JpaRepository<SinhVien,String> {
    @Query(
            "SELECT sv FROM SinhVien sv " +
                    "WHERE LOWER(sv.soCMND) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
                    "   OR LOWER(sv.hoTen) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
                    "   OR LOWER(sv.email) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
                    "   OR LOWER(sv.soDT) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
                    "   OR LOWER(sv.diaChi) LIKE LOWER(CONCAT('%', :keyword, '%'))"
    )
    List<SinhVien> searchAllFields(@Param("keyword") String keyword);
}
