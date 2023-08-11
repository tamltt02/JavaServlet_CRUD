package com.example.assignment.service.impl;

import com.example.assignment.dto.ChiTietSanPhamDTO;
import com.example.assignment.dto.GioHangChiTietDTO;
import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.entity.GioHangChiTiet;
import com.example.assignment.mapper.ChiTietSanPhamMapper;
import com.example.assignment.mapper.GioHangChiTietMapper;
import com.example.assignment.mapper.GioHangMapper;
import com.example.assignment.mapper.NhanVienMapper;
import com.example.assignment.reponsitory.ChiTietSanPhamRepository;
import com.example.assignment.reponsitory.GioHangCTRepository;
import com.example.assignment.reponsitory.GioHangRepository;
import com.example.assignment.reponsitory.NhanVienRepository;
import com.example.assignment.service.ChiTietSPService;
import com.example.assignment.service.GioHangCTService;
import com.example.assignment.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class GioHangCTServiceImpl implements GioHangCTService {
    @Autowired
    GioHangRepository gioHangRepository;

    @Autowired
    NhanVienRepository nhanVienRepository;
   @Autowired
   ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Autowired
    GioHangChiTietMapper mapper;
    @Autowired
    NhanVienMapper nhanVienMapper;
    @Autowired
    GioHangMapper gioHangMapper;
    @Autowired
    GioHangCTRepository gioHangCTRepository;

    @Autowired
    ChiTietSPService chiTietSPService;

    @Autowired
    ChiTietSanPhamMapper chiTietSanPhamMapper;
    @Autowired
    HttpServletRequest request;

    @Override
    public GioHangChiTietDTO tangSoLuong(Integer idsp, Integer soLuong) {
        HttpSession session = request.getSession();
        GioHangChiTiet gioHangChiTiet = gioHangCTRepository.findGioiHangBySP(idsp);
        gioHangChiTiet.setSoLuong(soLuong);
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(idsp).get();
        if(chiTietSanPham.getSoLuongTon() - soLuong < 0 ){
            session.setAttribute("hethang","Quá số lượng ");
            return null;
        }
        chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon() - 1);
        return mapper.convertToDTO(gioHangCTRepository.save(gioHangChiTiet));

    }
    @Override
    public GioHangChiTietDTO giamSoLuong(Integer idsp, Integer soLuong) {
        HttpSession session = request.getSession();
        GioHangChiTiet gioHangChiTiet = gioHangCTRepository.findGioiHangBySP(idsp);
        gioHangChiTiet.setSoLuong(soLuong);
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(idsp).get();
//        if(chiTietSanPham.getSoLuongTon() - soLuong < 0 ){
//            session.setAttribute("error","Quá số lượng ");
//            return null;
//        }
        chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon() + 1);
        return mapper.convertToDTO(gioHangCTRepository.save(gioHangChiTiet));

    }

}
