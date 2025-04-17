package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class TotNghiepId implements Serializable {
    private static final long serialVersionUID = -2279087085745831612L;
    @Size(max = 20)
    @NotNull
    @Column(name = "SoCMND", nullable = false, length = 20)
    private String soCMND;

    @Size(max = 10)
    @NotNull
    @Column(name = "MaTruong", nullable = false, length = 10)
    private String maTruong;

    @Size(max = 10)
    @NotNull
    @Column(name = "MaNghanh", nullable = false, length = 10)
    private String maNghanh;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TotNghiepId entity = (TotNghiepId) o;
        return Objects.equals(this.maNghanh, entity.maNghanh) &&
                Objects.equals(this.soCMND, entity.soCMND) &&
                Objects.equals(this.maTruong, entity.maTruong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNghanh, soCMND, maTruong);
    }

}