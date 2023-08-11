package com.poly.controller;


import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.entity.Heo;
import com.poly.repository.IHeoRepository;
import com.poly.repository.IOrderDetailRepository;
import com.poly.repository.IOrderRepository;
import com.poly.repository.IUserRepository;

@Controller
public class TrangChuController {
	@Autowired
	private IOrderDetailRepository repository;
	@Autowired
	private IHeoRepository heoRepository;
	@Autowired
	private IOrderRepository orderRepository;
	@Autowired
	private IUserRepository userRepository;
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("view","/WEB-INF/View/Amin/trangchu.jsp");
		Pageable pageable = PageRequest.of(0, 1);
		List<Heo> heo = this.repository.getBanChayNgay(pageable);
	
		if(!heo.isEmpty()) {
			model.addAttribute("ngay",heo.get(0));
			List<Long> sl = this.repository.getSLBanChayNgay(pageable);
			model.addAttribute("ngaysl",sl.get(0));
			model.addAttribute("dtNgay",this.repository.getDTBanChayNgay(pageable).get(0));
		}
		List<Heo> heoThang = this.repository.getBanChaythang(pageable);
		if(!heoThang.isEmpty()) {
			model.addAttribute("thang",heoThang.get(0));
			List<Long> slthang = this.repository.getSLBanChaythang(pageable);
			model.addAttribute("thangsl",slthang.get(0));
			model.addAttribute("dtThang",this.repository.getDTBanChaythang(pageable).get(0));
		}
		List<Heo> heonam = this.repository.getBanChayNam(pageable);
		if(!heoThang.isEmpty()) {
			model.addAttribute("nam",heonam.get(0));
			List<Long> slthang = this.repository.getSLBanChayNam(pageable);
			model.addAttribute("namsl",slthang.get(0));
			model.addAttribute("dtnam",this.repository.getDTBanChayNam(pageable).get(0));
		}
		long slSP = this.heoRepository.count();
		model.addAttribute("slSP",slSP);
		long slDH = this.orderRepository.count();
		model.addAttribute("slDH",slDH);
		long slu = this.userRepository.count();
		model.addAttribute("slu",slu);
		return "Amin/index";
	}
	@GetMapping("/chart")
	public String getChart(Model model) {
		List<Object[]> list = this.repository.getChart();
		boolean check =false;
		for (int i = 1; i <= 12; i++) {
			
			for (int j = 0; j < list.size(); j++) {
			Object[] o =	list.get(j);
				if(i == (int) o[0]) {
					check = true;
					break;
				}
			}
			if(check == false) {
				Object[] o1 = {i,0};
				list.add(o1);
				
				
			}
			check = false;
		}
		list = list.stream().sorted((o1, o2) ->  ((Integer)o1[0]).compareTo((Integer) o2[0])

		).collect(Collectors.toList());
		model.addAttribute("chart",list);
		model.addAttribute("view","/WEB-INF/View/Amin/Chart.jsp");
		return "Amin/index";
	}
}
