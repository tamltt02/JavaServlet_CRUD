package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Constant.SessionAttr;
import Entitty.History;
import Entitty.User;
import Entitty.Video;
import Service.HistoryService;
import Service.HistoryServiceIplm;
import Service.UserService;
import Service.VideoService;
import Service.VideoServiceimpl;
import Service.userServiceImpl;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({ "/HomeController", "/favorites", "/history" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoService videoservice = new VideoServiceimpl();
	private HistoryService historyService = new HistoryServiceIplm();
	private UserService userService = new userServiceImpl();
	private static final int Video_max_size = 2;
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/HomeController":
			doGetIndex(request, response);
			break;
		case "/favorites":
			doGetFavorite(sesion, request, response);
			break;
		case "/history":
			doGetHistory(sesion, request, response);
			break;
			
		}
	}

	protected void doGetIndex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Video> countvideo = videoservice.findAll();
		int maxPage = (int) Math.ceil(countvideo.size() / ( double ) Video_max_size);
		request.setAttribute("maxPage", maxPage);
		String pageNumber = request.getParameter("page");
		List<Video> videos ;
		if(pageNumber == null  || Integer.valueOf(maxPage) <  Integer.valueOf(pageNumber)) {
			videos = videoservice.findAll(1, Video_max_size) ;
			request.setAttribute("currentPage", 1);
		}else {
			videos = videoservice.findAll(Integer.parseInt(pageNumber), Video_max_size) ;
			request.setAttribute("currentPage", Integer.valueOf(pageNumber));
		}
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("/views/user/index.jsp").forward(request, response);
	}

	protected void doGetFavorite(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User currentUser = userService.findByUsername((String) session.getAttribute(SessionAttr.CURRENT_USER));

		List<History> histories = historyService.findByUserAnhIsLiked(currentUser.getUsername());
		List<Video> videos = new ArrayList<Video>();
		histories.forEach(item -> videos.add(item.getVideo()));
//	for (History item : histories) {
//		videos.add(item.getVideo());
//	}
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("/views/user/favorites.jsp").forward(request, response);
	}

	protected void doGetHistory(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User currentUser = userService.findByUsername((String) session.getAttribute(SessionAttr.CURRENT_USER));

		List<History> histories = historyService.findByUser(currentUser.getUsername());
		List<Video> videos = new ArrayList<Video>();
		histories.forEach(item -> videos.add(item.getVideo()));
//	for (History item : histories) {
//		videos.add(item.getVideo());
//	}
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("/views/user/history.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
