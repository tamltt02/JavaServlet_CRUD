package com.example.assignment.service.impl;

import com.example.assignment.dto.ChiTietSanPhamDTO;
import com.example.assignment.dto.GioHangDTO;
import com.example.assignment.dto.HoaDonChiTietDTO;
import com.example.assignment.dto.HoaDonDTO;
import com.example.assignment.dto.KhachHangDTO;
import com.example.assignment.dto.NhanVienDTO;
import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.entity.GioHang;
import com.example.assignment.entity.GioHangChiTiet;
import com.example.assignment.entity.HoaDon;
import com.example.assignment.entity.HoaDonChiTiet;
import com.example.assignment.entity.NhanVien;
import com.example.assignment.mapper.ChiTietSanPhamMapper;
import com.example.assignment.mapper.GioHangChiTietMapper;
import com.example.assignment.mapper.GioHangMapper;
import com.example.assignment.mapper.HoaDonChiTietMapper;
import com.example.assignment.mapper.HoaDonMapper;
import com.example.assignment.mapper.KhachHangMapper;
import com.example.assignment.mapper.NhanVienMapper;
import com.example.assignment.reponsitory.GioHangCTRepository;
import com.example.assignment.reponsitory.GioHangRepository;
import com.example.assignment.reponsitory.HoaDonCTRepository;
import com.example.assignment.reponsitory.HoaDonRepository;
import com.example.assignment.reponsitory.NhanVienRepository;
import com.example.assignment.service.ChiTietSPService;
import com.example.assignment.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Autowired
    GioHangChiTietMapper gioHangChiTietMapper;
    @Autowired
    NhanVienMapper nhanVienMapper;

    @Autowired
    KhachHangMapper khachHangMapper;
    @Autowired
    GioHangMapper gioHangMapper;
    @Autowired
    GioHangCTRepository gioHangCTRepository;
    @Autowired
    HoaDonCTRepository hoaDonCTRepository;

    @Autowired
    ChiTietSPService chiTietSPService;

    @Autowired
    ChiTietSanPhamMapper chiTietSanPhamMapper;
    @Autowired
    HttpServletRequest request;
    @Autowired
    HoaDonMapper mapper;

    @Autowired
    GioHangRepository gioHangRepository;

    @Override
    public List<HoaDonDTO> getAll() {
        List<HoaDon> list = hoaDonRepository.findAll();
        List<HoaDonDTO> listDTO = new ArrayList<>();
        for (HoaDon hoaDon : list) {
            listDTO.add(mapper.convertToDTO(hoaDon));
        }
        return listDTO;
    }

    @Override
    public Page<HoaDonDTO> getSanPhamDTO(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<HoaDon> data = hoaDonRepository.findAll(pageable);
        return data.map(t -> mapper.convertToDTO(t));
    }

    @Override
    public List<HoaDonDTO> searchHoaDon(String name, Integer status) {
        List<HoaDon> list = hoaDonRepository.findHoaDonBy(name, status);
        List<HoaDonDTO> listDTO = new ArrayList<>();
        for (HoaDon hoaDon : list) {
            listDTO.add(mapper.convertToDTO(hoaDon));
        }
        return listDTO;
    }

    @Override
    public void addHoaDon() {
        HttpSession session = request.getSession();
        List<NhanVien> listnv = nhanVienRepository.findAll();
        List<NhanVienDTO> listDTO = new ArrayList<>();
        for (NhanVien nhanVien : listnv) {
            listDTO.add(nhanVienMapper.convertToDTO(nhanVien));
        }

        KhachHangDTO khachHangDTO = (KhachHangDTO) session.getAttribute("user");
        HoaDonDTO hoaDonDTO = new HoaDonDTO();
        HoaDon hoaDon = hoaDonRepository.findHoaDonByUser(khachHangDTO.getId());
        GioHang gioHang= gioHangRepository.findGioiHangByUser(khachHangDTO.getId());
        if(hoaDon == null) {
            hoaDonDTO.setId(null);
            hoaDonDTO.setKhachHang(khachHangMapper.convertToDTO(gioHang.getKhachHang()));
            hoaDonDTO.setDiaChi(gioHangMapper.convertToDTO(gioHang).getDiaChi());
            hoaDonDTO.setMa(null);
            hoaDonDTO.setNhanVien(nhanVienMapper.convertToDTO(gioHang.getNhanVien()));
            hoaDonDTO.setTinhTrang(1);
            hoaDonDTO.setSdt(gioHangMapper.convertToDTO(gioHang).getSdt());
            hoaDonDTO.setNgayThanhToan(setdate(3));
            hoaDonDTO.setNgayTao(gioHangMapper.convertToDTO(gioHang).getNgayTao());
            hoaDonDTO.setTenNguoiNhan(gioHangMapper.convertToDTO(gioHang).getTenNguoiNhan());
            hoaDonDTO.setNgayNhan(setdate(3));
            hoaDonDTO.setNgayShip(setdate(1));
            hoaDon= hoaDonRepository.save(mapper.convertToEntity(hoaDonDTO));
        }


//        List<HoaDonChiTiet> listhdct = new ArrayList<>();
        for ( GioHangChiTiet gioHangChiTiet: gioHangRepository.getGioHangByUser(khachHangDTO.getId())
             ) {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setId(null);
            hoaDonChiTiet.setChiTietSanPham(gioHangChiTiet.getChiTietSanPham());
            hoaDonChiTiet.setDonGia(gioHangChiTiet.getDonGia());
            hoaDonChiTiet.setHoaDon(hoaDon);
            hoaDonChiTiet.setSoLuong(gioHangChiTiet.getSoLuong());

          hoaDonCTRepository.save(hoaDonChiTiet);

        }
         gioHangCTRepository.deleteAll();
    }


    Date setdate(int a){
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, a);
        dt = c.getTime();
        return dt ;
    }
}
