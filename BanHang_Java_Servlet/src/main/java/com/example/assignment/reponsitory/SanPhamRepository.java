package com.example.assignment.reponsitory;

import com.example.assignment.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository  extends JpaRepository<SanPham,Integer> {
}
