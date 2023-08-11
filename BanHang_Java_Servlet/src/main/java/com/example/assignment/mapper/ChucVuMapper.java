package com.example.assignment.mapper;

import com.example.assignment.dto.ChucVuDTO;
import com.example.assignment.entity.ChucVu;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChucVuMapper {
    @Autowired
    private ModelMapper modelMapper ;

    public ChucVu convertToEntity(ChucVuDTO chucVuDTO) {
        ChucVu chucVu = modelMapper.map(chucVuDTO, ChucVu.class);
        return chucVu;
    }
    public  ChucVuDTO convertToDTO (ChucVu chucVu){
        ChucVuDTO chucVuDTO = modelMapper.map(chucVu, ChucVuDTO.class);
        return chucVuDTO;
    }
}
