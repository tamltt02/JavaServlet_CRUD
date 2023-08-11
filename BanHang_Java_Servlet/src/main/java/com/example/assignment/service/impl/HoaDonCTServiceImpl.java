package com.example.assignment.service.impl;


import com.example.assignment.dto.ChiTietSanPhamDTO;
import com.example.assignment.dto.HoaDonChiTietDTO;
import com.example.assignment.dto.HoaDonDTO;
import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.entity.HoaDon;
import com.example.assignment.entity.HoaDonChiTiet;
import com.example.assignment.mapper.HoaDonChiTietMapper;
import com.example.assignment.mapper.HoaDonMapper;
import com.example.assignment.reponsitory.HoaDonCTRepository;
import com.example.assignment.reponsitory.HoaDonRepository;
import com.example.assignment.service.HoaDonCTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HoaDonCTServiceImpl implements HoaDonCTService {
    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    HoaDonCTRepository hoaDonCTRepository;
    @Autowired
    HoaDonChiTietMapper mapper;

    @Autowired
    HoaDonMapper hoaDonMapper;

    @Override
    public List<HoaDonChiTietDTO> findById(Integer id) {
        List<HoaDonChiTiet> list = this.hoaDonCTRepository.findHoaDonCTById(id);
        List<HoaDonChiTietDTO> listDTO = new ArrayList<>();
        for (HoaDonChiTiet hoaDon : list) {
            listDTO.add(mapper.convertToDTO(hoaDon));
        }
        return listDTO;
    }

    @Override
    public List<HoaDonChiTietDTO> getAll() {
        List<HoaDonChiTiet> list = hoaDonCTRepository.findAll();
        List<HoaDonChiTietDTO> listDTO = new ArrayList<>();
        for (HoaDonChiTiet hoaDon : list) {
            listDTO.add(mapper.convertToDTO(hoaDon));
        }
        return listDTO;
    }

    @Override
    public List<HoaDonDTO> searchHoaDon(String name, Integer status) {
        List<HoaDon> list = hoaDonRepository.findHoaDonBy(name, status);
        List<HoaDonDTO> listDTO = new ArrayList<>();
        for (HoaDon hoaDon : list) {
            listDTO.add(hoaDonMapper.convertToDTO(hoaDon));
        }
        return listDTO;
    }

    @Override
    public List<HoaDonDTO> searchHoaDonbyStatus(Integer status) {
        List<HoaDon> list = hoaDonRepository.findHoaDonBystatus( status);
        List<HoaDonDTO> listDTO = new ArrayList<>();
        for (HoaDon hoaDon : list) {
            listDTO.add(hoaDonMapper.convertToDTO(hoaDon));
        }
        return listDTO;
    }
}
