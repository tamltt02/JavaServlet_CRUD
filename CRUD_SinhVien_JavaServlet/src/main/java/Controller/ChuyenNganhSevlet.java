package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Entities.Lop;
import Entities.SinhVien;
import Model.ChuyenNganh;
import Reponsitory.ChuyenNganhReponsitoy;
import Reponsitory.LopResponsitory;
import Reponsitory.SinhVienRepository;


@WebServlet({"/chuyen-nganh","/chuyen-nganh/store",
	
	"/chuyen-nganh/create",
	"/chuyen-nganh/update",
	"/chuyen-nganh/edit",
	"/chuyen-nganh/delete"
})
public class ChuyenNganhSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChuyenNganhReponsitoy cnRepo;
	 SinhVienRepository svRepo;
	 LopResponsitory lopRepo;
    public ChuyenNganhSevlet() {
        super();
        this.cnRepo = new ChuyenNganhReponsitoy();
        this.svRepo = new SinhVienRepository();
        this.lopRepo = new LopResponsitory();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("create")) {
			this.doGetCreate(request, response);
		} else if (uri.contains("edit")) {
			this.doGetEdit(request, response);
		}  else if (uri.contains("delete")) {
			this.doGetDelete(request, response);
		}else {
			this.doGetIndex(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("store")) {
			this.store(request, response);
		}else if (uri.contains("update")) {
			this.update(request, response);
		}
	}

	protected void doGetIndex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Entities.ChuyenNganh> dsCn = new ArrayList<Entities.ChuyenNganh>();
		dsCn= cnRepo.getAll();
		request.setAttribute("dscn", dsCn);
		request.setAttribute("user", "chuyen-nganh");
		request.setAttribute("view", "/views/chuyennganh/index.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	protected void doGetCreate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("user", "chuyen-nganh");
		request.setAttribute("view", "/views/chuyennganh/create.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	protected void doGetEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String idStr = request.getParameter("id");
		int id = -1 ;
		try {
			id = Integer.parseInt(idStr);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/BaiTap/chuyen-nganh");
		}
		Entities.ChuyenNganh cn = cnRepo.findById(id);
		if (cn == null) {
			response.sendRedirect("/BaiTap/chuyen-nganh");
		}
		System.out.println(cn.getTen());
		request.setAttribute("cn", cn);
		request.setAttribute("user", "chuyen-nganh");
		request.setAttribute("view", "/views/chuyennganh/edit.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	protected void doGetDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		String idStr = request.getParameter("id");
		int id = -1 ;
		try {
			id = Integer.parseInt(idStr);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/BaiTap/chuyen-nganh");
		}
		Entities.ChuyenNganh cn = cnRepo.findById(id);
	for (SinhVien sv : svRepo.getAll()) {
			if(cn.getId() == sv.getChuyenNganh().getId()) {
				request.setAttribute("loi", "Vẫn có sv học trong chuyên ngành");
				doGetIndex(request, response);
				return;
			}
		}
	
	for (Lop lop : lopRepo.getAll()) {
		if(cn.getId() == lop.getChuyenNganh().getId()) {
			request.setAttribute("loi", "Vẫn có lớp học chuyên ngành");
			doGetIndex(request, response);
			return;
		}
	}
			 try {
				System.out.println( cn.getId());
				cnRepo.delete(cn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect("/BaiTap/chuyen-nganh");
			}
			 doGetIndex(request, response);
	
	}

	protected void store(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ChuyenNganh cn = new ChuyenNganh();
		try {
			BeanUtils.populate(cn, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cn.getTenChuyenNganh().isBlank()) {
			System.out.println("Dữ liệu không được nul");
			request.setAttribute("error", "Dữ liệu không được null");
			doGetCreate(request, response);
		return;
		}
		for (Entities.ChuyenNganh cN : cnRepo.getAll()) {
			if(cN.getTen().equals(cn.getTenChuyenNganh())) {
				request.setAttribute("error", "Chuyên ngành đã tồn tại ");
				request.setAttribute("user", "chuyen-nganh");
				request.setAttribute("view", "/views/chuyennganh/create.jsp");
				request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
			return;
			}
		}
		Entities.ChuyenNganh cnEntity = new Entities.ChuyenNganh();
		cnEntity.setTen(cn.getTenChuyenNganh());
		try {
			cnRepo.insert(cnEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/BaiTap/chuyen-nganh");
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		ChuyenNganh cn = new ChuyenNganh();
		ChuyenNganhReponsitoy cnResp = new ChuyenNganhReponsitoy();
		try {
			BeanUtils.populate(cn, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cn.getTenChuyenNganh().isBlank()) {
			System.out.println("Dữ liệu không được nul");
			request.setAttribute("error", "Dữ liệu không được null");
			doGetCreate(request, response);
		return;
		}
		for (Entities.ChuyenNganh cN : cnRepo.getAll()) {
			if(cN.getTen().equals(cn.getTenChuyenNganh())) {
				request.setAttribute("error", "Chuyên ngành đã tồn tại ");
				doGetEdit(request, response);
			return;
			}
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Entities.ChuyenNganh cnEntity = new Entities.ChuyenNganh();
		cnEntity.setId(id);
		cnEntity.setTen(cn.getTenChuyenNganh());
		try {
			cnResp.update(cnEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/BaiTap/chuyen-nganh");
	}
	
}
