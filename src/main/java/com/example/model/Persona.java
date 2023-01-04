package com.example.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity(name = "persona")
@Table(name = "persona", indexes = {
        @Index(name = "fk_persona_entidad1_idx", columnList = "entidad_iidentidad")
})

public class Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iidpersona", nullable = false)
	private Integer iIdpersona;
	
	@Column(name = "tnombre", length = 100, nullable = false)
	private String tNombre; 
	  
	@Column(name = "tgenero", length = 1, nullable = false)
	private String tGenero;   
	
	@Column(name = "iedad", nullable = false)
	private Integer iEdad;
	
	@Column(name = "tidentificacion", length= 45, nullable = false)
	private String tIdentificacion;
	
	@Column(name = "tdireccion", length= 100, nullable = false)
	private String tDirreccion;
	  
	@Column(name = "ttelefono", length= 45, nullable = false)
	private String tTelefono;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="entidad_iidentidad", nullable=false)
    private Entidad entidad;
	  
	@Column(name = "bestado", nullable = false)
	private boolean bEstado;
	
	@Column(name = "dtfechacreacion", nullable = false)
	private Date dtFechaCreacion;
	
	
	 @Override
	  public String toString() {
	    return String.format(
	        "Customer[iIdpersona=%d, tNombre='%s', tGenero='%s' , iEdad=%d ,"
	        + "tidentificacion='%s',tdireccion='%s',ttelefono='%s,"
	        + "Entidad_iIdEntidad='%s,bEstado='%s,dtFechaCreacion='%s ]",
	        iIdpersona, tNombre, tGenero,iEdad,tIdentificacion,
	        tDirreccion, tTelefono,entidad.getiIdEntidad(),bEstado,dtFechaCreacion);
	  }
	
	public Persona() {	
	}
	
	public Integer getiIdpersona() {
		return iIdpersona;
	}

	public void setiIdpersona(Integer iIdpersona) {
		this.iIdpersona = iIdpersona;
	}

	public String gettNombre() {
		return tNombre;
	}

	public void settNombre(String tNombre) {
		this.tNombre = tNombre;
	}

	public String gettGenero() {
		return tGenero;
	}

	public void settGenero(String tGenero) {
		this.tGenero = tGenero;
	}

	public Integer getiEdad() {
		return iEdad;
	}

	public void setiEdad(Integer iEdad) {
		this.iEdad = iEdad;
	}

	public String gettIdentificacion() {
		return tIdentificacion;
	}

	public void settIdentificacion(String tIdentificacion) {
		this.tIdentificacion = tIdentificacion;
	}

	public String gettDirreccion() {
		return tDirreccion;
	}

	public void settDirreccion(String tDirreccion) {
		this.tDirreccion = tDirreccion;
	}

	public String gettTelefono() {
		return tTelefono;
	}

	public void settTelefono(String tTelefono) {
		this.tTelefono = tTelefono;
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
	
	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

//	public Set<Cliente> getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(Set<Cliente> cliente) {
//		this.cliente = cliente;
//	}


}
