package com.example.assignment.controller;

import com.example.assignment.dto.ChiTietSanPhamDTO;
import com.example.assignment.dto.GioHangChiTietDTO;
import com.example.assignment.dto.KhachHangDTO;
import com.example.assignment.service.ChiTietSPService;
import com.example.assignment.service.GioHangCTService;
import com.example.assignment.service.GioHangService;
import com.example.assignment.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CTSanPhamController {

    @Autowired
    ChiTietSPService chiTietSPService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    GioHangService gioHangService;

    @Autowired
    GioHangCTService gioHangCTService;

    @Autowired
    HoaDonService hoaDonService;


    @GetMapping("/sanpham/detail/{id}")
    public String detail(Model model, @PathVariable("id")Integer id){
        ChiTietSanPhamDTO spDTO = chiTietSPService.findById(id);
        model.addAttribute("view","detail.jsp");
        model.addAttribute("sp",spDTO);
        return "page/index";
    }

    @GetMapping("/giohang/delete/{id}")
    public String delete(Model model, @PathVariable("id")Integer id){
        gioHangService.remove(id);
        return "redirect:/giohang";
    }
    @PostMapping("/giohang/{id}")
    public String giohang( @PathVariable("id")Integer id, @RequestParam("soluong") Integer soLuong){
        System.out.println(soLuong);
        GioHangChiTietDTO gioHangChiTietDTO =  gioHangService.addGioHang(id,soLuong);
        if(gioHangChiTietDTO == null){
            return "redirect:/sanpham";
        }

        return "redirect:/giohang";
    }

    @PostMapping("/giohang/them/{id}")
    public String giohangthen(Model model , @PathVariable("id")Integer id, @RequestParam("soluong") Integer soLuong){
        HttpSession session = request.getSession();
        gioHangService.addGioHang(id,soLuong);
        KhachHangDTO khachHangDTO = (KhachHangDTO) session.getAttribute("user");
        List<GioHangChiTietDTO> dtoList = gioHangService.getgioHang(khachHangDTO.getId());
        model.addAttribute("dtolist",dtoList);
        model.addAttribute("length",dtoList.size());
        return "redirect:/sanpham";
    }

    @GetMapping("/giohang")
    public String index(Model model){
        HttpSession session = request.getSession();
        KhachHangDTO khachHangDTO = (KhachHangDTO) session.getAttribute("user");
        List<GioHangChiTietDTO> dtoList = gioHangService.getgioHang(khachHangDTO.getId());
        model.addAttribute("dtolist",dtoList);
        model.addAttribute("sum",gioHangService.tongtien(dtoList));
        model.addAttribute("length",dtoList.size());
        model.addAttribute("view","giohang.jsp");
        return "page/index";
    }

    @PostMapping("/thanhtoan")
    public String thanhtoan(){
        hoaDonService.addHoaDon();
        return "redirect:/giohang";
    }

    @PostMapping("/giohang/tang/{id}")
    public String tangloLuong(Model model ,@PathVariable("id") Integer id, @RequestParam("soluong") Integer soLuong){

        soLuong +=1 ;
        System.out.println(soLuong);
        GioHangChiTietDTO gioHangChiTietDTO =   gioHangCTService.tangSoLuong(id,soLuong);
        if(gioHangChiTietDTO == null){
            model.addAttribute("soluong",soLuong-1);
            return "redirect:/giohang";
        }
        return "redirect:/giohang";
    }


    @PostMapping("/giohang/giam/{id}")
    public String giamloLuong(Model model ,@PathVariable("id") Integer id, @RequestParam("soluong") Integer soLuong){
        soLuong -=1 ;
        if(soLuong <=0 ){
            model.addAttribute("soluong",1);
            return "redirect:/giohang";
        }
      gioHangCTService.giamSoLuong(id,soLuong);
        return "redirect:/giohang";
    }
}
