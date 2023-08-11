package com.example.assignment.mapper;

import com.example.assignment.dto.CuaHangDTO;
import com.example.assignment.dto.DongSanPhamDTO;
import com.example.assignment.entity.CuaHang;
import com.example.assignment.entity.DongSanPham;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DongSanPhamMapper {
    @Autowired
    private ModelMapper modelMapper ;

    public DongSanPham convertToEntity(DongSanPhamDTO dongSanPhamDTO) {
        DongSanPham dongSanPham = modelMapper.map(dongSanPhamDTO, DongSanPham.class);
        return dongSanPham;
    }
    public  DongSanPhamDTO convertToDTO (DongSanPham dongSanPham){
        DongSanPhamDTO dongSanPhamDTO = modelMapper.map(dongSanPham, DongSanPhamDTO.class);
        return dongSanPhamDTO;
    }
}
