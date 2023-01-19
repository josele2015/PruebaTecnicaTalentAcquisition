package com.example.model;

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
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity(name = "cuenta")
@Table(name = "cuenta", indexes = {
        @Index(name = "fk_cuenta_entidad_idx", columnList = "cliente_iidcliente")
})
public class Cuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iidcuenta", nullable = false)
	private Integer iIdCuenta;

	@Column(name = "tnumerocuenta", nullable = false,length = 45)
	private String tNumeroCuenta;
	  
	@Column(name = "ttipocuenta", nullable = false,length = 50)	  
	private String tTipoCuenta;
	  
	@Column(name = "isaldoinicial", nullable = false)	  
	private Integer iSaldoInicial;
	  
	@Column(name = "bestado", nullable = false)	  
	private boolean bEstado;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="cliente_iidcliente", nullable=false)	  
	private Cliente cliente;

	@Column(name = "dtfechacreacion", nullable = false)  
	private Date dtFechaCreacion;
	
	@Column(name = "isaldo", nullable = false)  
	private Integer iSaldo;
	
	public Cuenta() {}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	
	public Integer getiSaldo() {
		return iSaldo;
	}

	public void setiSaldo(Integer iSaldo) {
		this.iSaldo = iSaldo;
	}


}
