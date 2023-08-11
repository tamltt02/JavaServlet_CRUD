package com.poly.service;

import org.springframework.data.domain.Page;


import com.poly.model.UserDTO;
import com.poly.model.UserDTOForm;
import com.poly.model.UserDTORegister;
import com.poly.model.UserDTOchangeInfor;

public interface IUserService  {
     Page<UserDTO> getPage(String direction,String fiel,Integer page,String name);
     UserDTOForm insert(UserDTOForm dto);
     UserDTOForm update(UserDTOForm dto);
     UserDTOForm findbyID(Integer id); 
     UserDTO delete(Integer id);
     UserDTO checklogin(String email,String password,boolean remember);
     UserDTORegister register(UserDTORegister dto);
     boolean checkCartLogin();
     boolean checkEmail(String email);
     boolean checkPassword(String password);
     UserDTO changePassword(String password);
     void logout();
     UserDTOchangeInfor getUser();
     UserDTOchangeInfor changInfor(UserDTOchangeInfor dto);
     public boolean checkEmailforgot(String email);
     public String getPasswordForgot(String email);
}
