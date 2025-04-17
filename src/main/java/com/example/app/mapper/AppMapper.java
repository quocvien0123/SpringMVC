//package com.example.app.mapper;
//
//import com.example.app.dto.request.ThongTinSinhVienRequest;
//import com.example.app.entity.SinhVien;
//import com.example.app.entity.TotNghiep;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//@Mapper(componentModel = "spring")
//public interface AppMapper {
//
//    // Map DTO to SinhVien entity
//    @Mapping(target = "congViecs", ignore = true)
//    @Mapping(target = "totNghieps", ignore = true)
//    SinhVien toSinhVien(ThongTinSinhVienRequest request);
//
//    // Tạo TotNghiep từ request
//    @Mapping(target = "id", expression = "java(new TotNghiepId(request.getSoCMND(), request.getMaTruong(), request.getMaNganh()))")
//    @Mapping(target = "sinhVien.soCMND", source = "soCMND")
//    @Mapping(target = "truong.maTruong", source = "maTruong")
//    @Mapping(target = "nganh.maNganh", source = "maNganh")
//    TotNghiep toTotNghiep(ThongTinSinhVienRequest request);
//}
//
