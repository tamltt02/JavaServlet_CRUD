package com.example.assignment.service.impl;

import com.example.assignment.dto.DongSanPhamDTO;
import com.example.assignment.dto.SanPhamDTO;
import com.example.assignment.entity.DongSanPham;
import com.example.assignment.entity.SanPham;
import com.example.assignment.mapper.DongSanPhamMapper;
import com.example.assignment.reponsitory.DongSanPhamRepository;
import com.example.assignment.service.DongSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DongSanPhamServiceImpl implements DongSanPhamService {
   @Autowired
    DongSanPhamRepository dongSanPhamRepository;

   @Autowired
    DongSanPhamMapper mapper;
    @Override
    public List<DongSanPhamDTO> getAll() {
        List<DongSanPham> list = dongSanPhamRepository.findAll();
        List<DongSanPhamDTO> listDTO = new ArrayList<>();
        for (DongSanPham dongSanPham : list){
            listDTO.add(mapper.convertToDTO(dongSanPham));
        }
        return listDTO;
    }
}
