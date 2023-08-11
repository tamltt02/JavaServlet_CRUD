package com.example.assignment.mapper;

import com.example.assignment.dto.GioHangChiTietDTO;
import com.example.assignment.dto.GioHangDTO;
import com.example.assignment.entity.GioHang;
import com.example.assignment.entity.GioHangChiTiet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GioHangMapper {
    @Autowired
    private ModelMapper modelMapper ;

    public GioHang convertToEntity(GioHangDTO gioHangDTO) {
        GioHang gioHang = modelMapper.map(gioHangDTO, GioHang.class);
        return gioHang;
    }
    public  GioHangDTO convertToDTO (GioHang gioHang){
        GioHangDTO gioHangDTO = modelMapper.map(gioHang, GioHangDTO.class);
        return gioHangDTO;
    }
}
