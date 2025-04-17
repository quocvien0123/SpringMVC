package com.example.app.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ThongTinSinhVienRequest {
    @NotBlank(message = "Số CMND không được để trống!")
    String soCMND;
    String hoTen;
    String email;
    String soDT;
    String diaChi;
    @NotBlank(message = "Mã trường không được để trống!")
    String maTruong;
    @NotBlank(message = "Mã ngành không được đẻ trống!")
    String maNganh;
    String heTN;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate ngayTN;
    String loaiTN;
}
