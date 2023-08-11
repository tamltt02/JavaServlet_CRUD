package com.example.assignment.mapper;

import com.example.assignment.dto.ChiTietSanPhamDTO;
import com.example.assignment.dto.ChiTietSanPhamDTOForm;
import com.example.assignment.entity.ChiTietSanPham;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChiTietSanPhamMapper {
    @Autowired
    private ModelMapper mapper;

    public ChiTietSanPham convertToEntity(ChiTietSanPhamDTO chiTietSanPhamDTO) {
        ChiTietSanPham chiTietSanPham = mapper.map(chiTietSanPhamDTO, ChiTietSanPham.class);
        return chiTietSanPham;
    }
    public  ChiTietSanPhamDTO convertToDTO (ChiTietSanPham chiTietSanPham){
        ChiTietSanPhamDTO chiTietSanPhamDTO = mapper.map(chiTietSanPham, ChiTietSanPhamDTO.class);
        return chiTietSanPhamDTO;
    }

    public ChiTietSanPham convertToEntityForm(ChiTietSanPhamDTOForm dto) {
        ChiTietSanPham p = mapper.map(dto, ChiTietSanPham.class);
        p.setMoTa(dto.getMoTa().getOriginalFilename());
        return p;
    }
}
