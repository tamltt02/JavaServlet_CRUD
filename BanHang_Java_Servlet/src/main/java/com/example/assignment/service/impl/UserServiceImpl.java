package com.example.assignment.service.impl;

import com.example.assignment.dto.UserDTO;
import com.example.assignment.entity.User;
import com.example.assignment.mapper.UserMapper;
import com.example.assignment.reponsitory.UserRepository;
import com.example.assignment.service.UserService;
import com.example.assignment.utils.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;
    @Autowired
    HttpServletRequest request;

    @Override
    public UserDTO add(UserDTO userDTO) {
        User user = userMapper.convertToEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.convertToDTO(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        userRepository.save(userMapper.convertToEntity(userDTO));
        return userDTO;
    }

    @Override
    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return userMapper.convertToDTO(user);
    }

    public UserDTO changepass(String pass) {
        UserDTO userDTO = new UserDTO();
        userDTO.setPassword(pass);
        userRepository.save(userMapper.convertToEntity(userDTO));
        return userDTO;
    }

}
