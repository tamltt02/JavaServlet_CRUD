package com.example.assignment.service.impl;

import com.example.assignment.dto.SanPhamDTO;
import com.example.assignment.entity.SanPham;
import com.example.assignment.mapper.SanPhamMapper;
import com.example.assignment.reponsitory.SanPhamRepository;
import com.example.assignment.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepository sanPhamRepository;


    @Autowired
    SanPhamMapper mapper;
    @Override
    public List<SanPhamDTO> getAll()
    {
        List<SanPham> list = sanPhamRepository.findAll();
        List<SanPhamDTO> listDTO = new ArrayList<>();
        for (SanPham sanPham : list){
            listDTO.add(mapper.convertToDTO(sanPham));
        }
        return listDTO;
    }
}
