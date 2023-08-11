package com.poly.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.User;


public interface IUserRepository extends JpaRepository<User,Integer>{
	@Query("Select u from User u where u.username like %:name%")
	Page<User> findByName(@Param("name") String name, Pageable pageable);
	
	@Query("Select u from User u where u.email = :email")
	User findByEmail(@Param("email")String email);
	
	
}
