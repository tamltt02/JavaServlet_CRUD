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

import Model.Lop;
import Reponsitory.ChuyenNganhReponsitoy;
import Reponsitory.LopResponsitory;
import Reponsitory.MonResponsitory;


@WebServlet({"/lop","/lop/store",
	"/lop/update",
	"/lop/create",
	"/lop/edit",
	"/lop/delete"
})
public class LopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LopResponsitory lRepo;
	private ChuyenNganhReponsitoy cnRepo;
	private MonResponsitory mRepo;
		public LopServlet() {
			super();
			   this.lRepo = new LopResponsitory();
			   this.cnRepo = new ChuyenNganhReponsitoy();
			   this.mRepo = new MonResponsitory();
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
			
			List<Entities.Lop> dsl = new ArrayList<Entities.Lop>();
			dsl= lRepo.getAll();
			List<Entities.ChuyenNganh> dscn = new ArrayList<Entities.ChuyenNganh>();
			dscn = cnRepo.getAll();
			request.setAttribute("dscn", dscn);
			List<Entities.Mon> dsm = new ArrayList<Entities.Mon>();
			dsm= mRepo.getAll();
			request.setAttribute("dsm", dsm);
			request.setAttribute("dsl", dsl);
			request.setAttribute("user", "lop");
			request.setAttribute("view", "/views/lop/index.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}

		protected void doGetCreate(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			List<Entities.ChuyenNganh> dscn = new ArrayList<Entities.ChuyenNganh>();
			dscn = cnRepo.getAll();
			request.setAttribute("dscn", dscn);
			List<Entities.Mon> dsm = new ArrayList<Entities.Mon>();
			dsm= mRepo.getAll();
			request.setAttribute("dsm", dsm);
			request.setAttribute("user", "lop");
			request.setAttribute("view", "/views/lop/create.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}

		protected void doGetEdit(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			List<Entities.ChuyenNganh> dscn = new ArrayList<Entities.ChuyenNganh>();
			dscn = cnRepo.getAll();
			request.setAttribute("dscn", dscn);
			List<Entities.Mon> dsm = new ArrayList<Entities.Mon>();
			dsm= mRepo.getAll();
			request.setAttribute("dsm", dsm);
			String idStr = request.getParameter("id");
			int id = -1 ;
			try {
				id = Integer.parseInt(idStr);
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("/BaiTap/lop");
			}
			Entities.Lop l = lRepo.findById(id);
			if (l == null) {
				response.sendRedirect("/BaiTap/lop");
			}
			System.out.println(l.getTen());
			request.setAttribute("l", l);
			request.setAttribute("user", "lop");
			request.setAttribute("view", "/views/lop/edit.jsp");
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
				response.sendRedirect("/BaiTap/lop");
			}
			Entities.Lop m = lRepo.findById(id);
				 try {
					System.out.println( m.getId());
					lRepo.delete(m);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					response.sendRedirect("/BaiTap/lop");
				}
				 doGetIndex(request, response);
		
		}

		protected void store(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			Lop l = new Lop();
			try {
				BeanUtils.populate(l, request.getParameterMap());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(l.getTenLop().isBlank() || String.valueOf(l.getKhoa()).isBlank()) {
				System.out.println("Dữ liệu không được nul");
				request.setAttribute("error", "Dữ liệu không được null");
				doGetCreate(request, response);
			return;
			}
			for (Entities.Lop lop : lRepo.getAll()) {
				if(lop.getTen().equals(l.getTenLop())) {
					request.setAttribute("error", "Lớp đã tồn tại ");
					doGetCreate(request, response);
				return;
				}
			}
			int idCn = Integer.parseInt(request.getParameter("chuyenNganh"));
			int idMon = Integer.parseInt(request.getParameter("mon"));
			Entities.Lop lEntity = new Entities.Lop();
			lEntity.setTen(l.getTenLop());
			lEntity.setChuyenNganh(cnRepo.findById(idCn));
			lEntity.setKhoa(l.getKhoa());
			lEntity.setMon(mRepo.findById(idMon));
			try {
				lRepo.insert(lEntity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(l.getTenLop());
			response.sendRedirect("/BaiTap/lop");
		}
		
		protected void update(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			Lop l = new Lop();
			try {
				BeanUtils.populate(l, request.getParameterMap());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(l.getTenLop().isBlank() || String.valueOf(l.getKhoa()).isBlank()) {
				System.out.println("Dữ liệu không được nul");
				request.setAttribute("error", "Dữ liệu không được null");
				doGetCreate(request, response);
			return;
			}
			int id = Integer.parseInt(request.getParameter("id"));
			for (Entities.Lop lop : lRepo.getAll()) {			
				if(!lRepo.findById(id).getTen().equals(lop.getTen()) && lop.getTen().equals(l.getTenLop())) {
					request.setAttribute("error", "Lớp đã tồn tại ");
					doGetEdit(request, response);
				return;
				}
			}
			int idCn = Integer.parseInt(request.getParameter("chuyenNganh"));
			int idMon = Integer.parseInt(request.getParameter("mon"));
			System.out.println(id);
			Entities.Lop lEntity = new Entities.Lop();
			lEntity.setId(id);
			lEntity.setTen(l.getTenLop());
			lEntity.setChuyenNganh(cnRepo.findById(idCn));
			lEntity.setKhoa(l.getKhoa());
			lEntity.setMon(mRepo.findById(idMon));
			try {
				lRepo.update(lEntity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("/BaiTap/lop");
		}

}
