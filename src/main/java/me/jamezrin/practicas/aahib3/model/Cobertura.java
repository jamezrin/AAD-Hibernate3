package me.jamezrin.practicas.aahib3.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cobertura database table.
 * 
 */
@Entity
@Table(name="cobertura")
@NamedQuery(name="Cobertura.findAll", query="SELECT c FROM Cobertura c")
public class Cobertura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String dental;

	private String fecundacionInVitro;

	private String oftalmologia;

	//bi-directional many-to-one association to Seguro
	@OneToMany(mappedBy="cobertura")
	private List<Seguro> seguros;

	public Cobertura() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDental() {
		return this.dental;
	}

	public void setDental(String dental) {
		this.dental = dental;
	}

	public String getFecundacionInVitro() {
		return this.fecundacionInVitro;
	}

	public void setFecundacionInVitro(String fecundacionInVitro) {
		this.fecundacionInVitro = fecundacionInVitro;
	}

	public String getOftalmologia() {
		return this.oftalmologia;
	}

	public void setOftalmologia(String oftalmologia) {
		this.oftalmologia = oftalmologia;
	}

	public List<Seguro> getSeguros() {
		return this.seguros;
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}

	public Seguro addSeguro(Seguro seguro) {
		getSeguros().add(seguro);
		seguro.setCobertura(this);

		return seguro;
	}

	public Seguro removeSeguro(Seguro seguro) {
		getSeguros().remove(seguro);
		seguro.setCobertura(null);

		return seguro;
	}

}