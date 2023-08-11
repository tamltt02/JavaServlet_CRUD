package com.example.assignment.service;

import com.example.assignment.dto.UserDTO;

public interface UserService {

    UserDTO add(UserDTO userDTO);
    UserDTO update(UserDTO userDTO);

    UserDTO findByEmail(String email);
}

