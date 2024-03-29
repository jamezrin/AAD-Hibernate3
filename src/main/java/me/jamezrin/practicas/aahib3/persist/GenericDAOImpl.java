package me.jamezrin.practicas.aahib3.persist;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import me.jamezrin.practicas.aahib3.utils.Utilidades;

public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {
	private final static Logger LOGGER = Logger.getLogger(GenericDAOImpl.class.getName());

	@Override
	public void persist(T entity) {
		EntityManager em = null;
		LOGGER.log(Level.INFO, "persisting instance");
		try {
			em = Utilidades.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			LOGGER.log(Level.INFO, "persist successful");
		} catch (RuntimeException e) {
			if (em != null) {
				em.getTransaction().rollback();
				LOGGER.log(Level.WARNING, "persist failed", e);
			}
			throw e;
		} catch (Exception e) {
			if (em != null) {
				em.getTransaction().rollback();
				LOGGER.log(Level.WARNING, "persist failed", e);
			}
			throw new RuntimeException(e);
		}
	}

	@Override
	public void merge(T entity) {
		EntityManager em = null;
		LOGGER.log(Level.INFO, "merging instance");
		try {
			em = Utilidades.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			LOGGER.log(Level.INFO, "merge successful");
		} catch (RuntimeException e) {
			if (em != null) {
				em.getTransaction().rollback();
				LOGGER.log(Level.WARNING, "merge failed", e);
			}
			throw e;
		} catch (Exception e) {
			if (em != null) {
				em.getTransaction().rollback();
				LOGGER.log(Level.WARNING, "merge failed", e);
			}
			throw new RuntimeException(e);
		}
	}

	@Override
	public T findById(ID id) {
		EntityManager em = null;
		LOGGER.log(Level.INFO, "finding instance");
		try {
			em = Utilidades.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			T entity = (T) em.find(getEntityClass(), id);
			em.getTransaction().commit();
			LOGGER.log(Level.INFO, "find successful");
			return entity;
		} catch (RuntimeException e) {
			if (em != null) {
				em.getTransaction().rollback();
				LOGGER.log(Level.WARNING, "findById failed", e);
			}
			throw e;
		} catch (Exception e) {
			if (em != null) {
				em.getTransaction().rollback();
				LOGGER.log(Level.WARNING, "findById failed", e);
			}
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remove(ID id) {
		EntityManager em = null;
		LOGGER.log(Level.INFO, "removing instance");
		try {
			em = Utilidades.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			T entity = (T) em.find(getEntityClass(), id);
			if (entity == null) {
				throw new RuntimeException("Los datos a borrar ya no existen");
			}
			em.remove(entity);
			LOGGER.log(Level.INFO, "remove successful");
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			if (em != null) {
				em.getTransaction().rollback();
				LOGGER.log(Level.WARNING, "findById failed", e);
			}
			throw e;
		} catch (Exception e) {
			if (em != null) {
				em.getTransaction().rollback();
				LOGGER.log(Level.WARNING, "findById failed", e);
			}
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<T> findAll() {
		EntityManager em = null;
		LOGGER.log(Level.INFO, "find all");
		try {
			em = Utilidades.getEntityManagerFactory().createEntityManager();
			Query query = em.createQuery("SELECT e FROM " + getEntityClass().getName() + " e");

			@SuppressWarnings("unchecked")
			List<T> entities = query.getResultList();

			LOGGER.log(Level.INFO, "remove successful");
			return entities;
		} catch (RuntimeException e) {
			if (em != null) {
				em.getTransaction().rollback();
				LOGGER.log(Level.WARNING, "findById failed", e);
			}
			throw e;
		} catch (Exception e) {
			if (em != null) {
				em.getTransaction().rollback();
				LOGGER.log(Level.WARNING, "findById failed", e);
			}
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
