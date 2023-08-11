package com.example.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangDTOForm {
    private Integer id;

    private String ma;

    private String hoTen;

    private String ngaySinh;

    private String diaChi;

    private String sdt;

    private String username;

    private String email;

    private String matKhau;

}
