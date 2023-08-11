package com.poly.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.entity.User;
import com.poly.model.UserDTO;
import com.poly.model.UserDTOForm;
import com.poly.model.UserDTORegister;
import com.poly.model.UserDTOchangeInfor;

@Service
public class UserMapper {
	@Autowired
	private ModelMapper mapper;
	
     public User convertToEntity(UserDTO dto) {
    	 User u = mapper.map(dto, User.class);
    	 return u;
     }
     public UserDTO convertToDto(User u) {
    	 UserDTO dto = mapper.map(u, UserDTO.class);
    	 return dto;
     }
     public User convertToEntityForm(UserDTOForm dto) {
    	 User u = mapper.map(dto, User.class);
    	 return u;
     }
     public UserDTOForm convertToDTOForm(User u) {
    	 UserDTOForm dto = mapper.map(u, UserDTOForm.class);
    	 return dto;
     }
     public User convertToEntityRegister(UserDTORegister dto) {
    	 User u = mapper.map(dto, User.class);
    	 return u;
     }
     public UserDTORegister convertToDTOregister(User u) {
    	 UserDTORegister dto = mapper.map(u, UserDTORegister.class);
    	 return dto;
     }
     public User convertToEntitychange(UserDTOchangeInfor dto) {
    	 User u = mapper.map(dto, User.class);
    	 return u;
     }
     public UserDTOchangeInfor convertToDTOchange(User u) {
    	 UserDTOchangeInfor dto = mapper.map(u, UserDTOchangeInfor.class);
    	 return dto;
     } 
     
     
}
