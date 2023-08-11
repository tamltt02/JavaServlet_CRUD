package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

import org.apache.commons.beanutils.BeanUtils;

import Entities.Lop;
import Entities.SinhVienLop;
import Model.Mon;
import Model.SinhVien;
import Reponsitory.ChuyenNganhReponsitoy;
import Reponsitory.MonResponsitory;
import Reponsitory.SVLopReponsitory;
import Reponsitory.SinhVienRepository;
import Utils.EncryptUtil;
import Utils.JPAUtils;

@WebServlet({ "/sinh-vien", "/sinh-vien/store", "/sinh-vien/create", "/sinh-vien/edit", "/sinh-vien/update",
		"/sinh-vien/delete" })
public class SinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SinhVienRepository svRepo;
	private ChuyenNganhReponsitoy cnRepo;
	SVLopReponsitory svlopRepo = new SVLopReponsitory();
	  

	public SinhVienServlet() {
		super();
		this.svRepo = new SinhVienRepository();
		this.cnRepo = new ChuyenNganhReponsitoy();
		 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("create")) {
			this.doGetCreate(request, response);
		} else if (uri.contains("edit")) {
			this.doGetEdit(request, response);
		} else if (uri.contains("delete")) {
			this.doGetDelete(request, response);
		} else {
			this.doGetIndex(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		}
	}

	protected void doGetIndex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Entities.SinhVien> dsSV = new ArrayList<Entities.SinhVien>();
		List<Entities.ChuyenNganh> dscn = new ArrayList<Entities.ChuyenNganh>();
		dsSV = svRepo.getAll();
		dscn = cnRepo.getAll();
		request.setAttribute("dssv", dsSV);
		request.setAttribute("dscn", dscn);
		request.setAttribute("user", "sinh-vien");
		request.setAttribute("view", "/views/sinhvien/index.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	protected void doGetCreate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Entities.ChuyenNganh> dscn = new ArrayList<Entities.ChuyenNganh>();
		dscn = cnRepo.getAll();
		request.setAttribute("dscn", dscn);
		request.setAttribute("user", "sinh-vien");
		request.setAttribute("view", "/views/sinhvien/create.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	protected void doGetEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Entities.ChuyenNganh> dscn = new ArrayList<Entities.ChuyenNganh>();
		dscn = cnRepo.getAll();
		request.setAttribute("dscn", dscn);
		String idStr = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(idStr);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/BaiTap/sinh-vien");
		}
		Entities.SinhVien sv = svRepo.findById(id);
		if (sv == null) {
			response.sendRedirect("/BaiTap/sinh-vien");
		}
		System.out.println(sv.getHoTen());
		request.setAttribute("sv", sv);
		request.setAttribute("user", "sinh-vien");
		request.setAttribute("view", "/views/sinhvien/edit.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);

	}

	protected void doGetDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(idStr);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/BaiTap/sinh-vien");
		}
		Entities.SinhVien sv = svRepo.findById(id);
		for (SinhVienLop svlop : svlopRepo.getAll()) {
			if(sv.getId() == svlop.getSinhVien().getId()) {
				request.setAttribute("loi", "Vẫn có sinh viên trong lớp");
				doGetIndex(request, response);
				return;
			}
		}
		try {
			System.out.println(sv.getId());
			svRepo.delete(sv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/BaiTap/sinh-vien");
		}
		doGetIndex(request, response);

	}

	protected void store(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SinhVien sv = new SinhVien();
		SinhVienRepository svResp = new SinhVienRepository();
		try {
			BeanUtils.populate(sv, request.getParameterMap());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(sv.getTenSV().isBlank() || sv.getDiaChi().isBlank() || sv.getEmail().isBlank() || sv.getPassword().isBlank() || sv.getSdt().isBlank()) {
			System.out.println("Dữ liệu không được nul");
			request.setAttribute("error", "Dữ liệu không được null");
			doGetCreate(request, response);
		return;
		}
		
		for (Entities.SinhVien sinhvien : svResp.getAll()) {
			if(sinhvien.getEmail().equals(sv.getEmail())) {
				System.out.println("Trùng");
				request.setAttribute("error", "Email đã tồn tại ");
				doGetCreate(request, response);
			return;
			}
		}
		int idCn = Integer.parseInt(request.getParameter("chuyenNganh"));
		Entities.SinhVien svEntity = new Entities.SinhVien();
		svEntity.setHoTen(sv.getTenSV());
		svEntity.setGioiTinh(sv.getGioiTinh());
		svEntity.setDiaChi(sv.getDiaChi());
		svEntity.setSdt(sv.getSdt());
		svEntity.setEmail(sv.getEmail());
		String encrypted = EncryptUtil.encrypt(
				request.getParameter("password")
			);
		svEntity.setPassword(encrypted);
		svEntity.setAvatar(null);
		svEntity.setChuyenNganh(cnRepo.findById(idCn));

		try {
			svResp.insert(svEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/BaiTap/sinh-vien");
	}

	
	
	
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SinhVien sv = new SinhVien();
		SinhVienRepository svResp = new SinhVienRepository();
		try {
			BeanUtils.populate(sv, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int id = Integer.parseInt(request.getParameter("id"));
		if(sv.getTenSV().isBlank() || sv.getDiaChi().isBlank() || sv.getEmail().isBlank() || sv.getPassword().isBlank() || sv.getSdt().isBlank()) {
			System.out.println("Dữ liệu không được nul");
			request.setAttribute("error", "Dữ liệu không được null");
			doGetCreate(request, response);
		return;
		}
		for (Entities.SinhVien sinhvien : svResp.getAll()) {
			if(!svResp.findById(id).getEmail().equals(sinhvien.getEmail()) && sinhvien.getEmail().equals(sv.getEmail())  ) {
				request.setAttribute("error", "Email đã tồn tại ");
				doGetEdit(request, response);
			return;
			}
		}
		int idCn = Integer.parseInt(request.getParameter("chuyenNganh"));
		System.out.println(id);
		Entities.SinhVien svEn = svResp.findById(id); 
		Entities.SinhVien svEntity = new Entities.SinhVien();
		svEntity.setId(id);
		svEntity.setHoTen(sv.getTenSV());
		svEntity.setGioiTinh(sv.getGioiTinh());
		svEntity.setDiaChi(sv.getDiaChi());
		svEntity.setSdt(sv.getSdt());
		svEntity.setEmail(sv.getEmail());
		svEntity.setPassword(svEn.getPassword());
		svEntity.setAvatar(null);
		svEntity.setChuyenNganh(cnRepo.findById(idCn));
		try {
			svResp.update(svEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/BaiTap/sinh-vien");
	}
}
