package com.example.assignment.mapper;

import com.example.assignment.dto.SanPhamDTO;
import com.example.assignment.dto.UserDTO;
import com.example.assignment.entity.SanPham;
import com.example.assignment.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper ;

    public User convertToEntity(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }
    public  UserDTO convertToDTO (User user){
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }
}
