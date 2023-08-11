package com.example.assignment.controller;

import com.example.assignment.dto.KhachHangDTO;
import com.example.assignment.dto.KhachHangDTOForm;
import com.example.assignment.dto.NhanVienDTO;
import com.example.assignment.mapper.KhachHangMapper;
import com.example.assignment.service.KhachHangService;
import com.example.assignment.service.NhanVienService;
import com.example.assignment.utils.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    KhachHangService khachHangService;
    @Autowired
    NhanVienService nhanVienService;

@Autowired
HttpServletRequest request;

@Autowired
    KhachHangMapper khachHangMapper;


    @GetMapping("/dangki")
    public String dangki(Model model) {
        model.addAttribute("view", "taikhoan/dangki.jsp");
        model.addAttribute("userDTO", new KhachHangDTO());
        return "page/index";
    }

    @GetMapping("/dangnhap")
    public String dangnhap(Model model) {
        model.addAttribute("view", "taikhoan/dangnhap.jsp");
        return "page/index";
    }

    @GetMapping("/dangnhap/admin")
    public String dangnhaadminp(Model model) {
        model.addAttribute("view", "taikhoan/dn.jsp");
        return "page/index";
    }
    @PostMapping("/dangki/store")
    public String store(Model model, @Valid  @ModelAttribute("userDTO") KhachHangDTOForm khachHangDTOForm, BindingResult result, HttpServletRequest request) {



        DateFormat formatDate2 = new SimpleDateFormat("yyyy-mm-dd");
        Date formatedDate2 = null;
        try {
            formatedDate2 =  formatDate2.parse(request.getParameter("ngaySinh"));

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        KhachHangDTO khachHangDTO = new KhachHangDTO(null,null, khachHangDTOForm.getHoTen(),
                formatedDate2,khachHangDTOForm.getDiaChi(),khachHangDTOForm.getSdt(),
                khachHangDTOForm.getUsername(), khachHangDTOForm.getEmail(),
                khachHangDTOForm.getMatKhau());

        if(result.hasErrors()){
            model.addAttribute("view", "taikhoan/dangki.jsp");
            return "page/index";
        }else {
            String hashPaa = HashUtil.hash(khachHangDTO.getMatKhau());
            khachHangDTO.setMatKhau(hashPaa);
            khachHangService.add(khachHangDTO);
            return "redirect:/dangnhap";
        }
    }

    @PostMapping("/dangnhap/store")
    public String dangnhapstore( @RequestParam("email") String email,
                                     @RequestParam("password") String pass ) {
        HttpSession session = request.getSession();
        KhachHangDTO khachHangDTO = this.khachHangService.findByEmail(email);
        if(khachHangDTO == null){
            System.out.println("lỗi");
            session.setAttribute("loi","Sai email hoặc mật khẩu");
            return "redirect:/dangnhap";
        }
        boolean checkPw = HashUtil.verify(pass,khachHangDTO.getMatKhau());
        if(!checkPw){
            session.setAttribute("loi","Sai email hoặc mật khẩu");
            return "redirect:/dangnhap";
        }
        session.setAttribute("user",khachHangDTO);
        return "redirect:/trangchu";
    }


    @PostMapping("/dangnhap/admin/store")
    public String dnadmin( @RequestParam("email") String email,
                                    @RequestParam("password") String pass ) {
        HttpSession session = request.getSession();
        NhanVienDTO nhanVienDTO = this.nhanVienService.findByEmail(email,pass);
        if(nhanVienDTO == null){
            session.setAttribute("error","Sai email hoặc mật khẩu");
            return "redirect:/dangnhap/admin";
        }

        session.setAttribute("admin",nhanVienDTO);
        return "redirect:/trangchu";
    }
    @GetMapping("/logout")
    public String logout() {
        HttpSession session = request.getSession();
       session.removeAttribute("user");
       session.removeAttribute("admin");
        return "redirect:/trangchu";
    }
    @GetMapping("/doimk")
    public String doimk(Model model) {
        model.addAttribute("view", "taikhoan/doimk.jsp");
        return "page/index";
    }

    @GetMapping("/quenmk")
    public String quenmk(Model model) {
        model.addAttribute("view", "taikhoan/quenmk.jsp");
        return "page/index";
    }
    @PostMapping("/doimk/store")
    public String doimkstore( @RequestParam("email") String email,
                                    @RequestParam("password") String pass,@RequestParam("passwordnew") String passnew ) {
        HttpSession session = request.getSession();
        KhachHangDTO userDTO =(KhachHangDTO) session.getAttribute("user");
       if(!userDTO.getEmail().equals(email)){
           session.setAttribute("error","Sai email hoặc mật khẩu");
           return "redirect:/doimk";
       }
        boolean checkPw = HashUtil.verify(pass,userDTO.getMatKhau());
        if(!checkPw){
            session.setAttribute("error","Sai email hoặc mật khẩu");
            return "redirect:/doimk";
        }
        userDTO.setMatKhau(HashUtil.hash(passnew));
        khachHangService.update(userDTO);
        session.removeAttribute("user");
        return "redirect:/dangnhap";
    }
}
