package com.example.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
//import lombok.Getter;
//import lombok.Setter;
//
//import lombok.AccessLevel;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity(name = "cliente")
@Table(name = "cliente", indexes = {
        @Index(name = "fk_cliente_persona1_idx", columnList = "persona_iidpersona")
})
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iidcliente", nullable = false)	
//	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private Integer iIdCliente;
	
//	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	@Column(name = "tcontrasena",length = 100, nullable = false)
	private String tContrasena;
	
//	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	@Column(name = "bestado", nullable = false)	
	private Boolean bEstado;

//	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="persona_iidpersona", nullable=false)
//	@JsonProperty(access = Access.WRITE_ONLY)
	private Persona persona;

//	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	@Column(name = "dtfechacreacion", nullable = false)
	private Date dtFechaCreacion;

	public Cliente() {
		
	}
	
	public Integer getiIdCliente() {
		return iIdCliente;
	}

	public void setiIdCliente(Integer iIdCliente) {
		this.iIdCliente = iIdCliente;
	}

	public String gettContrasena() {
		return tContrasena;
	}

	public void settContrasena(String tContrasena) {
		this.tContrasena = tContrasena;
	}

	public Boolean getbEstado() {
		return bEstado;
	}

	public void setbEstado(Boolean bEstado) {
		this.bEstado = bEstado;
	}

	public Date getDtFechaCreacion() {
		return dtFechaCreacion;
	}

	public void setDtFechaCreacion(Date dtFechaCreacion) {
		this.dtFechaCreacion = dtFechaCreacion;
	}
	
    public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
