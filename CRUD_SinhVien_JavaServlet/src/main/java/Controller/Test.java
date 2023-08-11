package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.cj.Constants;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet("/multiPartServlet")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIRECTORY = "upload";
	  public static final String DEFAULT_FILENAME = "default.file";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
    {
    	request.getRequestDispatcher("/views/exel.jsp").forward(request, response);
    }
    
    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return DEFAULT_FILENAME;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists())
            uploadDir.mkdir();

        try {
            String fileName = "";
            for (Part part : request.getParts()) {
            	System.out.println(request.getParts().toString());
                fileName = getFileName(part);
                part.write(uploadPath + File.separator + fileName);
                System.out.println(uploadPath);
                System.out.println(uploadPath + File.separator + fileName);
                System.out.println(fileName);
            }
         
            request.setAttribute("message", "File " + fileName + " has uploaded successfully!");
        } catch (FileNotFoundException fne) {
            request.setAttribute("message", "There was an error: " + fne.getMessage());
        }
        getServletContext().getRequestDispatcher("/views/exel.jsp").forward(request, response);
    }
    
    protected void export(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("application/octet-stream");
     
}
}
