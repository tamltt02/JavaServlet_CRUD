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
import Model.Mon;
import Reponsitory.LopResponsitory;
import Reponsitory.MonResponsitory;


@WebServlet({"/mon","/mon/store",
	"/mon/update",
	"/mon/create",
	"/mon/edit",
	"/mon/delete"
})
public class MonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MonResponsitory mRepo;
	LopResponsitory LopPepo = new LopResponsitory();
		public MonServlet() {
			super();
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
			
			List<Entities.Mon> dsm = new ArrayList<Entities.Mon>();
			dsm= mRepo.getAll();
			
			request.setAttribute("dsm", dsm);
			request.setAttribute("user", "mon");
			request.setAttribute("view", "/views/mon/index.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}

		protected void doGetCreate(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setAttribute("user", "mon");
			request.setAttribute("view", "/views/mon/create.jsp");
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
				response.sendRedirect("/BaiTap/mon");
			}
			Entities.Mon m = mRepo.findById(id);
			if (m == null) {
				response.sendRedirect("/BaiTap/mon");
			}
			System.out.println(m.getTen());
			request.setAttribute("m", m);
			request.setAttribute("user", "mon");
			request.setAttribute("view", "/views/mon/edit.jsp");
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
				response.sendRedirect("/BaiTap/mon");
			}
			Entities.Mon m = mRepo.findById(id);
			for (Lop lop : LopPepo.getAll()) {
				if(m.getId() == lop.getMon().getId()) {
					request.setAttribute("loi", "Vẫn có lớp học môn");
					doGetIndex(request, response);
					return;
				}
			}
				 try {
					System.out.println( m.getId());
					mRepo.delete(m);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					response.sendRedirect("/BaiTap/mon");
				}
				 doGetIndex(request, response);
		
		}

		protected void store(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			Mon m = new Mon();
			try {
				BeanUtils.populate(m, request.getParameterMap());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(m.getTenMon().isBlank() || String.valueOf(m.getHocKy()).isBlank() || String.valueOf(m.getSoTinChi()).isBlank()) {
				System.out.println("Dữ liệu không được nul");
				request.setAttribute("error", "Dữ liệu không được null");
				doGetCreate(request, response);
			return;
			}
			
			for (Entities.Mon mon : mRepo.getAll()) {
				if(mon.getTen().equals(m.getTenMon())) {
					request.setAttribute("error", "Môn đã tồn tại ");
					request.setAttribute("user", "mon");
					request.setAttribute("view", "/views/mon/create.jsp");
					request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
				return;
				}
			}
			
			
			Entities.Mon mEntity = new Entities.Mon();
			mEntity.setTen(m.getTenMon());
			mEntity.setHocKy(m.getHocKy());
			mEntity.setSoTinChi(m.getSoTinChi());
			try {
				mRepo.insert(mEntity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(m.getTenMon());
			response.sendRedirect("/BaiTap/mon");
		}
		
		protected void update(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			Mon m = new Mon();
			try {
				BeanUtils.populate(m, request.getParameterMap());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(m.getTenMon().isBlank() || String.valueOf(m.getHocKy()).isBlank() || String.valueOf(m.getSoTinChi()).isBlank()) {
				System.out.println("Dữ liệu không được nul");
				request.setAttribute("error", "Dữ liệu không được null");
				doGetCreate(request, response);
			return;
			}
			int id = Integer.parseInt(request.getParameter("id"));
	for (Entities.Mon mon : mRepo.getAll()) {			
				if(!mRepo.findById(id).getTen().equals(mon.getTen()) && mon.getTen().equals(m.getTenMon())) {
					request.setAttribute("error", "Môn đã tồn tại ");
					doGetEdit(request, response);
				return;
				}
			}
			System.out.println(id);
			Entities.Mon mEntity = new Entities.Mon();
			mEntity.setId(id);
			mEntity.setTen(m.getTenMon());
			mEntity.setHocKy(m.getHocKy());
			mEntity.setSoTinChi(m.getSoTinChi());
			try {
				mRepo.update(mEntity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("/BaiTap/mon");
		}

}
