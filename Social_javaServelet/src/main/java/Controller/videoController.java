package Controller;

import java.io.IOException;
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
 * Servlet implementation class videoController
 */
@WebServlet("/video")
public class videoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoService videoService = new VideoServiceimpl();
	private HistoryService historyService = new HistoryServiceIplm();
	private UserService userService = new userServiceImpl();
    public videoController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionParam = request.getParameter("action");
		String href = request.getParameter("id");
		HttpSession session = request.getSession();
		switch (actionParam) {
		case "watch":
			doGetWatch(session, href, request, response);
			break;
		case "like":
			doGetLike(session, href, request, response);
			break;

		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	protected void doGetWatch(HttpSession session ,String href,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Video video = videoService.findByHref(href);
			request.setAttribute("video", video);
			User currentUser = userService.findByUsername((String) session.getAttribute(SessionAttr.CURRENT_USER));
			if(currentUser != null ) {
				History history = historyService.create(currentUser, video);
				request.setAttribute("fagLikeBtn",history.getIsLiked());
			}
			request.getRequestDispatcher("views/user/video_detail.jsp").forward(request, response);
		
	}
	protected void doGetLike(HttpSession sesision ,String href,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		User currentUser = userService.findByUsername((String) sesision.getAttribute(SessionAttr.CURRENT_USER));
	boolean result = historyService.updateLikeOrUnlike(currentUser, href);
	if(result == true) {
		response.setStatus(204); //succed but no response data
	}else {
		response.setStatus(400);
	}
}
}
