package com.example.assignment.mapper;

import com.example.assignment.dto.NSXDTO;
import com.example.assignment.entity.NSX;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NSXMapper {

    @Autowired
    private ModelMapper modelMapper ;

    public NSX convertToEntity(NSXDTO nsxdto) {
        NSX nsx = modelMapper.map(nsxdto, NSX.class);
        return nsx;
    }
    public  NSXDTO convertToDTO (NSX nsx){
        NSXDTO nsxdto = modelMapper.map(nsx, NSXDTO.class);
        return nsxdto;
    }
}
