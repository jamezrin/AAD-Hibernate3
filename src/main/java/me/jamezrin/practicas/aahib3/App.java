package me.jamezrin.practicas.aahib3;

import javax.persistence.EntityManager;

import me.jamezrin.practicas.aahib3.persist.controller.AsistenciaController;
import me.jamezrin.practicas.aahib3.persist.controller.SeguroController;
import me.jamezrin.practicas.aahib3.utils.Utilidades;

public class App {
	public static void main(String[] args) {
		EntityManager em = null;
		
		try {
			em = Utilidades.getEntityManagerFactory().createEntityManager();
			
			SeguroController sc = new SeguroController();
			AsistenciaController ac = new AsistenciaController();
			
			sc.ej1();
			sc.ej2();
			sc.ej3();
			ac.ej4();
			ac.ej5();
			ac.ej6();
			ac.ej7();
			sc.ej8();
			sc.ej9();
			sc.ej10();
			sc.ej11();
		} catch (Exception e) {
			e.printStackTrace();
			if (em != null) {
				System.err.println("Haciendo rollback de la transaccion...");
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
		Utilidades.closeEntityManagerFactory();
	}
}
