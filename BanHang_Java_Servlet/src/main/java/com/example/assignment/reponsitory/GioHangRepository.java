package com.example.assignment.reponsitory;

import com.example.assignment.entity.DongSanPham;
import com.example.assignment.entity.GioHang;
import com.example.assignment.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GioHangRepository  extends JpaRepository<GioHang,Integer> {

    @Query(value = "select g from GioHangChiTiet g where g.gioHang.khachHang.id = :id")
    List<GioHangChiTiet> getGioHangByUser( @Param("id") Integer id);

    @Query(value = "select g from GioHang g where g.khachHang.id = :id")
    GioHang findGioiHangByUser( @Param("id") Integer id);
}
