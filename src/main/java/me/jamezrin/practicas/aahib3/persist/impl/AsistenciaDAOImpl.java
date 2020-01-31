package me.jamezrin.practicas.aahib3.persist.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import me.jamezrin.practicas.aahib3.model.Asistencia;
import me.jamezrin.practicas.aahib3.persist.GenericDAOImpl;
import me.jamezrin.practicas.aahib3.persist.models.AsistenciaDAO;
import me.jamezrin.practicas.aahib3.utils.Utilidades;

public class AsistenciaDAOImpl extends GenericDAOImpl<Asistencia, Integer> implements AsistenciaDAO {
	private final EntityManager entityManager;
	
	public AsistenciaDAOImpl() {
		entityManager = Utilidades.getEntityManagerFactory().createEntityManager();
	}
	
	public List<Asistencia> findImporteGeq(int importe) {
		TypedQuery<Asistencia> query = entityManager.createQuery(
				"SELECT a FROM Asistencia a WHERE a.importe >= :importe", Asistencia.class);
		query.setParameter("importe", BigDecimal.valueOf(importe));
		return query.getResultList();
	}
	
	public List<Asistencia> findImporteRange(int importeBajo, int importeAlto) {
		TypedQuery<Asistencia> query = entityManager.createQuery(
				"SELECT a FROM Asistencia a WHERE a.importe >= :importe_bajo "
				+ "AND a.importe <= :importe_alto", Asistencia.class);
		query.setParameter("importe_bajo", BigDecimal.valueOf(importeBajo));
		query.setParameter("importe_alto", BigDecimal.valueOf(importeAlto));
		return query.getResultList();
	}
	
	public BigDecimal sumAllImportes() {
		TypedQuery<BigDecimal> query = entityManager.createQuery(
				"SELECT SUM(a.importe) AS importe_sum FROM Asistencia a", BigDecimal.class);
		return query.getSingleResult();
	}
	
	public Double avgAllImportes() {
		TypedQuery<Double> query = entityManager.createQuery(
				"SELECT AVG(a.importe) AS importe_avg FROM Asistencia a", Double.class);
		return query.getSingleResult();
	}
}
