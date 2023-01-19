package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.data;
//
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Cliente;
//import org.springframework.web.bind.annotation.RestController;
//
import com.example.model.Persona;
import com.example.repo.IPersonaRepo;

//@ComponentScan
@RestController
@RequestMapping("")    
public class ControllerCRUD {
	@Autowired
 	private IPersonaRepo iPersonaRepo;
	
    @GetMapping("/getPersona")
    public ResponseEntity<List<Persona> > getPersona(){
    	List<Persona> Personas;
    	Personas=iPersonaRepo.findAll();
    	return ResponseEntity.ok(Personas);
    }
    
//    clientes
    
//    movimientos
}
