package com.example.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

import com.example.entity.CuentaDAO;
import com.example.message.MessageError;
import com.example.message.MessageStatus;
import com.example.model.Cliente;
import com.example.model.Cuenta;
import com.example.repo.IClienteRepo;
import com.example.repo.ICuentaRepo;

@RestController
@RequestMapping("/cuentas")    
public class ControllerCuenta {
	@Autowired
	private final ICuentaRepo iCuentaRepo;
	@Autowired
	private final IClienteRepo iClienteRepo;

    ControllerCuenta(ICuentaRepo iCuentaRepo, IClienteRepo iClienteRepo) {
        this.iCuentaRepo = iCuentaRepo;
		this.iClienteRepo = iClienteRepo;
    }
    
    @GetMapping("/getCuentas")
    public ResponseEntity<List<Cuenta>> getCuentas(){
    	List<Cuenta> Cuentas;
    	Cuentas=iCuentaRepo.findAll();
    	return ResponseEntity.ok(Cuentas);
    }
    
    @PostMapping("/postCuentas")
    public ResponseEntity<MessageStatus> postCuenta(@RequestBody CuentaDAO CuentaDAO){
    	Optional<Cuenta> Result;
    	Cuenta cuentaNew=new Cuenta();
    	Cliente cliente;
    	MessageStatus messageStatus;
    	try {
    		Result=iCuentaRepo.findById(CuentaDAO.getCliente_iidcliente());
    		if(Result.orElse(null)!=null) {
    			cuentaNew=Result.get();
	    		if(cuentaNew.getiIdCuenta()==CuentaDAO.getiIdCuenta()) {
		    		MessageError messageError=new MessageError(null);
		    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"la cuenta ya existe",messageError);
		    		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST);
		    	}
    		}
    		cuentaNew=new Cuenta();
	    	cuentaNew.setiIdCuenta(CuentaDAO.getiIdCuenta());
	    	cuentaNew.settNumeroCuenta(CuentaDAO.gettNumeroCuenta());
	    	cuentaNew.settTipoCuenta(CuentaDAO.gettTipoCuenta());
	    	cuentaNew.setiSaldoInicial(CuentaDAO.getiSaldoInicial());
	    	cuentaNew.setbEstado(CuentaDAO.getbEstado()); 	
	    	cuentaNew.setDtFechaCreacion(new Date());
	    	cuentaNew.setiSaldo(CuentaDAO.getiSaldo());
	    	cliente=iClienteRepo.findById(CuentaDAO.getCliente_iidcliente()).get();
	    	cuentaNew.setCliente(cliente);
			iCuentaRepo.save(cuentaNew);
    	}catch(Exception ex) {
    		MessageError messageError=new MessageError(ex.getLocalizedMessage(),ex);
    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"Se disparo un error al momento de crear una cuenta",messageError);
    		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST);
    	}
    	messageStatus=new MessageStatus(HttpStatus.OK,"Se creo una nueva cuenta",null);
    	return ResponseEntity.ok(messageStatus);
    }
    
    @PutMapping("/putCuentas")
    public ResponseEntity<MessageStatus> putCuentas( @RequestBody CuentaDAO CuentaDAO){
    	Optional<Cuenta> Result;
    	Cuenta cuentaUpdate=new Cuenta();
    	Cliente cliente;
    	MessageStatus messageStatus;
    	try {
    		Result=iCuentaRepo.findById(CuentaDAO.getCliente_iidcliente());
    		if(Result.orElse(null)==null) {
	    		MessageError messageError=new MessageError(null);
	    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"La cuenta no existe",messageError);
	    		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST);
    		}
    		cuentaUpdate=new Cuenta();
    		cuentaUpdate.setiIdCuenta(CuentaDAO.getiIdCuenta());
    		cuentaUpdate.settNumeroCuenta(CuentaDAO.gettNumeroCuenta());
    		cuentaUpdate.settTipoCuenta(CuentaDAO.gettTipoCuenta());
    		cuentaUpdate.setiSaldoInicial(CuentaDAO.getiSaldoInicial());
    		cuentaUpdate.setbEstado(CuentaDAO.getbEstado()); 	
    		cuentaUpdate.setDtFechaCreacion(new Date());
    		cuentaUpdate.setiSaldo(CuentaDAO.getiSaldo());
			cliente=iClienteRepo.findById(CuentaDAO.getCliente_iidcliente()).get();
			cuentaUpdate.setCliente(cliente);
			iCuentaRepo.save(cuentaUpdate);
    	}catch(Exception ex) {
    		MessageError messageError=new MessageError(ex.getLocalizedMessage(),ex);
    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"Se disparo un error al momento de actualizar una cuenta",messageError);
    		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST);
    		
    	}
    	messageStatus=new MessageStatus(HttpStatus.OK,"Se actualizo la cuenta de manera correcta",null);
    	return ResponseEntity.ok(messageStatus);
    }
    
    @DeleteMapping("/deleteCuentas/{id}")
    public ResponseEntity<MessageStatus> deleteCuentas(@PathVariable("id")Integer id){
    	MessageStatus messageStatus;
    	Optional<Cuenta> Result;
    	try {
    		Result=iCuentaRepo.findById(id);
    		if(Result.orElse(null)==null) {
    			messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"No se puede eliminar, la cuenta no existe ", null);
        		return ResponseEntity.ok(messageStatus);
    		}
    	 	iCuentaRepo.deleteById(id);
    	}catch(Exception ex) {
    		MessageError messageError=new MessageError(ex.getLocalizedMessage(),ex);
    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"Se disparo un error al momento de actualizar una cuenta",messageError);
    		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST);
    	}
    	messageStatus=new MessageStatus(HttpStatus.OK,"Se elimina la cuenta con el id "+id,null);
		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST);
    }
    
}
