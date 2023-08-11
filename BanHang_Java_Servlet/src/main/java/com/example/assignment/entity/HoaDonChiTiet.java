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
@Table(name = "hoa_don_chi_tiet")
public class HoaDonChiTiet {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id ;

        @Column(name = "so_luong")
        private Integer soLuong ;

        @Column(name = "don_gia")
        private double donGia ;

        @ManyToOne()
        @JoinColumn(name = "hoadonchitiet_hoadon")
        private HoaDon hoaDon ;

        @ManyToOne()
        @JoinColumn(name = "hoadonchitiet_chitietsanpham")
        private ChiTietSanPham chiTietSanPham ;
        }
