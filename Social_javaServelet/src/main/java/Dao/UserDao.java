package Dao;

import java.util.List;
import java.util.Map;

import Entitty.User;

public interface UserDao {
	User findById(Integer id);
	User findByEmail(String email);
	User findByUsername(String username);
	User findByUsernameandPass(String username, String passwword);
	List<User> findAll ();
	List<User> findAll (int pageNumber, int pageSize);
	User create(User entity);
	User update(User entity);
	User delete(User entity);
	List<User> findUserByVideoHref ( Map<String, Object> params);
	
}
