package com.example.assignment.service;

import com.example.assignment.dto.DongSanPhamDTO;
import com.example.assignment.entity.DongSanPham;
import com.example.assignment.entity.NSX;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DongSanPhamService {
    List<DongSanPhamDTO> getAll();
}
