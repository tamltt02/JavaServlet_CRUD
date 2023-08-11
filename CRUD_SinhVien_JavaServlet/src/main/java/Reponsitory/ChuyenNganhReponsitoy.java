package Reponsitory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entities.ChuyenNganh;
import Utils.JPAUtils;

public class ChuyenNganhReponsitoy {
	private EntityManager em;
	public ChuyenNganhReponsitoy() {
		super();
		this.em = JPAUtils.getEntity();
	}

	public List<ChuyenNganh> getAll() {
		String jpql = "select cn  from ChuyenNganh cn";
		TypedQuery<ChuyenNganh> query = em.createQuery(jpql, ChuyenNganh.class);
		return query.getResultList();
	}

	
	public ChuyenNganh findCNbyName(String name) {
		try {
			String jpql = "select cn  from ChuyenNganh cn where cn.ten = ? 1";
			TypedQuery<ChuyenNganh> query = em.createQuery(jpql, ChuyenNganh.class);
			query.setParameter(1, name);
			return query.getSingleResult();
		} catch (Exception e) {
			return null ;
		}
	}
	
	public void insert(ChuyenNganh cnEntity) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(cnEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	public void update(ChuyenNganh cnEntity) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(cnEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	public void delete(ChuyenNganh cnEntity) throws Exception {
		try {
			em.getTransaction().begin();
			em.remove(cnEntity);
			em.getTransaction().commit();
			System.out.println("aa");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	public ChuyenNganh findById(int id){
		return em.find(ChuyenNganh.class, id);

	}
}
