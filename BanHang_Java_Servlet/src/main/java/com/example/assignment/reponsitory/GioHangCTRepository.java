package com.example.assignment.reponsitory;

import com.example.assignment.entity.DongSanPham;
import com.example.assignment.entity.GioHang;
import com.example.assignment.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangCTRepository  extends JpaRepository<GioHangChiTiet,Integer> {

    @Query(value = "select g from GioHangChiTiet g where g.chiTietSanPham.id = :id")
    GioHangChiTiet findGioiHangBySP(@Param("id") Integer id);
}
