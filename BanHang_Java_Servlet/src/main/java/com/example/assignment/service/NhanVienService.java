package com.example.assignment.service;

import com.example.assignment.dto.KhachHangDTO;
import com.example.assignment.dto.NhanVienDTO;

public interface NhanVienService {
    NhanVienDTO findByEmail(String email,String pass);

}
