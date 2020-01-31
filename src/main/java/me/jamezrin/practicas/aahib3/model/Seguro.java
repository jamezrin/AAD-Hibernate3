package me.jamezrin.practicas.aahib3.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the seguro database table.
 * 
 */
@Entity
@Table(name="seguro")
@NamedQuery(name="Seguro.findAll", query="SELECT s FROM Seguro s")
public class Seguro implements Serializable {
	private static final long serialVersionUID = 1L;

	enum Sexo {
		HOMBRE, MUJER, OTRO
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String ape1;

	private String ape2;

	private String casado;

	private int edad;

	private String embarazada;

	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;

	private String nif;

	private String nombre;

	private int numHijos;

	@Enumerated(EnumType.ORDINAL)
	private Sexo sexo;

	//bi-directional many-to-one association to Asistencia
	@OneToMany(mappedBy="seguro")
	private List<Asistencia> asistencias;

	//bi-directional many-to-one association to Cobertura
	@ManyToOne
	@JoinColumn(name="coberturaId")
	private Cobertura cobertura;

	//bi-directional many-to-one association to Enfermedad
	@ManyToOne
	@JoinColumn(name="enfermedadId")
	private Enfermedad enfermedad;

	public Seguro() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApe1() {
		return this.ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return this.ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public String getCasado() {
		return this.casado;
	}

	public void setCasado(String casado) {
		this.casado = casado;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmbarazada() {
		return this.embarazada;
	}

	public void setEmbarazada(String embarazada) {
		this.embarazada = embarazada;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumHijos() {
		return this.numHijos;
	}

	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}

	public Sexo getSexo() {
		return this.sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public List<Asistencia> getAsistencias() {
		return this.asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	public Asistencia addAsistencia(Asistencia asistencia) {
		getAsistencias().add(asistencia);
		asistencia.setSeguro(this);

		return asistencia;
	}

	public Asistencia removeAsistencia(Asistencia asistencia) {
		getAsistencias().remove(asistencia);
		asistencia.setSeguro(null);

		return asistencia;
	}

	public Cobertura getCobertura() {
		return this.cobertura;
	}

	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}

	public Enfermedad getEnfermedad() {
		return this.enfermedad;
	}

	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	@Override
	public String toString() {
		return "Seguro [id=" + id + ", ape1=" + ape1 + ", ape2=" + ape2 + ", casado=" + casado + ", edad=" + edad
				+ ", embarazada=" + embarazada + ", fechaCreacion=" + fechaCreacion + ", nif=" + nif + ", nombre="
				+ nombre + ", numHijos=" + numHijos + ", sexo=" + sexo + ", asistencias=" + asistencias + ", cobertura="
				+ cobertura + ", enfermedad=" + enfermedad + "]";
	}
}