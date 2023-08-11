package Reponsitory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entities.Lop;
import Entities.SinhVien;
import Entities.SinhVienLop;
import Utils.JPAUtils;

public class SVLopReponsitory {
	private EntityManager em;

	public SVLopReponsitory() {
		super();
		this.em = JPAUtils.getEntity();
	}

	public List<SinhVienLop> getAll() {
		String jpql = "select svLop  from SinhVienLop svLop";
		TypedQuery<SinhVienLop> query = em.createQuery(jpql, SinhVienLop.class);
		return query.getResultList();
	}

	public List<SinhVien> getSVNgoai(int idlop) {
//		//select sinh_vien.id FROM sinh_vien
//		 where sinh_vien.id not  in (select sinh_vien.id from sinh_vien_lop join sinh_vien on sinh_vien_lop.sinh_vien_id = sinh_vien.id where sinh_vien.id = sinh_vien_lop.sinh_vien_id
//	               )
		String jpql = "select sv FROM SinhVien sv"
				+ " where sv not  in (select sv from SinhVienLop svLop join SinhVien sv on svLop.sinhVien.id = sv.id where svLop.sinhVien.id = sv.id and  svLop.lop.id = ? 1  )";
		TypedQuery<SinhVien> query = em.createQuery(jpql, SinhVien.class);
		query.setParameter(1, idlop);
		return query.getResultList();
	}
	
	//select * FROM sinh_vien_lop where sinh_vien_lop.lop_id = 2
	public List<SinhVienLop> getSVTrong(int idlop) {
//		//select sinh_vien.id FROM sinh_vien
//		 where sinh_vien.id not  in (select sinh_vien.id from sinh_vien_lop join sinh_vien on sinh_vien_lop.sinh_vien_id = sinh_vien.id where sinh_vien.id = sinh_vien_lop.sinh_vien_id
//	               )
		String jpql = "select svLop  from SinhVienLop svLop where svLop.lop.id =? 1";
		
		TypedQuery<SinhVienLop> query = em.createQuery(jpql, SinhVienLop.class);
		query.setParameter(1, idlop);
		return query.getResultList();
	}
	

	public void insert(SinhVienLop svLop) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(svLop);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	public void update(SinhVienLop svLop) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(svLop);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	public void delete(SinhVienLop svLop) throws Exception {
		try {
			em.getTransaction().begin();
			em.remove(svLop);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	public SinhVienLop findById(int id){
		return em.find(SinhVienLop.class, id);

	}
	
	
	
}
