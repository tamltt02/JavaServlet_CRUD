package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Entities.Lop;
import Entities.SinhVien;
import Entities.SinhVienLop;
import Reponsitory.ChuyenNganhReponsitoy;
import Reponsitory.LopResponsitory;
import Reponsitory.SVLopReponsitory;
import Reponsitory.SinhVienRepository;
import Utils.EncryptUtil;

/**
 * Servlet implementation class SinhVienLop
 */
@MultipartConfig
@WebServlet({"/sv-lop","/sv-lop/search","/sv-lop/them","/sv-lop/delete","/sv-lop/update",
	"/sv-lop/import","/sv-lop/taimau","/sv-lop/export"})
public class SinhVienLopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIRECTORY = "upload";
	  public static final String DEFAULT_FILENAME = "default.file";
	private SinhVienRepository svRepo;
	LopResponsitory LopPepo = new LopResponsitory();
	SVLopReponsitory svlopRepo = new SVLopReponsitory();
	ChuyenNganhReponsitoy cnRepo = new ChuyenNganhReponsitoy();
	List<Entities.Lop> dsl = new ArrayList<Entities.Lop>();
	List<Entities.SinhVien> dssv = new ArrayList<Entities.SinhVien>();
	List<Entities.SinhVienLop> dssvLOp = new ArrayList<Entities.SinhVienLop>();
	Lop _lop = new Lop();
	public SinhVienLopServlet() {
		super();
		// TODO Auto-generated constructor stub
		this.svRepo = new SinhVienRepository();
		 this.LopPepo = new LopResponsitory();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("them")) {
			this.them(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		}
	 else if (uri.contains("search")) {
		this.search(request, response, Integer.parseInt(request.getParameter("lop")));
	 }
	 else if (uri.contains("update")) {
			this.update(request, response);
		 }
	 else if (uri.contains("import")) {
			this.importtv(request, response);
		 }
	 else if (uri.contains("export")) {
			this.export(request, response);
		 }
	 else if (uri.contains("taimau")) {
			this.taimau(request, response);
		 }
	else  {
			doGetindex(request, response);
		}
	}

	protected void doGetindex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		dsl = LopPepo.getAll();
		dssv = new ArrayList<Entities.SinhVien>();
		Lop lop = new Lop();
		request.setAttribute("dsl", dsl);
		request.setAttribute("lop", lop);
		request.setAttribute("dssv", dssv);
		request.setAttribute("user", "sv-lop");
		request.setAttribute("view", "/views/sinhvien-lop/detail.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("search")) {
			this.search(request, response, Integer.parseInt(request.getParameter("lop")));
		} else if (uri.contains("update")) {
			this.update(request, response);
		}else if (uri.contains("import")) {
			this.importtv(request, response);
		 }
	}
	protected void search(HttpServletRequest request, HttpServletResponse response,int id)
			throws ServletException, IOException {
	
		System.out.println(id);
		Lop lop = new Lop();
		lop = _lop;
		_lop = LopPepo.findById(id);
		System.out.println(_lop.getId());
	
		request.setAttribute("lop", _lop);
		dssvLOp =svlopRepo.getSVTrong(id);
		dssv = svlopRepo.getSVNgoai(_lop.getId());	
		dsl = LopPepo.getAll();
		request.setAttribute("dsl", dsl);
			request.setAttribute("lop", _lop);
			request.setAttribute("dssv", dssv);
			request.setAttribute("dssvlop", dssvLOp);
			request.setAttribute("user", "sv-lop");
			request.setAttribute("view", "/views/sinhvien-lop/detail.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);

		
	}
	protected void them(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idsv = Integer.parseInt(request.getParameter("idsv"));
		SinhVienRepository svRepo = new SinhVienRepository();
		SinhVien sv = new SinhVien();
		sv = svRepo.findById(idsv);
		SinhVienLop svLop = new SinhVienLop();
		System.out.println(_lop.getId());
		svLop.setLop(_lop);
		svLop.setSinhVien(sv);
		svLop.setDiemTb(0);
		svLop.setTrangThai(0);
		SVLopReponsitory svlopRepo = new SVLopReponsitory();
		try {
	
			svlopRepo.insert(svLop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		search(request, response,_lop.getId());
		
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idsvl = Integer.parseInt(request.getParameter("idsvl"));
		SinhVienLop svLop = new SinhVienLop();
		svLop = svlopRepo.findById(idsvl);
		dssv.add(svLop.getSinhVien());
		try {
			svlopRepo.delete(svLop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		search(request, response,_lop.getId());
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idsvl = Integer.parseInt(request.getParameter("idsvl"));
		SinhVienLop svLop = new SinhVienLop();
		svLop = svlopRepo.findById(idsvl);
		double dtb = Double.parseDouble(request.getParameter("diemTb"));
		if(dtb > 0 & dtb <= 10 ) {
		svLop.setDiemTb(dtb);
		}else {
			request.setAttribute("error", "Sai rồi");
			
		}
		try {
			svlopRepo.update(svLop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		search(request, response,_lop.getId());
		
}
	
    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return DEFAULT_FILENAME;
    }
	protected void importtv(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		if(request.getParameter("lop") == null ) {
//			System.out.println("Chưa chọn lớp ");
//			request.setAttribute("error", "Chưa chọn lớp");
//			this.doGetindex(request, response);
//			return;
//		}
	    String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists())
            uploadDir.mkdir();
        String fileName = "";
        try {       
            for (Part part : request.getParts()) {            	
                fileName = getFileName(part);
                System.out.println(fileName);
                part.write(uploadPath + File.separator + fileName);             
            }           
        } catch (FileNotFoundException fne) {
            
        }
		InputStream inp;
		try {
			inp = new FileInputStream(uploadPath + File.separator + fileName);
			XSSFWorkbook wb = new XSSFWorkbook(inp);
			XSSFSheet sheet = wb.getSheetAt(0);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				XSSFRow   row = sheet.getRow(i);
						Integer id = (int) row.getCell(0).getNumericCellValue();					
						String hoten = row.getCell(1).getStringCellValue();
						Double dtb =Double.valueOf( row.getCell(2).getNumericCellValue());
						if(id == null || hoten.isEmpty() || String.valueOf(dtb).isEmpty()) {
							System.out.println("id k rỗng");
							request.setAttribute("error", "Có dữ liệu null");
							search(request, response,_lop.getId());
							return;
						}
											
					try {
						if(dssvLOp.isEmpty()) {
							SinhVienLop sv = new SinhVienLop();
							sv.setSinhVien(svRepo.findById(id));	
							sv.setLop(_lop);
							sv.setDiemTb(dtb);
							sv.setTrangThai(0);
							svlopRepo.insert(sv);							
							
						}
						for (SinhVienLop svl : dssvLOp) {		
							if(svl.getSinhVien().getId() == id) {							
								System.out.println("trùng");
								svl = svlopRepo.findById(svl.getId());
								svl.setDiemTb(dtb);
								svlopRepo.update(svl);
							
							
							}
				
						}
					
						
					} catch (Exception e) {
						
					}
			}
			wb.close();
			search(request, response,_lop.getId());
		} catch (FileNotFoundException e) {
		System.out.println("k thấy file");
			e.printStackTrace();
		}	
}
	
	protected void taimau(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/vnd.ms-exel");
		response.setHeader("Content-Disposition", "attachment;filename=Mau.xlsx");
		   XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("danhsach");
	        XSSFRow row = null;
	        Cell cell = null;
	        row = sheet.createRow(0);
	        cell = row.createCell(0, CellType.STRING);
	        cell.setCellValue("ID");
	        cell = row.createCell(1, CellType.STRING);
	        cell.setCellValue("Họ tên");
	        cell = row.createCell(2, CellType.STRING);
	        cell.setCellValue("Diểm Tb");
	        cell = row.createCell(3, CellType.STRING);
	        cell.setCellValue("Địa chỉ");
	        try {
	                workbook.write(response.getOutputStream());	               
	                workbook.close();
	            	search(request, response,_lop.getId());
	        } catch (Exception ex) {
	        	System.out.println("Lỗi");
	        	ex.printStackTrace();
	        }
	}
	
	protected void export(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/vnd.ms-exel");
		response.setHeader("Content-Disposition", "attachment;filename=tam.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("List Sinh Viên Trong Lớp");
			int rownum = 0;
			Cell cell;
			Row row;
			row = sheet.createRow(rownum);

			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue("ID");
	
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue("Họ tên");
	

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue("Địa chỉ");
		
			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue("Email");
		

			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue("Giới tính");
		

			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue("SĐT");
		

			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue("Chuyên Ngành");
		

			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue("Điểm Trung Bình");
			
			for (SinhVienLop svl : svlopRepo.getSVTrong(_lop.getId())) {
				rownum++;
				row = sheet.createRow(rownum);

				cell = row.createCell(0, CellType.NUMERIC);
				cell.setCellValue(svl.getSinhVien().getId());

				cell = row.createCell(1, CellType.STRING);
				cell.setCellValue(svl.getSinhVien().getHoTen());

				cell = row.createCell(2, CellType.STRING);
				cell.setCellValue(svl.getSinhVien().getDiaChi());

				cell = row.createCell(3, CellType.STRING);
				cell.setCellValue(svl.getSinhVien().getEmail());

				cell = row.createCell(4, CellType.STRING);
				cell.setCellValue(svl.getSinhVien().getGioiTinh() == 1 ? "Nam" : "Nữ");

				cell = row.createCell(5, CellType.STRING);
				cell.setCellValue(svl.getSinhVien().getSdt());

				cell = row.createCell(6, CellType.STRING);
				cell.setCellValue(svl.getSinhVien().getChuyenNganh().getTen());

				cell = row.createCell(7, CellType.NUMERIC);
				cell.setCellValue(svl.getDiemTb());
			}
			try {
				
				workbook.write(response.getOutputStream());
				workbook.close();
			} catch (FileNotFoundException e) {
				System.out.println("không được");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("không được");
				e.printStackTrace();
			}
//			
//			search(request, response,_lop.getId());
		}
	
	
}

