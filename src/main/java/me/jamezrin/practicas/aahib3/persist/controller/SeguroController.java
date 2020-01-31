package me.jamezrin.practicas.aahib3.persist.controller;

import me.jamezrin.practicas.aahib3.persist.impl.SeguroDAOImpl;
import me.jamezrin.practicas.aahib3.persist.models.SeguroDAO;

public class SeguroController {
	private final SeguroDAO daoInstance = new SeguroDAOImpl();
	
	public void ej1() {
		daoInstance.findAll().forEach(System.out::println);
		System.out.println("^^^ Ejercicio 1 ejecutado ^^^\n");
	}
	
	public void ej2() {
		daoInstance.getAllNifsAndNames().forEach(arr -> {
			System.out.printf("%s %s\n", arr[0], arr[1]);
		});
		System.out.println("^^^ Ejercicio 2 ejecutado ^^^\n");
	}
	
	public void ej3() {
		String nif = daoInstance.getNifOf("maria", "garcia", "lozano");
		System.out.printf("NIF de maria garcia lozano: %s\n", nif);
		System.out.println("^^^ Ejercicio 3 ejecutado ^^^\n");
	}
	
	public void ej8() {
		Long count = daoInstance.countAllSeguros();
		System.out.printf("Cantidad de seguros: %d\n", count);
		System.out.println("^^^ Ejercicio 8 ejecutado ^^^\n");
	}
	
	public void ej9() {
		daoInstance.getAllSeguroAsistenciasCount().forEach(arr -> {
			System.out.printf("nombre: %s, nif: %s, asistencias: %d\n", 
					arr[0], arr[1], arr[2]);
		});
		System.out.println("^^^ Ejercicio 9 ejecutado ^^^\n");
	}
	
	public void ej10() {
		daoInstance.getAllSeguroAlergias().forEach(arr -> {
			System.out.printf("nombre: %s, nif: %s, alergia: %s\n", 
					arr[0], arr[1], arr[2]);
		});
		System.out.println("^^^ Ejercicio 10 ejecutado ^^^\n");
	}
	
	public void ej11() {
		daoInstance.getAllSeguroAsistenciasId().forEach(seguro -> {
			System.out.printf("seguro: %s\n", seguro);
			seguro.getAsistencias().forEach(asistencia -> {
				System.out.printf("  asistencia %d\n", asistencia.getId());
			});
		});
		System.out.println("^^^ Ejercicio 11 ejecutado ^^^\n");
	}
}
