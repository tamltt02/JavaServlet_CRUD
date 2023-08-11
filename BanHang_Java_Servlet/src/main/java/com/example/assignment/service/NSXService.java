package com.example.assignment.service;

import com.example.assignment.dto.NSXDTO;
import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.entity.NSX;

import java.util.List;

public interface NSXService {
    List<NSXDTO> getAll();
}
