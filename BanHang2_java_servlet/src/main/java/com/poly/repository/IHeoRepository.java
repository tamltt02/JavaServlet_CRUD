package com.poly.repository;



import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Heo;

public interface IHeoRepository extends JpaRepository<Heo, Integer> {
   @Query("Select p from Heo p where p.name like %:name%")
   public Page<Heo> getByName(@Param("name") String name,Pageable pageble);
   @Query("Select p from Heo p where p.quantity > 0  Order By p.id desc ")
   public List<Heo> getRecent(Pageable pageable);
   @Query("Select p from Heo p  where p.price between :min and :max")
   public Page<Heo> findPrice(@Param("min") BigDecimal min,@Param("max") BigDecimal max,Pageable pageable);
   @Query("Select p from Heo p  where p.category.name like %:category%")
   public List<Heo> findProductByCategory(@Param("category") String category);
}
