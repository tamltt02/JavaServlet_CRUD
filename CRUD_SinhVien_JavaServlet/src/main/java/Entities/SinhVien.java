package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the sinh_vien database table.
 * 
 */
@Entity
@Table(name = "sinh_vien")
@NamedQuery(name = "SinhVien.findAll", query = "SELECT s FROM SinhVien s")
public class SinhVien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "avatar")
	private String avatar;

//	@Column(name = "chuyen_nganh_id")
//	private int chuyenNganhId;
	@ManyToOne
	@JoinColumn(name = "chuyen_nganh_id")
	private ChuyenNganh chuyenNganh ;

	@OneToMany(mappedBy = "sinhVien")
	private List<SinhVienLop> dsSVLop ;
	
	@Column(name = "dia_chi")
	private String diaChi;

	@Column(name = "email")
	private String email;

	@Column(name = "gioi_tinh")
	private int gioiTinh;

	@Column(name = "ho_ten")
	private String hoTen;

	@Column(name = "password")
	private String password;

	@Column(name = "sdt")
	private String sdt;

	public SinhVien() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public ChuyenNganh getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(ChuyenNganh chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGioiTinh() {
		return this.gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public List<SinhVienLop> getDsSVLop() {
		return dsSVLop;
	}

	public void setDsSVLop(List<SinhVienLop> dsSVLop) {
		this.dsSVLop = dsSVLop;
	}

}