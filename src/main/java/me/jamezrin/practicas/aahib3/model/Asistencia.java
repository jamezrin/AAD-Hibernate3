package me.jamezrin.practicas.aahib3.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the asistencia database table.
 * 
 */
@Entity
@Table(name="asistencia")
@NamedQuery(name="Asistencia.findAll", query="SELECT a FROM Asistencia a")
public class Asistencia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	enum TipoAsistencia {
		HOSPITALARIA, AMBULATORIA, CENTRO_SALUD, DOMICILIARIA;
		
		@Override
		public String toString() {
			switch (this) {
				case HOSPITALARIA: return "Hospitalaria";
				case AMBULATORIA: return "Ambulatoria";
				case CENTRO_SALUD: return "Centro de salud";
				case DOMICILIARIA: return "Domiciliaria";
				default: return "Desconocido";
			}
		}
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	@Lob
	private String explicacion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Temporal(TemporalType.TIME)
	private Date hora;

	private BigDecimal importe;

	private String lugar;

	@Enumerated(EnumType.STRING)
	private TipoAsistencia tipoAsistencia;

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

	public String getExplicacion() {
		return this.explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
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

	public TipoAsistencia getTipoAsistencia() {
		return this.tipoAsistencia;
	}

	public void setTipoAsistencia(TipoAsistencia tipoAsistencia) {
		this.tipoAsistencia = tipoAsistencia;
	}

	public Seguro getSeguro() {
		return this.seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	@Override
	public String toString() {
		return "Asistencia [id=" + id + ", descripcion=" + descripcion + ", explicacion=" + explicacion + ", fecha="
				+ fecha + ", hora=" + hora + ", importe=" + importe + ", lugar=" + lugar + ", tipoAsistencia="
				+ tipoAsistencia + ", seguro=" + seguro + "]";
	}	
}