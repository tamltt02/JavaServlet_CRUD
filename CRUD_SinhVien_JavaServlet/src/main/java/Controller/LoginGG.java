package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Entities.SinhVien;
import Model.GoogleModel;
import Reponsitory.SinhVienRepository;

/**
 * Servlet implementation class LoginGG
 */
@WebServlet("/LoginGG")
public class LoginGG extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String GOOGLE_CLIENT_ID = "783102032569-pq5lh3c8kkve7hvr3pu06jsnpn1a5u2v.apps.googleusercontent.com";

	public static String GOOGLE_CLIENT_SECRET = "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";
	

	public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/BaiTap/LoginGG";

	public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";

	public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";

	public static String GOOGLE_GRANT_TYPE = "authorization_code";
    /**
     * @see HttpServlet#HttpServlet()
     */
	SinhVienRepository svRepo = new SinhVienRepository();
	
    public LoginGG() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		System.out.println(code);
		String accessToken = getToken(code);
		GoogleModel user = getUserInfo(accessToken);
		HttpSession session = request.getSession();
		SinhVien sv = new SinhVien();
		sv= svRepo.findByEmail(user.getEmail());
		session.setAttribute("user", sv);
		if(sv != null) {
			response.sendRedirect("/BaiTap/sinh-vien");
			System.out.println(sv.getEmail());
		}else {
			System.out.println("k thấy");
			request.setAttribute("error", "Email không hợp lệ");      
			request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
			return;
		}
		
		
	}
    public static String getToken(String code) throws ClientProtocolException, IOException {
		// call api to get token
		String response = Request.Post(GOOGLE_LINK_GET_TOKEN)
				.bodyForm(Form.form().add("client_id",GOOGLE_CLIENT_ID)
						.add("client_secret", GOOGLE_CLIENT_SECRET)
						.add("redirect_uri",GOOGLE_REDIRECT_URI).add("code", code)
						.add("grant_type", GOOGLE_GRANT_TYPE).build())
				.execute().returnContent().asString();

		JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
		String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
		return accessToken;
	}

	public static GoogleModel getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
		String link = GOOGLE_LINK_GET_USER_INFO + accessToken;
		String response = Request.Get(link).execute().returnContent().asString();

		GoogleModel googlePojo = new Gson().fromJson(response, GoogleModel.class);

		return googlePojo;
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the +
	// sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
