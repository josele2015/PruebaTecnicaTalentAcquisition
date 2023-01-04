package com.example.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.ClienteDAO;
import com.example.model.Cliente;
import com.example.model.Persona;
import com.example.repo.IClienteRepo;
import com.example.repo.IPersonaRepo;

@RestController
@RequestMapping("/clientes")    
public class ControllerClientes {
	@Autowired
	private final IClienteRepo iClienteRepo;
	@Autowired
	private final IPersonaRepo iPersonaRepo;

    ControllerClientes(IClienteRepo iClienteRepo, IPersonaRepo iPersonaRepo) {
        this.iClienteRepo = iClienteRepo;
		this.iPersonaRepo = iPersonaRepo;
    }
    @GetMapping("/getClientes")
    public ResponseEntity<List<Cliente> > getClientes(){
    	List<Cliente> Clientes;
    	Clientes=iClienteRepo.findAll();
    	return ResponseEntity.ok(Clientes);
    }
    
    @PostMapping("/postClientes")
    public ResponseEntity<Cliente> postCliente( @RequestBody ClienteDAO clienteDAO){
//    	@RequestBody Cliente cliente
    	Cliente NewCliente=new Cliente();
    	NewCliente.setbEstado(clienteDAO.getbEstado());
    	NewCliente.setDtFechaCreacion(new Date());
    	NewCliente.settContrasena(clienteDAO.gettContrasena());
    	NewCliente.setiIdCliente(clienteDAO.getiIdCliente());
    	Persona persona=(Persona)iPersonaRepo.findById(clienteDAO.getPersona_iidpersona()).get();
//    	iPersonaRepo.getReferenceById(1)
    	NewCliente.setPersona(persona);
    	
    	
    	Cliente clienteSave=(Cliente)iClienteRepo.save(NewCliente);
//    	URI ubicacion= ServletUriComponentsBuilder.fromCurrentRequest()
//    			.path("/{id}").buildAndExpand(clienteDAO.getiIdCliente()).toUri();
    	return ResponseEntity.ok(clienteSave);
    }
    
    @PutMapping("/putClientes")
    public ResponseEntity<Cliente> putClientes( @RequestBody ClienteDAO clienteDAO){
    	Cliente NewCliente=new Cliente();
    	NewCliente.setbEstado(clienteDAO.getbEstado());
    	NewCliente.setDtFechaCreacion(new Date());
    	NewCliente.settContrasena(clienteDAO.gettContrasena());
    	NewCliente.setiIdCliente(clienteDAO.getiIdCliente());
    	Persona persona=(Persona)iPersonaRepo.findById(clienteDAO.getPersona_iidpersona()).get();
//    	iPersonaRepo.getReferenceById(1)
    	NewCliente.setPersona(persona);
    	
    	
    	Cliente clienteSave=(Cliente)iClienteRepo.save(NewCliente);
//    	URI ubicacion= ServletUriComponentsBuilder.fromCurrentRequest()
//    			.path("/{id}").buildAndExpand(clienteDAO.getiIdCliente()).toUri();
    	return ResponseEntity.ok(clienteSave);
    }
    
    @DeleteMapping("/deleteClientes/{id}")
    public ResponseEntity<String> deleteClientes(@PathVariable("id")Integer id){
    	iClienteRepo.deleteById(id);
    	return ResponseEntity.ok("id"+id+ "cliente delete ");
    }
}
