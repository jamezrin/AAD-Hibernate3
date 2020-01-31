package me.jamezrin.practicas.aahib3.persist.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import me.jamezrin.practicas.aahib3.model.Seguro;
import me.jamezrin.practicas.aahib3.persist.GenericDAOImpl;
import me.jamezrin.practicas.aahib3.persist.models.SeguroDAO;
import me.jamezrin.practicas.aahib3.utils.Utilidades;

public class SeguroDAOImpl extends GenericDAOImpl<Seguro, Integer> implements SeguroDAO {
	private final EntityManager entityManager;
	
	public SeguroDAOImpl() {
		entityManager = Utilidades.getEntityManagerFactory().createEntityManager();
	}
	
	public List<Object[]> getAllNifsAndNames() {
		TypedQuery<Object[]> query = entityManager.createQuery(
				"SELECT s.nif, s.nombre FROM Seguro s", Object[].class);
		return query.getResultList();
	}
	
	public String getNifOf(String nombre, String ape1, String ape2) {
		TypedQuery<String> query = entityManager.createQuery(
				"SELECT s.nif FROM Seguro s WHERE s.nombre = :nombre "
				+ "AND s.ape1 = :ape1 AND s.ape2 = :ape2", String.class);
		query.setParameter("nombre", nombre);
		query.setParameter("ape1", ape1);
		query.setParameter("ape2", ape2);
		return query.getSingleResult();
	}
	
	public Long countAllSeguros() {
		TypedQuery<Long> query = entityManager.createQuery(
				"SELECT COUNT(s) AS seguro_count FROM Seguro s", Long.class);
		return query.getSingleResult();
	}
	
	public List<Object[]> getAllSeguroAsistenciasCount() {
		TypedQuery<Object[]> query = entityManager.createQuery(
				"SELECT s.nombre, s.nif, COUNT(a) AS asistencia_count FROM Seguro s "
				+ "LEFT JOIN Asistencia a ON s.id = a.seguro GROUP BY s.id", Object[].class);
		return query.getResultList();
	}
	
	public List<Object[]> getAllSeguroAlergias() {
		TypedQuery<Object[]> query = entityManager.createQuery(
				"SELECT s.nombre, s.nif, e.nombreAlergia FROM Seguro s "
				+ "LEFT JOIN Enfermedad e ON s.enfermedad = e.id", Object[].class);
		return query.getResultList();
	}
	
	public List<Seguro> getAllSeguroAsistenciasId() {
		TypedQuery<Seguro> query = entityManager.createQuery(
				"SELECT s FROM Seguro s "
				+ "JOIN Asistencia a ON s.id = a.seguro", Seguro.class);
		return query.getResultList();
	}
}
