package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entities.SinhVien;
import Reponsitory.SinhVienRepository;
import Utils.EncryptUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({"/login","/logout"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SinhVienRepository svRepo;
  
    public LoginServlet() {
        super();
        this.svRepo = new SinhVienRepository();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("login")) {
			request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
		} else if (uri.contains("logout")) {
//		logout(request, response);
		}  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("login")) {
			HttpSession session = request.getSession();
			String email = request.getParameter("email"),
				pass = request.getParameter("password");
			
			SinhVien sv = this.svRepo.findByEmail(email);
			if (sv != null ) {
				boolean check = EncryptUtil.check(pass, sv.getPassword());			
				if (check == true) {
					session.setAttribute("user", sv);
					response.sendRedirect("/BaiTap/sinh-vien");
				} else {				
					request.setAttribute("error", "Mật khẩu không đúng");      
					request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
					return;
				}
			
			}else {
				request.setAttribute("error", "Tài khoản không đúng");      
				request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
			}
			
		}
	
	}
//	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//				HttpSession session = request.getSession();
//				session.removeAttribute("user");
//				response.sendRedirect("/BaiTap/logout");
//	}
}
