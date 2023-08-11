package com.example.assignment.service;

import com.example.assignment.dto.KhachHangDTO;
import com.example.assignment.dto.UserDTO;

public interface KhachHangService {


    KhachHangDTO add(KhachHangDTO khachHangDTO);
    KhachHangDTO update(KhachHangDTO khachHangDTO);

    KhachHangDTO findByEmail(String email);
}
