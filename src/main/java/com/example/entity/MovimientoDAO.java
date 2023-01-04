package com.example.entity;

import java.util.Date;

public class MovimientoDAO {
	
	private Integer iIdMovimiento;
	private String dtFecha;
	private String tTipoMovimiento;  
	private boolean bEstado;
	private Date dtFechaCreacion;
	private Integer iMovimiento;
	private Integer Cuenta_iIdcuenta;

	public MovimientoDAO(Integer iIdMovimiento, String dtFecha, String tTipoMovimiento, boolean bEstado,
			Date dtFechaCreacion,Integer iMovimiento,Integer Cuenta_iIdcuenta) {
		super();
		this.iIdMovimiento = iIdMovimiento;
		this.dtFecha = dtFecha;
		this.tTipoMovimiento = tTipoMovimiento;
		this.bEstado = bEstado;
		this.dtFechaCreacion = dtFechaCreacion;
		this.iMovimiento=iMovimiento;
		this.Cuenta_iIdcuenta=Cuenta_iIdcuenta;
	}
	
	public Integer getiMovimiento() {
		return iMovimiento;
	}

	public void setiMovimiento(Integer iMovimiento) {
		this.iMovimiento = iMovimiento;
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
	public Integer getCuenta_iIdcuenta() {
		return Cuenta_iIdcuenta;
	}

	public void setCuenta_iIdcuenta(Integer cuenta_iIdcuenta) {
		Cuenta_iIdcuenta = cuenta_iIdcuenta;
	}

}
