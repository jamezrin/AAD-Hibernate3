package me.jamezrin.practicas.aahib3.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the asistencia database table.
 * 
 */
@Entity
@Table(name="asistencia")
@NamedQuery(name="Asistencia.findAll", query="SELECT a FROM Asistencia a")
public class Asistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	@Lob
	private byte[] explicacion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Time hora;

	private BigDecimal importe;

	private String lugar;

	private String tipoAsistencia;

	//bi-directional many-to-one association to Seguro
	@ManyToOne
	@JoinColumn(name="seguroId")
	private Seguro seguro;

	public Asistencia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte[] getExplicacion() {
		return this.explicacion;
	}

	public void setExplicacion(byte[] explicacion) {
		this.explicacion = explicacion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getTipoAsistencia() {
		return this.tipoAsistencia;
	}

	public void setTipoAsistencia(String tipoAsistencia) {
		this.tipoAsistencia = tipoAsistencia;
	}

	public Seguro getSeguro() {
		return this.seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

}