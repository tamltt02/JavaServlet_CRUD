package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the lop database table.
 * 
 */
@Entity
@NamedQuery(name = "Lop.findAll", query = "SELECT l FROM Lop l")
public class Lop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "chuyen_nganh_id")
	private ChuyenNganh chuyenNganh ;

	@Column(name = "khoa")
	private int khoa;

	@ManyToOne
	@JoinColumn(name = "mon_id")
	private Mon mon ;
	
	@Column(name = "ten")
	private String ten;

	
	@OneToMany(mappedBy = "lop")
	private List<SinhVienLop> dsSVLop ;
	public Lop() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public ChuyenNganh getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(ChuyenNganh chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public int getKhoa() {
		return this.khoa;
	}

	public void setKhoa(int khoa) {
		this.khoa = khoa;
	}



	public Mon getMon() {
		return mon;
	}

	public void setMon(Mon mon) {
		this.mon = mon;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public List<SinhVienLop> getDsSVLop() {
		return dsSVLop;
	}

	public void setDsSVLop(List<SinhVienLop> dsSVLop) {
		this.dsSVLop = dsSVLop;
	}

}