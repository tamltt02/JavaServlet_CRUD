package com.example.assignment.mapper;

import com.example.assignment.dto.GioHangChiTietDTO;
import com.example.assignment.entity.GioHangChiTiet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GioHangChiTietMapper {
    @Autowired
    private ModelMapper modelMapper ;

    public GioHangChiTiet convertToEntity(GioHangChiTietDTO gioHangChiTietDTO) {
        GioHangChiTiet gioHangChiTiet = modelMapper.map(gioHangChiTietDTO, GioHangChiTiet.class);
        return gioHangChiTiet;
    }
    public  GioHangChiTietDTO convertToDTO (GioHangChiTiet gioHangChiTiet){
        GioHangChiTietDTO gioHangChiTietDTO = modelMapper.map(gioHangChiTiet, GioHangChiTietDTO.class);
        return gioHangChiTietDTO;
    }
}
