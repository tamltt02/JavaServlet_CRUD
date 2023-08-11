package com.example.assignment.reponsitory;

import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.entity.HoaDon;
import com.example.assignment.entity.HoaDonChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonCTRepository  extends JpaRepository<HoaDonChiTiet,Integer> {
    @Query( value = "select h from HoaDonChiTiet h where (:name is null or h.hoaDon.ma = :name) or (:name is null or h.hoaDon.nhanVien.hoTen like :name) or (:name is null or h.hoaDon.khachHang.hoTen like :name) " +
            "and (:status is null or h.hoaDon.tinhTrang = :status)")
    List<HoaDonChiTiet> findHoaDonCTBy(@Param("name") String name, @Param("status") Integer status);

    @Query( value = "select h from HoaDonChiTiet h where h.hoaDon.tinhTrang = :status")
    List<HoaDonChiTiet> findHoaDonCTBystatus( @Param("status") Integer status);

    @Query( value = "select h from HoaDonChiTiet h where h.hoaDon.id = :id")
    List<HoaDonChiTiet> findHoaDonCTById( @Param("id") Integer id);
}
