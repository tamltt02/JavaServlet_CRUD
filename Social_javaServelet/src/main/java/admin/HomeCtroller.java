package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import Constant.SessionAttr;
import Entitty.User;
import Service.StatusService;
import Service.StatusServiceImpl;
import Service.UserService;
import Service.userServiceImpl;
import dto.VideoLikedInfo;

/**
 * Servlet implementation class HomeCtroller
 */
@WebServlet({ "/admin", "/favorite" })
public class HomeCtroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userservice = new userServiceImpl();
	private StatusService statusService = new StatusServiceImpl();

	public HomeCtroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		User curentUser = userservice.findByUsername((String) sesion.getAttribute(SessionAttr.CURRENT_USER));
		if (curentUser != null && curentUser.getIsAdmin() == 1) {
			String path = request.getServletPath();
			switch (path) {
			case "/admin":
				doGetHome(request, response);
				break;
			case "/favorite":
				doGetFavorite(request, response);
				break;
			}
		} else {
			response.sendRedirect("HomeController");
		}

	}

	protected void doGetHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<VideoLikedInfo> video = statusService.findVideoLikedInfo();
		request.setAttribute("videos", video);
		request.getRequestDispatcher("views/admin/home.jsp").forward(request, response);
	}

	protected void doGetFavorite(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		String videoHref = request.getParameter("href");
		List<User> users = userservice.findUserByVideoHref(videoHref);
		if(users.isEmpty()) {
			response.setStatus(200);
		}else {
			ObjectMapper mapper = new ObjectMapper();
			String dataResponse = mapper.writeValueAsString(users);
			response.setStatus(200);
			out.print(dataResponse);
			out.flush();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
