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
@Table(name = "nganh", schema = "thongkevieclam")
public class Nganh {
    @Id
    @Size(max = 10)
    @Column(name = "MaNganh", nullable = false, length = 10)
    private String maNganh;

    @Size(max = 30)
    @NotNull
    @Column(name = "TenNganh", nullable = false, length = 30)
    private String tenNganh;

    @Size(max = 30)
    @NotNull
    @Column(name = "LoaiNganh", nullable = false, length = 30)
    private String loaiNganh;

    @OneToMany(mappedBy = "maNganh")
    private Set<CongViec> congViecs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "maNghanh")
    private Set<TotNghiep> totNghieps = new LinkedHashSet<>();

}