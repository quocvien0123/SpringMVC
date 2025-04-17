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
@Table(name = "truong", schema = "thongkevieclam")
public class Truong {
    @Id
    @Size(max = 10)
    @Column(name = "MaTruong", nullable = false, length = 10)
    private String maTruong;

    @NotNull
    @Lob
    @Column(name = "TenTruong", nullable = false)
    private String tenTruong;

    @NotNull
    @Lob
    @Column(name = "DiaChi", nullable = false)
    private String diaChi;

    @Size(max = 10)
    @NotNull
    @Column(name = "SoDT", nullable = false, length = 10)
    private String soDT;

    @OneToMany(mappedBy = "maTruong")
    private Set<TotNghiep> totNghieps = new LinkedHashSet<>();

}