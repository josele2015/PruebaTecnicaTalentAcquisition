package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.data;
//
import org.springframework.boot.web.*;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.RestController;
//
import com.example.model.Persona;
import com.example.repo.IPersonaRepo;

//@ComponentScan
@RestController
@RequestMapping("/")    
public class ControllerCRUD {
	@Autowired
 	private IPersonaRepo iPersonaRepo;
	
    @GetMapping("/getPersona")
    public List<Persona> getPersona(){
    	List Personas;
    	Personas=iPersonaRepo.findAll();
    	return Personas;
    }
    
//    clientes
    
//    movimientos
}
