package com.poly.service.impl;

import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.poly.entity.User;
import com.poly.mapper.UserMapper;
import com.poly.model.UserDTO;
import com.poly.model.UserDTOForm;
import com.poly.model.UserDTORegister;
import com.poly.model.UserDTOchangeInfor;
import com.poly.repository.IUserRepository;
import com.poly.service.IUserService;
import com.poly.utils.BcryptPassword;
@Service
public class UserServiceIpml implements IUserService {
	
	@Autowired
	private IUserRepository repository;
	@Autowired
	private UserMapper mapper;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private BcryptPassword bcrypt;
	@Override
	public Page<UserDTO> getPage(String direction, String fiel, Integer page, String name) {
		fiel = fiel != null ? fiel : "id";
		page = page != null ? page -1 : 0;
		Sort sort = (direction == null || direction.equals("asc")) ? 
				Sort.by(Direction.ASC, fiel) : Sort.by(Direction.DESC, fiel);
		Pageable pageable = PageRequest.of(page, 5, sort);
		Page<User> pageData = this.repository.findByName(name == null ? "" : name, pageable);
		return pageData.map(t -> mapper.convertToDto(t));
	}
	@Override
	public UserDTOForm insert(UserDTOForm dto) {
		User u = this.mapper.convertToEntityForm(dto);
		u.setId(null);
		u.setPassword(this.bcrypt.encrypt(u.getPassword()));
		u = this.repository.save(u);
		request.getSession().setAttribute("message", "Thêm Thành Công");
		return mapper.convertToDTOForm(u);
	}
	@Override
	public UserDTOForm findbyID(Integer id) {
		Optional<User> u =  this.repository.findById(id);
		UserDTOForm dto = mapper.convertToDTOForm(u.get());
		return dto;
	}
	@Override
	public UserDTOForm update(UserDTOForm dto) {
		User u = this.mapper.convertToEntityForm(dto);
		if(this.repository.findById(u.getId()) != null ) {
			u.setEmail(this.repository.findById(dto.getId()).get().getEmail());
			u = this.repository.save(u);
			
			request.getSession().setAttribute("message", "Update Thành Công");
			return mapper.convertToDTOForm(u);
		}
		return null;
	}
	@Override
	public UserDTO delete(Integer id) {
		Optional<User> u = this.repository.findById(id);
		if(u.isPresent()) {
			this.repository.deleteById(id);
			request.getSession().setAttribute("message", "Xóa thành công");
			return mapper.convertToDto(u.get());
		}
		return null;
	}
	@Override
	public UserDTO checklogin(String email, String password, boolean remember) {
		User u = this.repository.findByEmail(email);
		if(u != null) {
			if(bcrypt.checkPassword(password, u.getPassword())) {
				request.getSession().setAttribute("user", u);
							return mapper.convertToDto(u);
			}else {
				this.request.getSession().setAttribute("message","Email hoac mat khau không chính xác" );
			}
		}else {
			this.request.getSession().setAttribute("message","Email hoac mat khau không chính xác" );
		}
		return null;
	}
	@Override
	public boolean checkCartLogin() {
		User u = (User)this.request.getSession().getAttribute("user");
		return u == null ? false : true;
	}
	@Override
	public UserDTORegister register(UserDTORegister dto) {
		User u = this.mapper.convertToEntityRegister(dto);
		u.setId(null);
		u.setPassword(this.bcrypt.encrypt(u.getPassword()));
		u = this.repository.save(u);
		request.getSession().setAttribute("message", "Thêm Thành Công");
		return mapper.convertToDTOregister(u);
		
	}
	@Override
	public boolean checkEmail(String email) {
		User u  = this.repository.findByEmail(email);
		User user = (User)this.request.getSession().getAttribute("user");
		return (u == null  || u.getEmail().equals(user.getEmail())) ? true :false;
	}
	@Override
	public boolean checkEmailforgot(String email) {
		User u  = this.repository.findByEmail(email);
		return u == null  ? true :false;
	}
	@Override
	public boolean checkPassword(String password) {
		User u = (User)this.request.getSession().getAttribute("user");
		
		return this.bcrypt.checkPassword(password, u.getPassword());
	}
	@Override
	public void logout() {
		this.request.getSession().removeAttribute("user");
		
	}
	@Override
	public UserDTO changePassword(String password) {
		User u = (User)this.request.getSession().getAttribute("user");
		u.setPassword(this.bcrypt.encrypt(password));
		u = this.repository.save(u);
		this.request.getSession().setAttribute("user", u);
		System.out.println("Thanh cong");
		return mapper.convertToDto(u);
	}
	@Override
	public UserDTOchangeInfor getUser() {
		User u = (User)this.request.getSession().getAttribute("user");
		
		return mapper.convertToDTOchange(u);
	}
	@Override
	public UserDTOchangeInfor changInfor(UserDTOchangeInfor dto) {
		User u = (User)this.request.getSession().getAttribute("user");
		u.setAddress(dto.getAddress());
		u.setEmail(dto.getEmail());
		u.setSdt(dto.getSdt());
		u.setUsername(dto.getUsername());
		if(u.getId() != null)
		u = this.repository.save(u);
	request.getSession().setAttribute("user", u);
		return null;
	}
	@Override
	public String getPasswordForgot(String email) {
		User u = this.repository.findByEmail(email);
	    Random random = new Random();
	    int newPass =  random.nextInt(10000);
	    u.setPassword(this.bcrypt.encrypt(newPass+""));
	    this.repository.save(u);
	    System.out.println(newPass+"");
		return newPass+"";
	}

}
