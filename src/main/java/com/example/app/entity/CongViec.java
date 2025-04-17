package com.example.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cong_viec", schema = "thongkevieclam")
public class CongViec {
    @EmbeddedId
    private CongViecId id;

    @MapsId("soCMND")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SoCMND", nullable = false)
    private SinhVien soCMND;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaNganh", nullable = false)
    private Nganh maNganh;

    @Size(max = 50)
    @NotNull
    @Column(name = "TenCongViec", nullable = false, length = 50)
    private String tenCongViec;

    @Size(max = 50)
    @NotNull
    @Column(name = "TenCongTy", nullable = false, length = 50)
    private String tenCongTy;

    @NotNull
    @Lob
    @Column(name = "DiaChiCongTy", nullable = false)
    private String diaChiCongTy;

    @NotNull
    @Column(name = "ThoiGianLamViec", nullable = false)
    private Integer thoiGianLamViec;

}