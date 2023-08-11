package com.example.assignment.reponsitory;

import com.example.assignment.entity.KhachHang;
import com.example.assignment.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository  extends JpaRepository<NhanVien,Integer> {

    @Query(value = "select u from NhanVien u where u.email = :email and u.matKhau = :pass ")
    public NhanVien findByEmail(@Param("email") String email, @Param("pass") String pass);
}
