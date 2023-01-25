package com.example.model;

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


//@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity(name = "movimiento")
@Table(name = "movimiento",  indexes= {
		@Index(name="fk_movimiento_entidad1_idx",columnList="cuenta_iidcuenta")
})
public class Movimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iidmovimiento", nullable = false)
	private Integer iIdMovimiento;
	
	@Column(name = "dtfecha",length = 45, nullable = false)
	private String dtFecha;

	@Column(name = "ttipomovimiento",length = 45, nullable = false)
	private String tTipoMovimiento;  
	  
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name = "cuenta_iidcuenta", nullable = false)
	private Cuenta cuenta;

	@Column(name = "bestado", nullable = false)
	private boolean bEstado;
	  
	@Column(name = "dtfechacreacion", nullable = false)
	private Date dtFechaCreacion;
	
	@Column(name="imovimiento", nullable = false)
	private int iMovimiento;

	public Movimiento(){}
	
	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	public Integer getiIdMovimiento() {
		return iIdMovimiento;
	}

	public void setiIdMovimiento(Integer iIdMovimiento) {
		this.iIdMovimiento = iIdMovimiento;
	}

	public String getDtFecha() {
		return dtFecha;
	}

	public void setDtFecha(String dtFecha) {
		this.dtFecha = dtFecha;
	}

	public String gettTipoMovimiento() {
		return tTipoMovimiento;
	}

	public void settTipoMovimiento(String tTipoMovimiento) {
		this.tTipoMovimiento = tTipoMovimiento;
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
	
	public int getiMovimiento() {
		return iMovimiento;
	}

	public void setiMovimiento(int iMovimiento) {
		this.iMovimiento = iMovimiento;
	}
}
