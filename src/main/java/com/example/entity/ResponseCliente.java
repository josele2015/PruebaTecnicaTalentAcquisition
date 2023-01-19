package com.example.entity;

import com.example.model.Cliente;

public class ResponseCliente {
	private String Mensaje;
	private Cliente cliente;
	
	public ResponseCliente(String mensaje, Cliente cliente) {
		super();
		this.Mensaje = mensaje;
		this.cliente = cliente;
	}
	
	public String getMensaje() {
		return Mensaje;
	}

	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
