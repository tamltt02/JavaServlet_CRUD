package com.example.assignment.controller;

import com.example.assignment.dto.ChiTietSanPhamDTO;
import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.service.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    ChiTietSPService chiTietSPService;

        @GetMapping("/trangchu")
        public String trangChu(Model model){
            List<ChiTietSanPhamDTO> listspnew = chiTietSPService.getCTSPnew();
            List<ChiTietSanPhamDTO> listspchay = chiTietSPService.getCTSPchay();
            List<ChiTietSanPhamDTO> listsp = chiTietSPService.getAll();
            model.addAttribute("view","trangchu.jsp");
            model.addAttribute("listspnew",listspnew);
            model.addAttribute("listspchay",listspchay);
            model.addAttribute("listsp",listsp);
            return "page/index";
        }


}
