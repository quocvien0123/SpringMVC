package com.example.app.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TotNghiepViecLamDTO {
    String soCMND;
    String hoTen;
    String maTruong;
    String maNganh;
    String tenCongTy;
    Integer thoiGianLamViec;
}
