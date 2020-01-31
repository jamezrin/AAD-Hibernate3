package me.jamezrin.practicas.aahib3.persist.models;

import java.util.List;

import me.jamezrin.practicas.aahib3.model.Seguro;
import me.jamezrin.practicas.aahib3.persist.GenericDAO;

public interface SeguroDAO extends GenericDAO<Seguro, Integer> {
	public List<Object[]> getAllNifsAndNames();
	
	public String getNifOf(String nombre, String ape1, String ape2);
	
	public Long countAllSeguros();
	
	public List<Object[]> getAllSeguroAsistenciasCount();
	
	public List<Object[]> getAllSeguroAlergias();
	
	public List<Seguro> getAllSeguroAsistenciasId();
}
