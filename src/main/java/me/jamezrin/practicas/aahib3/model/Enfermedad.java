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

	@Type(type = "yes_no")
	private boolean alergia;

	@Type(type = "yes_no")
	private boolean corazon;

	@Type(type = "yes_no")
	private boolean estomacal;

	private String nombreAlergia;

	@Type(type = "yes_no")
	private boolean rinyones;

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

	public boolean getAlergia() {
		return this.alergia;
	}

	public void setAlergia(boolean alergia) {
		this.alergia = alergia;
	}

	public boolean getCorazon() {
		return this.corazon;
	}

	public void setCorazon(boolean corazon) {
		this.corazon = corazon;
	}

	public boolean getEstomacal() {
		return this.estomacal;
	}

	public void setEstomacal(boolean estomacal) {
		this.estomacal = estomacal;
	}

	public String getNombreAlergia() {
		return this.nombreAlergia;
	}

	public void setNombreAlergia(String nombreAlergia) {
		this.nombreAlergia = nombreAlergia;
	}

	public boolean getRinyones() {
		return this.rinyones;
	}

	public void setRinyones(boolean rinyones) {
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

	@Override
	public String toString() {
		return "Enfermedad [id=" + id + ", alergia=" + alergia + ", corazon=" + corazon + ", estomacal=" + estomacal
				+ ", nombreAlergia=" + nombreAlergia + ", rinyones=" + rinyones + ", seguros=" + seguros + "]";
	}
}