package com.example.assignment.mapper;

import com.example.assignment.dto.CuaHangDTO;
import com.example.assignment.entity.CuaHang;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuaHangMapper {
    @Autowired
    private ModelMapper modelMapper ;

    public CuaHang convertToEntity(CuaHangDTO cuaHangDTO) {
        CuaHang cuaHang = modelMapper.map(cuaHangDTO, CuaHang.class);
        return cuaHang;
    }
    public  CuaHangDTO convertToDTO (CuaHang cuaHang){
        CuaHangDTO cuaHangDTO = modelMapper.map(cuaHang, CuaHangDTO.class);
        return cuaHangDTO;
    }
}
