package com.example.assignment.service;

import com.example.assignment.dto.ChiTietSanPhamDTO;
import com.example.assignment.dto.HoaDonChiTietDTO;
import com.example.assignment.dto.HoaDonDTO;
import com.example.assignment.entity.HoaDon;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface HoaDonService {

    List<HoaDonDTO> getAll();
    Page<HoaDonDTO> getSanPhamDTO(Integer pageNo, Integer size);
    List<HoaDonDTO> searchHoaDon(String name  , Integer status);
  void  addHoaDon();
}
