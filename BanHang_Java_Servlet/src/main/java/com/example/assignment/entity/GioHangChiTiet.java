package com.example.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gio_hang_chi_tiet")
public class GioHangChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "so_luong")
    private Integer soLuong ;

    @Column(name = "don_gia")
    private double donGia ;

    @Column(name = "don_gia_khi_gia")
    private double donGiaKhiGia ;

    @ManyToOne()
    @JoinColumn(name = "giohangchitiet_giohang")
    private GioHang gioHang ;

    @ManyToOne()
    @JoinColumn(name = "giohangchitiet_chitietsanpham")
    private ChiTietSanPham chiTietSanPham ;
}

