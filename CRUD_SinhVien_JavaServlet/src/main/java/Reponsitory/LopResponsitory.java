package Reponsitory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entities.Lop;
import Utils.JPAUtils;

public class LopResponsitory {
	EntityManager em;

	public LopResponsitory() {
		em = JPAUtils.getEntity();
	}
	
	public void insert (Lop lop) throws Exception{
		try {
			em.getTransaction().begin();
			em.persist(lop);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	public void update (Lop lop) throws Exception{
		try {
			em.getTransaction().begin();
			em.merge (lop);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	public void delete (Lop lop) throws Exception{
		try {
			em.getTransaction().begin();
			em.remove (lop);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	public List<Lop> getAll (){
		String jpql = "SELECT l FROM Lop l";
		TypedQuery<Lop> query = em.createQuery(jpql,Lop.class);
		return query.getResultList();
	}
	
	public Lop getlopbyName(String name) {

		String jpql = "select l  from Lop l where l.ten = ? 1";
		TypedQuery<Lop> query = em.createQuery(jpql, Lop.class);
		query.setParameter(1, name);
		return query.getSingleResult();
	}
	public Lop findById (int id) {
		return em.find(Lop.class, id);
	}
}
