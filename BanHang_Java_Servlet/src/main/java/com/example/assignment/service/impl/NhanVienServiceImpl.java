package com.example.assignment.service.impl;

import com.example.assignment.dto.NhanVienDTO;
import com.example.assignment.entity.NhanVien;
import com.example.assignment.mapper.NhanVienMapper;
import com.example.assignment.reponsitory.NhanVienRepository;
import com.example.assignment.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Autowired
    NhanVienMapper nhanVienMapper ;
    @Override
    public NhanVienDTO findByEmail(String email,String pass) {
        NhanVien nhanVien = nhanVienRepository.findByEmail(email,pass);
        if(nhanVien == null){
            return null ;
        }
        return nhanVienMapper.convertToDTO(nhanVien);
    }
}
