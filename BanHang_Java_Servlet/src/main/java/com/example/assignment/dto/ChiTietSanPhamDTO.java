package com.example.assignment.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietSanPhamDTO {

    private Integer id;

    @NotNull(message = "Khong duoc null")
    private Integer namBaoHanh;


    private String moTa;

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
