package com.example.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "sinh_vien", schema = "thongkevieclam")
public class SinhVien {
    @Id
    @Size(max = 20)
    @Column(name = "SoCMND", nullable = false, length = 20)
    private String soCMND;

    @Size(max = 30)
    @NotNull
    @Column(name = "HoTen", nullable = false, length = 30)
    private String hoTen;

    @Size(max = 30)
    @NotNull
    @Column(name = "Email", nullable = false, length = 30)
    private String email;

    @Size(max = 10)
    @NotNull
    @Column(name = "SoDT", nullable = false, length = 10)
    private String soDT;

    @NotNull
    @Size(max = 20)
    @Column(name = "DiaChi", nullable = false, length = 20)
    private String diaChi;

    @OneToMany(mappedBy = "soCMND")
    private Set<CongViec> congViecs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "soCMND")
    private Set<TotNghiep> totNghieps = new LinkedHashSet<>();

}