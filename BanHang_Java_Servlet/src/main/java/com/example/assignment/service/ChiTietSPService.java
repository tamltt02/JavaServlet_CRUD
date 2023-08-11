package com.example.assignment.service;

import com.example.assignment.dto.ChiTietSanPhamDTO;
import com.example.assignment.dto.ChiTietSanPhamDTOForm;
import com.example.assignment.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ChiTietSPService {
//    List<ChiTietSanPhamDTO> getAll();

    Page<ChiTietSanPhamDTO> getSanPham(Integer pageNo, Integer size);
    List<ChiTietSanPhamDTO> getAll();

    List<ChiTietSanPhamDTO> getCTSPnew();
    List<ChiTietSanPhamDTO> getCTSPchay();
    ChiTietSanPhamDTO add(ChiTietSanPhamDTOForm chiTietSanPhamDTOForm);
//    ChiTietSanPhamDTO updateform(ChiTietSanPhamDTOForm chiTietSanPhamDTOForm);
    ChiTietSanPhamDTO update(ChiTietSanPhamDTO chiTietSanPhamDTO);
    ChiTietSanPhamDTO delete(Integer id);
    ChiTietSanPhamDTO findById(Integer id);


    Page<ChiTietSanPhamDTO> getSPbydongSP(String dongSP,Integer page);
}
