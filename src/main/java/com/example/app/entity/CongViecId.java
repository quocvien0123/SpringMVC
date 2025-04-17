package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class CongViecId implements Serializable {
    private static final long serialVersionUID = 8852270403782599494L;
    @NotNull
    @Column(name = "NgayVaoCongTy", nullable = false)
    private LocalDate ngayVaoCongTy;

    @Size(max = 20)
    @NotNull
    @Column(name = "SoCMND", nullable = false, length = 20)
    private String soCMND;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CongViecId entity = (CongViecId) o;
        return Objects.equals(this.soCMND, entity.soCMND) &&
                Objects.equals(this.ngayVaoCongTy, entity.ngayVaoCongTy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soCMND, ngayVaoCongTy);
    }

}