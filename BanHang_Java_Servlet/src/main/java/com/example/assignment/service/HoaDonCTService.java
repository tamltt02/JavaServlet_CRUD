package com.example.assignment.service;

import com.example.assignment.dto.HoaDonChiTietDTO;
import com.example.assignment.dto.HoaDonDTO;
import com.example.assignment.entity.HoaDon;
import com.example.assignment.entity.HoaDonChiTiet;

import java.util.List;

public interface HoaDonCTService {
    List<HoaDonChiTietDTO> findById(Integer id);
    List<HoaDonChiTietDTO> getAll();
    List<HoaDonDTO> searchHoaDon(String name  , Integer status);
    List<HoaDonDTO> searchHoaDonbyStatus( Integer status);

}
