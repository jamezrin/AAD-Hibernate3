package me.jamezrin.practicas.aahib3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


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

	@Type(type = "true_false")
	private boolean dental;

	@Type(type = "true_false")
	private boolean fecundacionInVitro;

	@Type(type = "true_false")
	private boolean oftalmologia;

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

	public boolean getDental() {
		return this.dental;
	}

	public void setDental(boolean dental) {
		this.dental = dental;
	}

	public boolean getFecundacionInVitro() {
		return this.fecundacionInVitro;
	}

	public void setFecundacionInVitro(boolean fecundacionInVitro) {
		this.fecundacionInVitro = fecundacionInVitro;
	}

	public boolean getOftalmologia() {
		return this.oftalmologia;
	}

	public void setOftalmologia(boolean oftalmologia) {
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

	@Override
	public String toString() {
		return "Cobertura [id=" + id + ", dental=" + dental + ", fecundacionInVitro=" + fecundacionInVitro
				+ ", oftalmologia=" + oftalmologia + ", seguros=" + seguros + "]";
	}
}