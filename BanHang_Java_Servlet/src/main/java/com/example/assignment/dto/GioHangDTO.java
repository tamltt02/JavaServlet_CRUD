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
public class GioHangDTO {
    private Integer id;

    private String ma;

    private Date ngayThanhToan;

    private Date ngayTao;

    private Integer tinhTrang;

    private String tenNguoiNhan;

    private String diaChi;

    private String sdt;

    private NhanVienDTO nhanVien;

    private KhachHangDTO khachHang;
}
