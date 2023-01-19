package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.model.Entidad;

public class PersonaDAO {
	private Integer iIdpersona;
	private String tNombre; 
	private String tGenero;   
	private Integer iEdad;
	private String tIdentificacion;
	private String tDirreccion;
	private String tTelefono;
	private Date dtFechaCreacion;
	
}
