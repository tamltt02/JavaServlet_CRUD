package com.example.assignment.controller.admin;

import com.example.assignment.dto.HoaDonChiTietDTO;
import com.example.assignment.dto.HoaDonDTO;
import com.example.assignment.entity.HoaDon;
import com.example.assignment.service.HoaDonCTService;
import com.example.assignment.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DonHangController {
    @Autowired
    HoaDonService hoaDonService;

    @Autowired
    HoaDonCTService hoaDonCTService;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/admin/donhang/hienthi")
    public String index(Model model){
        List<HoaDonDTO> listhd = hoaDonService.getAll();
        model.addAttribute("listhd",listhd);
        model.addAttribute("view", "admin/donhang/index.jsp");
        return "page/index";
    }

    @PostMapping("/admin/donhang/search")
    public String search(Model model, @RequestParam("name") String name,
                         @RequestParam("status") String status) throws ParseException {
      if( name.equals("")) {
         Integer status1 = Integer.parseInt(status);
         List<HoaDonDTO> listhd = hoaDonCTService.searchHoaDonbyStatus(status1);
         model.addAttribute("listhd",listhd);
     }else {
         Integer status1 = Integer.parseInt(status);
         List<HoaDonDTO> listhd = hoaDonCTService.searchHoaDon(name, status1);
         model.addAttribute("listhd",listhd);
     }

        model.addAttribute("view", "admin/donhang/index.jsp");
        return "page/index";
    }

    @GetMapping("/admin/donhang/{id}")
    public String detail(Model model,@PathVariable("id") Integer id){
        List<HoaDonChiTietDTO> listhdct = hoaDonCTService.findById(id);
        model.addAttribute("listhdct",listhdct);
        model.addAttribute("view", "admin/donhang/detail.jsp");
        return "page/index";
    }



}
