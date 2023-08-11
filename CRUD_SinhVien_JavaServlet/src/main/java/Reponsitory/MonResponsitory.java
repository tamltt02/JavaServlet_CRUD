package Reponsitory;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import Entities.Mon;
import Utils.JPAUtils;

public class MonResponsitory {
	private EntityManager em;

	public MonResponsitory() {
		super();
		this.em = JPAUtils.getEntity();
	}

	public List<Mon> getAll() {
		String jpql = "select m  from Mon m";
		TypedQuery<Mon> query = em.createQuery(jpql, Mon.class);
		return query.getResultList();
	}

	public void insert(Mon monEntity) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(monEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	public void update(Mon monEntity) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(monEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	public void delete(Mon monEntity) throws Exception {
		try {
			em.getTransaction().begin();
			em.remove(monEntity);
			em.getTransaction().commit();
			System.out.println("aa");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	public Mon findById(int id){
		return em.find(Mon.class, id);

	}
}
