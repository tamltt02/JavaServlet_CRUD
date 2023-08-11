package com.example.assignment.mapper;

import com.example.assignment.dto.SanPhamDTO;
import com.example.assignment.entity.SanPham;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SanPhamMapper {
    @Autowired
    private ModelMapper modelMapper ;

    public SanPham convertToEntity(SanPhamDTO sanPhamDTO) {
        SanPham sanPham = modelMapper.map(sanPhamDTO, SanPham.class);
        return sanPham;
    }
    public  SanPhamDTO convertToDTO (SanPham sanPham){
        SanPhamDTO sanPhamDTO = modelMapper.map(sanPham, SanPhamDTO.class);
        return sanPhamDTO;
    }

}
