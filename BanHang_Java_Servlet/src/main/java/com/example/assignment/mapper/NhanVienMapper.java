package com.example.assignment.mapper;

import com.example.assignment.dto.NhanVienDTO;
import com.example.assignment.entity.NhanVien;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienMapper {
    @Autowired
    private ModelMapper modelMapper ;

    public NhanVien convertToEntity(NhanVienDTO nhanVienDTO) {
        NhanVien nhanVien = modelMapper.map(nhanVienDTO, NhanVien.class);
        return nhanVien;
    }
    public  NhanVienDTO convertToDTO (NhanVien nhanVien){
        NhanVienDTO nhanVienDTO = modelMapper.map(nhanVien, NhanVienDTO.class);
        return nhanVienDTO;
    }
}


