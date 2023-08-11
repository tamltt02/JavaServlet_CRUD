package com.example.assignment.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonChiTietDTO {
    private Integer id ;

    private Integer soLuong ;

    private double donGia ;

    private HoaDonDTO hoaDon ;

    private ChiTietSanPhamDTO chiTietSanPham ;
}
