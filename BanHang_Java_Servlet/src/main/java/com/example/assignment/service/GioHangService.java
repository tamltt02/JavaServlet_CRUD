package com.example.assignment.service;

import com.example.assignment.dto.GioHangChiTietDTO;
import com.example.assignment.entity.GioHangChiTiet;

import java.util.List;

public interface GioHangService {
    List<GioHangChiTietDTO> getgioHang(Integer id);

    GioHangChiTietDTO addGioHang(Integer idsp, Integer soLuong);
    double tongtien(List<GioHangChiTietDTO> dtoList);
    void remove(Integer id);
}
