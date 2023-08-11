package com.example.assignment.mapper;

import com.example.assignment.dto.KhachHangDTO;
import com.example.assignment.dto.KhachHangDTOForm;
import com.example.assignment.dto.MauSacDTO;
import com.example.assignment.entity.KhachHang;
import com.example.assignment.entity.MauSac;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangMapper {
    @Autowired
    private ModelMapper modelMapper ;

    public KhachHang convertToEntity(KhachHangDTO khachHangDTO) {
        KhachHang khachHang = modelMapper.map(khachHangDTO, KhachHang.class);
        return khachHang;
    }
    public  KhachHangDTO convertToDTO (KhachHang khachHang){
        KhachHangDTO khachHangDTO = modelMapper.map(khachHang, KhachHangDTO.class);
        return khachHangDTO;
    }

    public KhachHangDTOForm convertToDTOform (KhachHangDTO khachHangDTO){
        KhachHangDTOForm khachHangDTOForm = modelMapper.map(khachHangDTO, KhachHangDTOForm.class);
        return khachHangDTOForm;
    }
    public KhachHangDTO convertToDTOform (KhachHangDTOForm khachHangDTOForm){
        KhachHangDTO khachHangDTO = modelMapper.map(khachHangDTOForm, KhachHangDTO.class);
        return khachHangDTO;
    }
}
