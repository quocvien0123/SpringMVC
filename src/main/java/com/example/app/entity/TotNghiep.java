package com.example.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tot_nghiep", schema = "thongkevieclam")
public class TotNghiep {
    @EmbeddedId
    private TotNghiepId id;

    @MapsId("soCMND")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SoCMND", nullable = false)
    private SinhVien soCMND;

    @MapsId("maTruong")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaTruong", nullable = false)
    private Truong maTruong;

    @MapsId("maNghanh")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaNghanh", nullable = false)
    private Nganh maNghanh;

    @Size(max = 20)
    @NotNull
    @Column(name = "HeTN", nullable = false, length = 20)
    private String heTN;

    @NotNull
    @Column(name = "NgayTN", nullable = false)
    private LocalDate ngayTN;

    @Size(max = 20)
    @NotNull
    @Column(name = "LoaiTN", nullable = false, length = 20)
    private String loaiTN;

}