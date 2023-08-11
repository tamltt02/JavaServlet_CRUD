package com.example.assignment.service.impl;

import com.example.assignment.dto.ChiTietSanPhamDTO;
import com.example.assignment.dto.MauSacDTO;
import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.entity.MauSac;
import com.example.assignment.mapper.MauSacMapper;
import com.example.assignment.reponsitory.MauSacRepository;
import com.example.assignment.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MauSacServiceImpl  implements MauSacService {

   @Autowired
    MauSacRepository mauSacRepository;

   @Autowired
    MauSacMapper mapper;
    @Override
    public List<MauSacDTO> getAll() {
        List<MauSac> list = mauSacRepository.findAll();
        List<MauSacDTO> listDTO = new ArrayList<>();
        for (MauSac mauSac : list){
            listDTO.add(mapper.convertToDTO(mauSac));
        }
        return listDTO;
    }
}
