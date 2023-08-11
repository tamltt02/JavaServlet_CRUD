package Dao;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import Utils.JpaUtil;

public class AbstracDao<T> {
	public static final EntityManager entityManager = JpaUtil.getEntity();

	public T findByID(Class<T> clazz, Integer id) {
		return entityManager.find(clazz, id);
	}

	public List<T> findAll(Class<T> clazz, Boolean exitIsActive) {
		String entityname = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("select o from ").append(entityname).append(" o");
		if (exitIsActive == true) {
			sql.append(" where o.isActive = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sql.toString(), clazz);
		return query.getResultList();
	}

	public List<T> findAll(Class<T> clazz, Boolean exitIsActive, int pageNumber, int pageSize) {
		String entityname = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("select o from ").append(entityname).append(" o");
		if (exitIsActive == true) {
			sql.append(" where isActive = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sql.toString(), clazz);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();

	}

	public T findone(Class<T> clazz, String sql, Object... params) {
		TypedQuery<T> query = entityManager.createQuery(sql, clazz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<T> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

	public List<T> findmany(Class<T> clazz, String sql, Object... params) {
		TypedQuery<T> query = entityManager.createQuery(sql, clazz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}

	public List<Object[]> findManyNativeQuery( String sql, Object... params) {
		Query query = entityManager.createQuery(sql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}

	public T create(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public T update(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public T delete(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> callStore(String nameStored , Map<String, Object> params){
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery(nameStored);
		params.forEach((key,value) -> query.setParameter(key, value));
		return (List<T>) query.getResultList();
	}
}
