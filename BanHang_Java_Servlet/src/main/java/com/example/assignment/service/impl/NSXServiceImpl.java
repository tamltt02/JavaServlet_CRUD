package com.example.assignment.service.impl;

import com.example.assignment.dto.MauSacDTO;
import com.example.assignment.dto.NSXDTO;
import com.example.assignment.entity.MauSac;
import com.example.assignment.entity.NSX;
import com.example.assignment.mapper.NSXMapper;
import com.example.assignment.reponsitory.NSXRepository;
import com.example.assignment.service.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NSXServiceImpl implements NSXService {

    @Autowired
    NSXRepository nsxRepository;

    @Autowired
    NSXMapper mapper;
    @Override
    public List<NSXDTO> getAll() {
        List<NSX> list = nsxRepository.findAll();
        List<NSXDTO> listDTO = new ArrayList<>();
        for (NSX nsx : list){
            listDTO.add(mapper.convertToDTO(nsx));
        }
        return listDTO;
    }
}
