package com.example.assignment.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GioHangChiTietDTO {
    private Integer id ;

    private Integer soLuong ;

    private double donGia ;

    private double donGiaKhiGia ;

    private GioHangDTO gioHang ;

    private ChiTietSanPhamDTO chiTietSanPham ;
}
