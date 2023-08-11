package com.example.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietSanPhamDTOForm {


        private Integer id;

        @NotNull(message = "Khong duoc null")
        private Integer namBaoHanh;

        private MultipartFile moTa;

        @NotNull
        private Integer soLuongTon;

        @NotNull
        private double giaNhap;

        @NotNull
        private double giaBan;

        private SanPhamDTO sanPham;

        private NSXDTO nsx;

        private MauSacDTO mauSac;

        private DongSanPhamDTO dongSanPham;


}
