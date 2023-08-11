package com.poly.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Category;
public interface ICategoryRepositoty extends JpaRepository<Category, Integer> {
  @Query("select c from Category c where c.name like %:name%")
   public Page<Category> findByName(@Param("name") String name,Pageable pageable);
  

}
