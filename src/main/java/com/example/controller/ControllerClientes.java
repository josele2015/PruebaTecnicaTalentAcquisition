package com.example.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.example.message.MessageError;
import com.example.message.MessageStatus;
import com.example.model.Cliente;
import com.example.model.Persona;
import com.example.repo.IClienteRepo;
import com.example.repo.IPersonaRepo;
import com.example.service.ClienteServiceImpl;

import java.util.Optional;
@RestController
@RequestMapping("/clientes")    
public class ControllerClientes {
	
	private ClienteServiceImpl clienteService;

    ControllerClientes(ClienteServiceImpl clienteService) {
	    this.clienteService = clienteService;
    }
    @GetMapping("/getClientes")
    public ResponseEntity<List<Cliente> > getClientes(){
    	List<Cliente> Clientes=null;
    	Clientes=clienteService.getAllCliente();
    	return ResponseEntity.ok(Clientes);
    }
    
	@PostMapping("/postClientes")
    public ResponseEntity<MessageStatus> postCliente(@RequestBody ClienteDAO clienteDAO){
    	Cliente NewCliente=new Cliente();
    	MessageStatus messageStatus;
    	try
	    {
    		NewCliente=clienteService.saveCliente(clienteDAO);
    	}catch(Exception ex) {
    		MessageError messageError=new MessageError(ex.getLocalizedMessage(),ex);
    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"Se disparo un error al momento de crear un nuevo cliente",messageError);
    		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST);
    	}
    	messageStatus=new MessageStatus(HttpStatus.OK,"Se creo un nuevo cliente",null);
    	return ResponseEntity.ok(messageStatus);
    }
    
    @PutMapping("/putClientes")
    public ResponseEntity<MessageStatus> putClientes( @RequestBody ClienteDAO clienteDAO){
    	Optional<Cliente> Result;
    	Cliente clienteUpdate=new Cliente();
    	Persona persona;
    	MessageStatus messageStatus;
//    	try
//	    {
//    		Result=iClienteRepo.findById(clienteDAO.getiIdCliente());
//    		if(Result.orElse(null)==null) {
//    			clienteUpdate=Result.get();
//	    		if(clienteDAO.getiIdCliente()==clienteUpdate.getiIdCliente()) {
//		    		MessageError messageError=new MessageError(null);
//		    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"El cliente no existe",messageError);
//		    		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST);
//		    	}
//    		}
//    		clienteUpdate=new Cliente();
//    		clienteUpdate.setbEstado        (clienteDAO.getbEstado());
//    		clienteUpdate.setDtFechaCreacion(new Date());
//    		clienteUpdate.settContrasena    (clienteDAO.gettContrasena());
//    		clienteUpdate.setiIdCliente     (clienteDAO.getiIdCliente());
//	    	persona=iPersonaRepo.findById(clienteDAO.getPersona_iidpersona()).get();
//	    	clienteUpdate.setPersona(persona);
//	    	clienteUpdate=(Cliente)iClienteRepo.save(clienteUpdate);
//    	}catch(Exception ex) {
//    		MessageError messageError=new MessageError(ex.getLocalizedMessage(),ex);
//    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"Se disparo un error al momento de actualizar un cliente",messageError);
//    		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST);
//    	}
    	messageStatus=new MessageStatus(HttpStatus.OK,"Se actualizo un cliente",null);
    	return ResponseEntity.ok(messageStatus);
    }
    
    @DeleteMapping("/deleteClientes/{id}")
    public ResponseEntity<MessageStatus> deleteClientes(@PathVariable("id")Integer id){
    	Optional<Cliente> Result;
    	MessageStatus messageStatus;
//    	try {
//    		Result=iClienteRepo.findById(id);
//    		if(Result.orElse(null)==null) {
//    			messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"El cliente no existe",null);
//        		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST);		
//    		}
//        	iClienteRepo.deleteById(id);
//    	}catch(Exception ex) {
//    		MessageError messageError=new MessageError(ex.getLocalizedMessage(),ex);
//    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"Se disparo un error al momento de eliminar un cliente",messageError);
//    		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST);
//    	}
    	messageStatus=new MessageStatus(HttpStatus.OK,"Se elimino el cliente con el id "+id,null);
    	return ResponseEntity.ok(messageStatus);
    }
}
