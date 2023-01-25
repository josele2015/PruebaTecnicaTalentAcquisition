package com.example.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity(name = "Entidad")
@Table(name = "Entidad" )
public class Entidad  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iidentidad")
	private Integer iIdEntidad;

	@Column(name = "tnombreentidad",length = 100)
	private String tNombreEntidad;
	
	@Column(name = "bestado")
	private boolean bEstado;
	
	@Column(name = "dtfechacreacion")
	private Date  dtFechaCreacion;

//	@OneToMany(mappedBy = "persona",cascade = CascadeType.ALL,fetch= FetchType.LAZY)
//	private Set<Persona> persona;
//	
	public Integer getiIdEntidad() {
		return iIdEntidad;
	}

	public void setiIdEntidad(Integer iIdEntidad) {
		this.iIdEntidad = iIdEntidad;
	}

	public String gettNombreEntidad() {
		return tNombreEntidad;
	}

	public void settNombreEntidad(String tNombreEntidad) {
		this.tNombreEntidad = tNombreEntidad;
	}

	public boolean isbEstado() {
		return bEstado;
	}

	public void setbEstado(boolean bEstado) {
		this.bEstado = bEstado;
	}

	public Date getDtFechaCreacion() {
		return dtFechaCreacion;
	}

	public void setDtFechaCreacion(Date dtFechaCreacion) {
		this.dtFechaCreacion = dtFechaCreacion;
	}
}
