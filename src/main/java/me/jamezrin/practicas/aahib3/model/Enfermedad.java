package me.jamezrin.practicas.aahib3.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the enfermedad database table.
 * 
 */
@Entity
@Table(name="enfermedad")
@NamedQuery(name="Enfermedad.findAll", query="SELECT e FROM Enfermedad e")
public class Enfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String alergia;

	private String corazon;

	private String estomacal;

	private String nombreAlergia;

	private String rinyones;

	//bi-directional many-to-one association to Seguro
	@OneToMany(mappedBy="enfermedad")
	private List<Seguro> seguros;

	public Enfermedad() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlergia() {
		return this.alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public String getCorazon() {
		return this.corazon;
	}

	public void setCorazon(String corazon) {
		this.corazon = corazon;
	}

	public String getEstomacal() {
		return this.estomacal;
	}

	public void setEstomacal(String estomacal) {
		this.estomacal = estomacal;
	}

	public String getNombreAlergia() {
		return this.nombreAlergia;
	}

	public void setNombreAlergia(String nombreAlergia) {
		this.nombreAlergia = nombreAlergia;
	}

	public String getRinyones() {
		return this.rinyones;
	}

	public void setRinyones(String rinyones) {
		this.rinyones = rinyones;
	}

	public List<Seguro> getSeguros() {
		return this.seguros;
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}

	public Seguro addSeguro(Seguro seguro) {
		getSeguros().add(seguro);
		seguro.setEnfermedad(this);

		return seguro;
	}

	public Seguro removeSeguro(Seguro seguro) {
		getSeguros().remove(seguro);
		seguro.setEnfermedad(null);

		return seguro;
	}

}