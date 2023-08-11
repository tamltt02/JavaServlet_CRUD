package com.example.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienDTO {
    private Integer id ;

    private String ma ;

    private String hoTen;

    private String gioiTinh;

    private Date ngaySinh;

    private String diaChi;
    private String email;

    private String matKhau;

    private Integer trangThai ;

    private CuaHangDTO cuaHang ;

    private ChucVuDTO chucVu ;
}
