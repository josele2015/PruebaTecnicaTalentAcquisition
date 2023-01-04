package com.example.entity;

public class CuentaDAO {
	private Integer iIdCuenta;
	private String tNumeroCuenta;
	private String tTipoCuenta;
	private Integer iSaldoInicial;
	private Boolean bEstado;
	private Integer cliente_iidcliente;
	private Integer iSaldo;
	public CuentaDAO(Integer iIdCuenta, String tNumeroCuenta, String tTipoCuenta, Integer iSaldoInicial,
			Boolean bEstado, Integer cliente_iidcliente,Integer iSaldo) {
		super();
		this.iIdCuenta = iIdCuenta;
		this.tNumeroCuenta = tNumeroCuenta;
		this.tTipoCuenta = tTipoCuenta;
		this.iSaldoInicial = iSaldoInicial;
		this.bEstado = bEstado;
		this.cliente_iidcliente = cliente_iidcliente;
		this.iSaldo=iSaldo;
	}
	public Integer getiIdCuenta() {
		return iIdCuenta;
	}
	public void setiIdCuenta(Integer iIdCuenta) {
		this.iIdCuenta = iIdCuenta;
	}
	public String gettNumeroCuenta() {
		return tNumeroCuenta;
	}
	public void settNumeroCuenta(String tNumeroCuenta) {
		this.tNumeroCuenta = tNumeroCuenta;
	}
	public String gettTipoCuenta() {
		return tTipoCuenta;
	}
	public void settTipoCuenta(String tTipoCuenta) {
		this.tTipoCuenta = tTipoCuenta;
	}
	public Integer getiSaldoInicial() {
		return iSaldoInicial;
	}
	public void setiSaldoInicial(Integer iSaldoInicial) {
		this.iSaldoInicial = iSaldoInicial;
	}
	public Boolean getbEstado() {
		return bEstado;
	}
	public void setbEstado(Boolean bEstado) {
		this.bEstado = bEstado;
	}

	public Integer getCliente_iidcliente() {
		return cliente_iidcliente;
	}
	public void setCliente_iidcliente(Integer cliente_iidcliente) {
		this.cliente_iidcliente = cliente_iidcliente;
	}
	public Integer getiSaldo() {
		return iSaldo;
	}
	public void setiSaldo(Integer iSaldo) {
		this.iSaldo = iSaldo;
	}
}
