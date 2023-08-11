package com.example.assignment.reponsitory;

import com.example.assignment.entity.KhachHang;
import com.example.assignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository  extends JpaRepository<KhachHang,Integer> {

    @Query(value = "select u from KhachHang u where u.email = :email")
    public KhachHang findByEmail(@Param("email") String email);
}
