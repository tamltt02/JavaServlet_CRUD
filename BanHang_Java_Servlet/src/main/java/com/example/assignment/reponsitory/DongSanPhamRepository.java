package com.example.assignment.reponsitory;

import com.example.assignment.entity.DongSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DongSanPhamRepository extends JpaRepository<DongSanPham,Integer> {
}
