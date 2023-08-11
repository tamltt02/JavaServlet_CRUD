package com.example.assignment.service;

import com.example.assignment.dto.GioHangChiTietDTO;

public interface GioHangCTService {
    GioHangChiTietDTO tangSoLuong(Integer idsp, Integer soLuong);
    GioHangChiTietDTO giamSoLuong(Integer idsp, Integer soLuong);

}
