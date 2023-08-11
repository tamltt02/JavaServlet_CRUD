package com.example.assignment.mapper;

import com.example.assignment.dto.HoaDonDTO;
import com.example.assignment.entity.HoaDon;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoaDonMapper {
    @Autowired
    private ModelMapper modelMapper ;

    public HoaDon convertToEntity(HoaDonDTO hoaDonDTO) {
        HoaDon hoaDon = modelMapper.map(hoaDonDTO, HoaDon.class);
        return hoaDon;
    }
    public  HoaDonDTO convertToDTO (HoaDon hoaDon){
        HoaDonDTO hoaDonDTO = modelMapper.map(hoaDon, HoaDonDTO.class);
        return hoaDonDTO;
    }
}
