package me.jamezrin.practicas.aahib3.persist.models;

import java.math.BigDecimal;
import java.util.List;

import me.jamezrin.practicas.aahib3.model.Asistencia;
import me.jamezrin.practicas.aahib3.persist.GenericDAO;

public interface AsistenciaDAO extends GenericDAO<Asistencia, Integer> {
	public List<Asistencia> findImporteGeq(int importe);
	
	public List<Asistencia> findImporteRange(int importeBajo, int importeAlto);
	
	public BigDecimal sumAllImportes();
	
	public Double avgAllImportes();
}
