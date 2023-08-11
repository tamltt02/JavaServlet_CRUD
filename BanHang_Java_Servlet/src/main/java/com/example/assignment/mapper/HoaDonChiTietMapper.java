package com.example.assignment.mapper;

import com.example.assignment.dto.HoaDonChiTietDTO;
import com.example.assignment.dto.HoaDonDTO;
import com.example.assignment.entity.HoaDon;
import com.example.assignment.entity.HoaDonChiTiet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoaDonChiTietMapper {

    @Autowired
    private ModelMapper modelMapper ;

    public HoaDonChiTiet convertToEntity(HoaDonChiTietDTO hoaDonChiTietDTO) {
        HoaDonChiTiet hoaDonChiTiet = modelMapper.map(hoaDonChiTietDTO, HoaDonChiTiet.class);
        return hoaDonChiTiet;
    }
    public  HoaDonChiTietDTO convertToDTO (HoaDonChiTiet hoaDonChiTiet){
        HoaDonChiTietDTO hoaDonChiTietDTO = modelMapper.map(hoaDonChiTiet, HoaDonChiTietDTO.class);
        return hoaDonChiTietDTO;
    }
}
