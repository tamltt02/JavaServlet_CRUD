package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the chuyen_nganh database table.
 * 
 */
@Entity
@Table(name = "chuyen_nganh")
@NamedQuery(name = "ChuyenNganh.findAll", query = "SELECT c FROM ChuyenNganh c")
public class ChuyenNganh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ten")
	private String ten;

	@OneToMany(mappedBy = "chuyenNganh")
	private List<Lop> dsLop ;
	
	@OneToMany(mappedBy = "chuyenNganh")
	private List<SinhVien> dsSv ;
	
	public ChuyenNganh() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public List<Lop> getDsLop() {
		return dsLop;
	}

	public void setDsLop(List<Lop> dsLop) {
		this.dsLop = dsLop;
	}

	public List<SinhVien> getDsSv() {
		return dsSv;
	}

	public void setDsSv(List<SinhVien> dsSv) {
		this.dsSv = dsSv;
	}

}