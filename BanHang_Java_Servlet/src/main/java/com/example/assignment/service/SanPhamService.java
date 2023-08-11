package com.example.assignment.service;

import com.example.assignment.dto.SanPhamDTO;
import com.example.assignment.entity.NSX;
import com.example.assignment.entity.SanPham;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SanPhamService {

    List<SanPhamDTO> getAll();
}
