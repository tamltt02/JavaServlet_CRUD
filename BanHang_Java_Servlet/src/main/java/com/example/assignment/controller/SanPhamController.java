package com.example.assignment.controller;

import com.example.assignment.dto.ChiTietSanPhamDTO;
import com.example.assignment.dto.DongSanPhamDTO;
import com.example.assignment.dto.NSXDTO;
import com.example.assignment.dto.SanPhamDTO;
import com.example.assignment.service.ChiTietSPService;
import com.example.assignment.service.DongSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class SanPhamController {
    @Autowired
    ChiTietSPService chiTietSPService;

    @Autowired
    DongSanPhamService dongSanPhamService;
    @GetMapping("/sanpham")
    public String index(Model model,@RequestParam(value = "page",defaultValue = "0") String pageNumber) {
        model.addAttribute("view", "sanpham.jsp");
        List<DongSanPhamDTO> dongSanPhams = dongSanPhamService.getAll();
        model.addAttribute("dongSanPhams", dongSanPhams);
        int limit = 3;
        Integer page = pageNumber == null ? 0 : Integer.parseInt(pageNumber);
        model.addAttribute("pageData", chiTietSPService.getSanPham(page,limit));
        return "page/index";
    }


    @GetMapping("/sanpham/{ten}")
    public String sanphamByDongSP(Model model, @PathVariable("ten") String ten,@RequestParam(value = "page",defaultValue = "0") String pageNumber){
        List<DongSanPhamDTO> dongSanPhams = dongSanPhamService.getAll();
        model.addAttribute("dongSanPhams", dongSanPhams);
        model.addAttribute("view", "sanpham.jsp");
        model.addAttribute("ten",ten);
        Integer page = pageNumber == null ? 0 : Integer.parseInt(pageNumber);
        model.addAttribute("pageData", chiTietSPService.getSPbydongSP(ten,page));
        return "page/index";
    }
}
