package com.example.assignment.mapper;

import com.example.assignment.dto.MauSacDTO;
import com.example.assignment.entity.MauSac;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MauSacMapper {

    @Autowired
    private ModelMapper modelMapper ;

    public MauSac convertToEntity(MauSacDTO mauSacDTO) {
        MauSac mauSac = modelMapper.map(mauSacDTO, MauSac.class);
        return mauSac;
    }
    public  MauSacDTO convertToDTO (MauSac mauSac){
        MauSacDTO mauSacDTO = modelMapper.map(mauSac, MauSacDTO.class);
        return mauSacDTO;
    }
}
