package me.jamezrin.practicas.aahib3.persist.controller;

import java.math.BigDecimal;

import me.jamezrin.practicas.aahib3.persist.impl.AsistenciaDAOImpl;
import me.jamezrin.practicas.aahib3.persist.models.AsistenciaDAO;

public class AsistenciaController {
	private final AsistenciaDAO daoInstance = new AsistenciaDAOImpl();

	public void ej4() {
		daoInstance.findImporteGeq(10000)
			.forEach(System.out::println);
		System.out.println("^^^ Ejercicio 4 ejecutado ^^^");
	}

	public void ej5() {
		daoInstance.findImporteRange(8000, 15000)
			.forEach(System.out::println);
		System.out.println("^^^ Ejercicio 5 ejecutado ^^^");
	}

	public void ej6() {
		BigDecimal sum = daoInstance.sumAllImportes();
		System.out.printf("Suma de todos los importes: %s\n", sum);
		System.out.println("^^^ Ejercicio 6 ejecutado ^^^");
	}

	public void ej7() {
		Double avg = daoInstance.avgAllImportes();
		System.out.printf("Media de todos los importes: %f\n", avg);
		System.out.println("^^^ Ejercicio 7 ejecutado ^^^");
	}
}
