package com.example.assignment.reponsitory;

import com.example.assignment.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham,Integer> {

    @Query(value = "SELECT  * FROM chi_tiet_san_pham ORDER BY chi_tiet_san_pham.id DESC LIMIT 2",nativeQuery = true)
    List<ChiTietSanPham> getCTSPnew();

    @Query("Select c from ChiTietSanPham c  where c.dongSanPham.ten like %:dongsp%")
    public Page<ChiTietSanPham> findProductByCategory(@Param("dongsp") String dongsp, Pageable pageable);

    //SELECT hoa_don_chi_tiet.hoadonchitiet_chitietsanpham, SUM(hoa_don_chi_tiet.so_luong) FROM `hoa_don_chi_tiet`
    //  group by hoa_don_chi_tiet.hoadonchitiet_chitietsanpham ORDER BY  SUM(hoa_don_chi_tiet.so_luong) DESC LIMIT 6
    @Query(value = "SELECT h.chiTietSanPham  FROM HoaDonChiTiet h " +
            "group by h.chiTietSanPham.id  ORDER BY  SUM(h.soLuong) DESC")
    List<ChiTietSanPham> getCTSPchay();


}
