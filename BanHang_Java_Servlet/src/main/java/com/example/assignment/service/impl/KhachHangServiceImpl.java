package com.example.assignment.service.impl;

import com.example.assignment.dto.KhachHangDTO;
import com.example.assignment.entity.KhachHang;
import com.example.assignment.entity.User;
import com.example.assignment.mapper.KhachHangMapper;
import com.example.assignment.mapper.UserMapper;
import com.example.assignment.reponsitory.KhachHangRepository;
import com.example.assignment.reponsitory.UserRepository;
import com.example.assignment.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    KhachHangRepository khachHangRepository;

    @Autowired
    KhachHangMapper khachHangMapper;

    @Autowired
    HttpServletRequest request;
    @Override
    public KhachHangDTO add(KhachHangDTO khachHangDTO) {
        KhachHang khachHang = khachHangMapper.convertToEntity(khachHangDTO);
        khachHang = khachHangRepository.save(khachHang);
        return khachHangMapper.convertToDTO(khachHang);
    }

    @Override
    public KhachHangDTO update(KhachHangDTO khachHangDTO) {
        khachHangRepository.save(khachHangMapper.convertToEntity(khachHangDTO));
        return khachHangDTO;
    }

    @Override
    public KhachHangDTO findByEmail(String email) {
        KhachHang khachHang = khachHangRepository.findByEmail(email);
        if(khachHang == null){
            return null ;
        }
        return khachHangMapper.convertToDTO(khachHang);
    }
}
