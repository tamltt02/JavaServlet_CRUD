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
public class KhachHangDTO {

    private Integer id;

    private String ma;

    private String hoTen;

    private Date ngaySinh;

    private String diaChi;

    private String sdt;

    private String username;

    private String email;

    private String matKhau;

}
