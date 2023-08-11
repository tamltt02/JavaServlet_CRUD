package Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sinh_vien_lop database table.
 * 
 */
@Entity
@Table(name="sinh_vien_lop")
@NamedQuery(name="SinhVienLop.findAll", query="SELECT s FROM SinhVienLop s")
public class SinhVienLop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="diem_tb")
	private double diemTb;

	@ManyToOne
	@JoinColumn(name = "lop_id")
	private Lop lop ;

	@ManyToOne
	@JoinColumn(name = "sinh_vien_id")
	private SinhVien sinhVien ;

	@Column(name="trang_thai")
	private int trangThai;

	public SinhVienLop() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDiemTb() {
		return this.diemTb;
	}

	public void setDiemTb(double diemTb) {
		this.diemTb = diemTb;
	}

	

	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public int getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

}