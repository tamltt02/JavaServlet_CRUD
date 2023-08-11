package com.example.assignment.service.impl;

import com.example.assignment.dto.ChiTietSanPhamDTO;
import com.example.assignment.dto.GioHangChiTietDTO;
import com.example.assignment.dto.GioHangDTO;
import com.example.assignment.dto.KhachHangDTO;
import com.example.assignment.dto.NhanVienDTO;
import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.entity.GioHang;
import com.example.assignment.entity.GioHangChiTiet;
import com.example.assignment.entity.NhanVien;
import com.example.assignment.mapper.ChiTietSanPhamMapper;
import com.example.assignment.mapper.GioHangChiTietMapper;
import com.example.assignment.mapper.GioHangMapper;
import com.example.assignment.mapper.NhanVienMapper;
import com.example.assignment.reponsitory.ChiTietSanPhamRepository;
import com.example.assignment.reponsitory.GioHangCTRepository;
import com.example.assignment.reponsitory.GioHangRepository;
import com.example.assignment.reponsitory.NhanVienRepository;
import com.example.assignment.service.ChiTietSPService;
import com.example.assignment.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GioHangServiceImpl implements GioHangService {

    @Autowired
    GioHangRepository gioHangRepository;

    @Autowired
    NhanVienRepository nhanVienRepository;

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
    ChiTietSanPhamRepository chiTietSanPhamRepository;
    @Autowired
    HttpServletRequest request;

    @Override
    public List<GioHangChiTietDTO> getgioHang(Integer id) {
        List<GioHangChiTiet> list = gioHangRepository.getGioHangByUser(id);
        List<GioHangChiTietDTO> listDTO = new ArrayList<>();
        for (GioHangChiTiet gioHangChiTiet : list) {
            listDTO.add(mapper.convertToDTO(gioHangChiTiet));
        }
        return listDTO;
    }


    @Override
    public GioHangChiTietDTO addGioHang(Integer idsp, Integer soLuong) {
        HttpSession session = request.getSession();
        List<NhanVien> listnv = nhanVienRepository.findAll();
        List<NhanVienDTO> listDTO = new ArrayList<>();
        for (NhanVien nhanVien : listnv) {
            listDTO.add(nhanVienMapper.convertToDTO(nhanVien));
        }

        KhachHangDTO khachHangDTO = (KhachHangDTO) session.getAttribute("user");
        GioHangDTO gioHangDTO = new GioHangDTO();
        GioHang  gioHang = gioHangRepository.findGioiHangByUser(khachHangDTO.getId());
        if(gioHang == null) {
            gioHangDTO.setId(null);
            gioHangDTO.setKhachHang(khachHangDTO);
            gioHangDTO.setDiaChi(khachHangDTO.getDiaChi());
            gioHangDTO.setMa(null);
            gioHangDTO.setNhanVien(listDTO.get(1));
            gioHangDTO.setTinhTrang(0);
            gioHangDTO.setSdt(khachHangDTO.getSdt());
            gioHangDTO.setNgayThanhToan(null);
            gioHangDTO.setNgayTao(new Date());
            gioHangDTO.setTenNguoiNhan(khachHangDTO.getHoTen());
            gioHang= gioHangRepository.save(gioHangMapper.convertToEntity(gioHangDTO));
        }

        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
        gioHangChiTiet.setId(null);
        gioHangChiTiet.setChiTietSanPham(chiTietSanPhamMapper.convertToEntity(chiTietSPService.findById(idsp)));
        gioHangChiTiet.setDonGia(chiTietSPService.findById(idsp).getGiaBan());
        gioHangChiTiet.setGioHang(gioHang);
        gioHangChiTiet.setSoLuong(soLuong);
        ChiTietSanPhamDTO chiTietSanPhamDTO = chiTietSPService.findById(idsp);
        if(chiTietSanPhamDTO.getSoLuongTon() - soLuong == -1){
            System.out.println(chiTietSanPhamDTO.getSoLuongTon());
            session.setAttribute("hethang","Hết hàng");
            return null;
        }
        chiTietSanPhamDTO.setSoLuongTon(chiTietSanPhamDTO.getSoLuongTon() - soLuong);

        chiTietSPService.update(chiTietSanPhamDTO);
        return mapper.convertToDTO(gioHangCTRepository.save(gioHangChiTiet));
    }

    @Override
    public double tongtien(List<GioHangChiTietDTO> dtoList) {
        double sum = 0;
        for (GioHangChiTietDTO g: dtoList   ) {
            sum += (g.getDonGia()*g.getSoLuong());
        }
        return sum;
    }
    @Override
    public void remove(Integer id) {
        GioHangChiTiet gioHangChiTiet = gioHangCTRepository.findById(id).get();
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(gioHangChiTiet.getChiTietSanPham().getId()).get();
        chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon() + gioHangChiTiet.getSoLuong());
        gioHangCTRepository.deleteById(id);
    }

}
