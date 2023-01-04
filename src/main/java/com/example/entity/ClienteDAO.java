package com.example.entity;

public class ClienteDAO {
	private Integer iIdCliente;
	private String tContrasena;
	private Boolean bEstado;
	private Integer personaiIdpersona;
	
	public ClienteDAO(Integer iIdCliente, String tContrasena, Boolean bEstado, Integer personaiIdpersona) {
		super();
		this.iIdCliente = iIdCliente;
		this.tContrasena = tContrasena;
		this.bEstado = bEstado;
		this.personaiIdpersona = personaiIdpersona;
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
	
	public Integer getPersona_iidpersona() {
		return personaiIdpersona;
	}
	
	public void setPersona_iidpersona(Integer persona_iidpersona) {
		this.personaiIdpersona = persona_iidpersona;
	}
	
}
