package admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import Constant.SessionAttr;
import Entitty.User;
import Entitty.Video;
import Service.UserService;
import Service.VideoService;
import Service.VideoServiceimpl;
import Service.userServiceImpl;

/**
 * Servlet implementation class VideoController
 */
@WebServlet({"/view","/delete","/neworupdate","/neworupdate/add"})
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userservice = new userServiceImpl();
	private VideoService videoService = new VideoServiceimpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		User curentUser = userservice.findByUsername((String) sesion.getAttribute(SessionAttr.CURRENT_USER));
		if (curentUser != null && curentUser.getIsAdmin() == 1) {
			String url = request.getRequestURI();
			if (url.contains("view")) {
				doGetView(request, response);
			} else if (url.contains("delete")) {
				doGetDelete(request, response);
				doGetView(request, response);
			}else if (url.contains("neworupdate")) {
			doGetnewOrUpdate(request, response);
				}
			
		} else {
			response.sendRedirect("HomeController");
		}
		
	}

	protected void doGetView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Video> videos = videoService.findAll();
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("views/admin/video.jsp").forward(request, response);
	}

	protected void doGetDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String href = request.getParameter("href");
	 videoService.delete(href);
	}
	protected void doGetnewOrUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/admin/video-edit.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		User curentUser = userservice.findByUsername((String) sesion.getAttribute(SessionAttr.CURRENT_USER));
		if (curentUser != null && curentUser.getIsAdmin() == 1) {
			String url = request.getRequestURI();
			if (url.contains("delete")) {
				doGetDelete(request, response);
			} else if(url.contains("add")) {		
				doPosaddt(request, response);
			}
			response.sendRedirect("neworupdate");
		} else {
			response.sendRedirect("HomeController");
		}
	}
	protected void doPosaddt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Video video = new Video();
		try {
			String title = request.getParameter("title");
			
			String poster = request.getParameter("poster");
			String description = request.getParameter("description");
			String href = request.getParameter("href");
			video.setHref(href);
			video.setPoster(poster);
			video.setDescription(description);
			video.setTitle(title);
			System.out.println(poster);
//			BeanUtils.populate(video, request.getParameterMap());
			videoService.create(video);
			
			request.getRequestDispatcher("views/admin/video-edit.jsp").forward(request, response);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
