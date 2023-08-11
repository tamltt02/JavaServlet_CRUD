package com.example.assignment.controller.admin;

import com.example.assignment.dto.ChiTietSanPhamDTO;
import com.example.assignment.dto.ChiTietSanPhamDTOForm;
import com.example.assignment.dto.DongSanPhamDTO;
import com.example.assignment.dto.MauSacDTO;
import com.example.assignment.dto.NSXDTO;
import com.example.assignment.dto.SanPhamDTO;
import com.example.assignment.mapper.ChiTietSanPhamMapper;
import com.example.assignment.service.ChiTietSPService;
import com.example.assignment.service.DongSanPhamService;
import com.example.assignment.service.MauSacService;
import com.example.assignment.service.NSXService;
import com.example.assignment.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class QLSanPhamController {

    @Autowired
    ChiTietSPService chiTietSPService;

    @Autowired
    NSXService nsxService;

    @Autowired
    MauSacService mauSacService;

    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    DongSanPhamService dongSanPhamService;

    @Autowired
    ChiTietSanPhamMapper chiTietSanPhamMapper;
    @GetMapping("/admin/sanpham/hienthi")
    public String index(Model model,@RequestParam(value = "page",defaultValue = "0") String pageNumber) {
        model.addAttribute("view", "admin/sanpham/index.jsp");
        int limit = 3;
        Integer page = pageNumber == null ? 0 : Integer.parseInt(pageNumber);
        model.addAttribute("pageData", chiTietSPService.getSanPham(page,limit));
        return "page/index";
    }

    @GetMapping("/admin/sanpham/create")
    public String create(Model model,@ModelAttribute("spDTO") ChiTietSanPhamDTOForm chiTietSanPhamDTOForm) {
        model.addAttribute("view", "admin/sanpham/create.jsp");
        List<MauSacDTO> mauSacs = mauSacService.getAll();
        List<DongSanPhamDTO> dongSanPhams = dongSanPhamService.getAll();
        List<SanPhamDTO> dssp = sanPhamService.getAll();
        List<NSXDTO> nsxs = nsxService.getAll();
        model.addAttribute("mauSacs", mauSacs);
        model.addAttribute("dongSanPhams", dongSanPhams);
        model.addAttribute("dssp", dssp);
        model.addAttribute("nsxs", nsxs);
        model.addAttribute("sp", new ChiTietSanPhamDTO());
        return "page/index";
    }

    @PostMapping ("/admin/sanpham/store")
    public String store(Model model , @Valid @ModelAttribute("spDTO") ChiTietSanPhamDTOForm chiTietSanPhamDTOForm, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("errors",result.getAllErrors());
            model.addAttribute("spDTO",chiTietSanPhamDTOForm);
            List<MauSacDTO> mauSacs = mauSacService.getAll();
            List<DongSanPhamDTO> dongSanPhams = dongSanPhamService.getAll();
            List<SanPhamDTO> dssp = sanPhamService.getAll();
            List<NSXDTO> nsxs = nsxService.getAll();
            model.addAttribute("view", "admin/sanpham/create.jsp");
            model.addAttribute("mauSacs", mauSacs);
            model.addAttribute("dongSanPhams", dongSanPhams);
            model.addAttribute("dssp", dssp);
            model.addAttribute("nsxs", nsxs);
            System.out.println("lỗi");
            System.out.println(result.getAllErrors());
            return "page/index";
        }else {

            chiTietSPService.add(chiTietSanPhamDTOForm);
            System.out.println("kkkk");
            return "redirect:/admin/sanpham/hienthi";
        }
    }

    @GetMapping ("/admin/sanpham/edit/{id}")
    public String edit(Model model ,@ModelAttribute("spDTO") ChiTietSanPhamDTO chiTietSanPhamDTO, @PathVariable("id") Integer id){
        ChiTietSanPhamDTO spDTO = chiTietSPService.findById(id);
        model.addAttribute("view", "admin/sanpham/edit.jsp");
        List<MauSacDTO> mauSacs = mauSacService.getAll();
        List<DongSanPhamDTO> dongSanPhams = dongSanPhamService.getAll();
        List<SanPhamDTO> dssp = sanPhamService.getAll();
        List<NSXDTO> nsxs = nsxService.getAll();
        model.addAttribute("mauSacs", mauSacs);
        model.addAttribute("dongSanPhams", dongSanPhams);
        model.addAttribute("dssp", dssp);
        model.addAttribute("nsxs", nsxs);
        model.addAttribute("spDTO", spDTO);
        return "page/index";
    }


    @PostMapping ("/admin/sanpham/update/{id}")
    public String update(Model model ,@Valid @ModelAttribute("sp") ChiTietSanPhamDTO chiTietSanPhamDTO,BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("view", "admin/sanpham/edit.jsp");
            model.addAttribute("errors",result.getAllErrors());
            model.addAttribute("spDTO",chiTietSanPhamDTO);
            List<MauSacDTO> mauSacs = mauSacService.getAll();
            List<DongSanPhamDTO> dongSanPhams = dongSanPhamService.getAll();
            List<SanPhamDTO> dssp = sanPhamService.getAll();
            List<NSXDTO> nsxs = nsxService.getAll();
            model.addAttribute("mauSacs", mauSacs);
            model.addAttribute("dongSanPhams", dongSanPhams);
            model.addAttribute("dssp", dssp);
            model.addAttribute("nsxs", nsxs);
            System.out.println("lỗi");
            System.out.println(result.getAllErrors());
            return "page/index";
        }
        chiTietSPService.update(chiTietSanPhamDTO);
        return "redirect:/admin/sanpham/hienthi";
    }
    @PostMapping ("/admin/sanpham/delete/{id}")
    public String delete(Model model , @PathVariable("id") Integer id){
        chiTietSPService.delete(id);
        return "redirect:/admin/sanpham/hienthi";
    }

}
