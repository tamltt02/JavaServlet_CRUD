package Controller;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Constant.SessionAttr;
import Dao.UserDao;
import Entitty.User;
import Service.EmailSerVice;
import Service.EmailServiceImpl;
import Service.UserService;
import Service.VideoService;
import Service.VideoServiceimpl;
import Service.userServiceImpl;
import Utils.SendEmail;

/**
 * Servlet implementation class userController
 */
@WebServlet({ "/login", "/logout", "/register" ,"/forgot","/changePass"})
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new userServiceImpl();
	private EmailSerVice senmail = new EmailServiceImpl();

	public userController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/login":
			doGetlogin(request, response);
			break;
		case "/register":
			doGetRegister(request, response);
			break;
		case "/logout":
			dogetLogout(sesion, request, response);
			break;
		case "/forgot":
			dogetForgot(sesion, request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/login":
			doPostLogin(session, request, response);
			break;
		case "/register":
			doPostRegister( request, response);
			break;
		case "/forgot":
			doPostForget( request, response);
			break;
		case "/changePass":
			doPostChangePass(session, request, response);
			break;
		}
		
	}

	protected void doGetlogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
	}

	protected void doGetRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
	}
	protected void dogetLogout(HttpSession session,HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session.removeAttribute(SessionAttr.CURRENT_USER);
		response.sendRedirect("HomeController");
	}
	protected void dogetForgot(HttpSession session,HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/forgot-pass.jsp").forward(request, response);
	}

	protected void doPostLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.login(username, password);
		if (user != null) {
			session.setAttribute(SessionAttr.CURRENT_USER, username);
			response.sendRedirect("HomeController");
		} else {
			response.sendRedirect("login");
		}
	}
	protected void doPostRegister( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User user = userService.create(username, password, email);
		if (user != null) {
			senmail.sendEmail(getServletContext(), user, "welcome");
			response.sendRedirect("HomeController");
		} else {
			response.sendRedirect("register");
		}
	}
	
	protected void doPostForget( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		User user = userService.resetPasssword(email);
		if(user != null) {
			senmail.sendEmail(getServletContext(), user, "forgot");
			request.setAttribute("message", "Guwri mail tc");
			try{
			    Thread.sleep(3000);
			    response.sendRedirect("HomeController");
			}catch(InterruptedException e){
			    e.printStackTrace();
			}			
		}else {
			response.sendRedirect("register");
			request.setAttribute("error", "K dung thong tin ");
		}
		
		
	}
	
	protected void doPostChangePass( HttpSession session,HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		String currentPass = request.getParameter("currentPass");
		String newpass = request.getParameter("newPass");
		User currentUser = userService.findByUsername((String) session.getAttribute(SessionAttr.CURRENT_USER));
			if(currentUser.getPassword().equals(currentPass)) {
				currentUser.setPassword(newpass);
				User updateUser = userService.update(currentUser);
							if(updateUser != null) {
								session.setAttribute(SessionAttr.CURRENT_USER, updateUser);
								response.setStatus(204);
							}else {
								response.setStatus(400);
							}		
			}else {
				response.setStatus(400);
			}
	}
}
