package Reponsitory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entities.Lop;
import Entities.SinhVien;
import Utils.JPAUtils;

public class SinhVienRepository {
	private EntityManager em;

	public SinhVienRepository() {
		super();
		this.em = JPAUtils.getEntity();
	}

	public List<SinhVien> getAll() {
		String jpql = "select sv  from SinhVien sv";
		TypedQuery<SinhVien> query = em.createQuery(jpql, SinhVien.class);
		return query.getResultList();
	}

	public void insert(SinhVien svEntity) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(svEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	public void update(SinhVien svEntity) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(svEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	public void delete(SinhVien svEntity) throws Exception {
		try {
			em.getTransaction().begin();
			em.remove(svEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	public SinhVien findById(int id){
		return em.find(SinhVien.class, id);

	}
	public SinhVien findByEmail(String email) {

		try {
			String jpql = "select sv  from SinhVien sv where sv.email = ? 1 ";
			TypedQuery<SinhVien> query = em.createQuery(jpql, SinhVien.class);
			query.setParameter(1, email);
			return query.getSingleResult();
		} catch (Exception e) {
			System.out.println("k đúng ");
			return null ;
		}
	}

}
