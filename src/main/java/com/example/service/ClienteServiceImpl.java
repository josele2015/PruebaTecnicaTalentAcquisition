package com.example.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.ClienteDAO;
import com.example.message.MessageError;
import com.example.message.MessageStatus;
import com.example.model.Cliente;
import com.example.model.Persona;
import com.example.repo.IClienteRepo;
import com.example.repo.IPersonaRepo;
@Transactional
@Service
public class ClienteServiceImpl implements IClienteService  {
	@Autowired
	private final IClienteRepo iClienteRepo;
	@Autowired
	private final IPersonaRepo iPersonaRepo;
	
	public ClienteServiceImpl(IClienteRepo iClienteRepo, IPersonaRepo iPersonaRepo) {
        this.iClienteRepo = iClienteRepo;
		this.iPersonaRepo = iPersonaRepo;
    }
	@Override
	public Cliente saveCliente(ClienteDAO clienteDAO) {
		
		// TODO Auto-generated method stub
		Optional<Cliente> Result;
    	Cliente NewCliente=new Cliente();
    	Persona persona;
    	MessageStatus messageStatus;
    	Result=iClienteRepo.findById(clienteDAO.getiIdCliente());
    	if(Result.orElse(null)!=null) {
    		NewCliente=Result.get();
	    	if(clienteDAO.getiIdCliente()==NewCliente.getiIdCliente()) {
	   			throw new IllegalArgumentException("El cliente ya existe");
	    	}
   		}
    	NewCliente=new Cliente();
    	NewCliente.setbEstado(clienteDAO.getbEstado());
    	NewCliente.setDtFechaCreacion(new Date());
	    NewCliente.settContrasena(clienteDAO.gettContrasena());
	   	NewCliente.setiIdCliente(clienteDAO.getiIdCliente());
	   	persona=iPersonaRepo.findById(clienteDAO.getPersona_iidpersona()).get();
	   	NewCliente.setPersona(persona);
	    NewCliente=(Cliente)iClienteRepo.save(NewCliente);
    	
	    
//		private Integer iIdCliente;
//		private String tContrasena;	
//		private Boolean bEstado;
//		private Persona persona;
//		private Date dtFechaCreacion;
//	    
		return NewCliente;
	}

	@Override
	public List<Cliente> getAllCliente() {
		List<Cliente> Clientes=null;
    	Clientes=iClienteRepo.findAll();
    	return Clientes;
	}

	@Override
	public Optional<Cliente> getClienteById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Cliente updateCliente(ClienteDAO updatedCliente) {
		// TODO Auto-generated method stub
		Optional<Cliente> Result;
    	Cliente clienteUpdate=new Cliente();
    	Persona persona;   	
    	MessageStatus messageStatus;
    	
    		Result=iClienteRepo.findById(updatedCliente.getiIdCliente());
    		if(Result.orElse(null)==null) {
    			clienteUpdate=Result.get();
	    		if(updatedCliente.getiIdCliente()==clienteUpdate.getiIdCliente()) {
		  			throw new IllegalArgumentException("El cliente no existe");
		    	}
    		}
    		clienteUpdate=new Cliente();
    		clienteUpdate.setbEstado        (updatedCliente.getbEstado());
    		clienteUpdate.setDtFechaCreacion(new Date());
    		clienteUpdate.settContrasena    (updatedCliente.gettContrasena());
    		clienteUpdate.setiIdCliente     (updatedCliente.getiIdCliente());
	    	persona=iPersonaRepo.findById(updatedCliente.getPersona_iidpersona()).get();
	    	clienteUpdate.setPersona(persona);
	    	clienteUpdate=(Cliente)iClienteRepo.save(clienteUpdate);
    	
		return clienteUpdate;
	}

	@Override
	public void deleteCliente(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
