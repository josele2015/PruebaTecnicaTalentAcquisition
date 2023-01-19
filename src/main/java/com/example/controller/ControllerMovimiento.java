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

import com.example.model.Cuenta;
import com.example.entity.MovimientoDAO;
import com.example.message.MessageError;
import com.example.message.MessageStatus;
import com.example.model.Movimiento;
import com.example.repo.ICuentaRepo;
import com.example.repo.IMovimientoRepo;

@RestController
@RequestMapping("/movimientos")    
public class ControllerMovimiento {
	@Autowired
	private final IMovimientoRepo iMovimientoRepo;
	@Autowired
	private final ICuentaRepo iCuentaRepo;

    ControllerMovimiento(IMovimientoRepo iMovimientoRepo, ICuentaRepo iCuentaRepo) {
        this.iMovimientoRepo = iMovimientoRepo;
		this.iCuentaRepo = iCuentaRepo;
    }
    @GetMapping("/getMovimientos")
    public ResponseEntity<List<Movimiento> > getMovimientos(){
    	List<Movimiento> Movimientos;
    	Movimientos=iMovimientoRepo.findAll();
    	return ResponseEntity.ok(Movimientos);
    }
    
    @PostMapping("/postMovimientos")
    public ResponseEntity<MessageStatus> postMovimiento( @RequestBody MovimientoDAO MovimientoDAO){
    	Movimiento NewMovimiento=new Movimiento();
    	Cuenta cuenta;
    	MessageStatus messageStatus;
    	String StSinSaldo="Saldo no disponible";
    	Optional<Movimiento> Result;
    	try {
    		Result=iMovimientoRepo.findById(MovimientoDAO.getCuenta_iIdcuenta());
    		if(Result.orElse(null)!=null) {
    			NewMovimiento=Result.get();
	    		if(NewMovimiento.getiIdMovimiento()==MovimientoDAO.getiIdMovimiento()) {
		    		MessageError messageError=new MessageError(null);
		    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"El movimiento ya existe",messageError);
		    		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST);
		    	}
    		}
	    	NewMovimiento.setiIdMovimiento(MovimientoDAO.getiIdMovimiento());
			NewMovimiento.setbEstado(MovimientoDAO.isbEstado());
	    	NewMovimiento.setDtFechaCreacion(new Date());
	       	cuenta=iCuentaRepo.findById(MovimientoDAO.getCuenta_iIdcuenta()).get();
	        //Los valores cuando son crédito son positivos, y los débitos son negativos. 
	       	//Debe almacenarse el saldo disponible en cada transacción dependiendo del tipo de movimiento. 
	       	//(suma o resta)
	    	if(NewMovimiento.getiMovimiento() > 0) {
	    		NewMovimiento.settTipoMovimiento("credito");
	    		cuenta.setiSaldo(cuenta.getiSaldo()+NewMovimiento.getiMovimiento());
	    	}else {
	    		NewMovimiento.settTipoMovimiento("debito");
	    		cuenta.setiSaldo(cuenta.getiSaldo()-NewMovimiento.getiMovimiento());
	    	}
	    	NewMovimiento.setDtFecha(MovimientoDAO.getDtFecha());
	    	NewMovimiento.setiMovimiento(MovimientoDAO.getiMovimiento());
	    	NewMovimiento.setCuenta(cuenta);
	    	iMovimientoRepo.save(NewMovimiento);
	    	iCuentaRepo.save(cuenta);
	    	//Si el saldo es cero, y va a realizar una transacción débito, debe desplegar mensaje “Saldo no disponible”
	    	if((cuenta.getiSaldo()-NewMovimiento.getiMovimiento())<=0) {
	    		messageStatus=new MessageStatus(HttpStatus.OK,"Se registro el movimiento correctamente, pero saldo actual es de cero",null);
		    	return ResponseEntity.ok(messageStatus);	
	    	}
	    	messageStatus=new MessageStatus(HttpStatus.OK,"Se registro el movimiento correctamente",null);
	    	
    	}catch(Exception ex) {
    		MessageError messageError=new MessageError(ex.getLocalizedMessage(),ex);
    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"Se disparo un error al momento de crear un movimiento",messageError);
    		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST);
    	}
    	messageStatus=new MessageStatus(HttpStatus.OK,"Se registro el movimiento correctamente",null);
    	return ResponseEntity.ok(messageStatus);
    }
    
    @PutMapping("/putMovimientos")
    public ResponseEntity<MessageStatus> putMovimientos( @RequestBody MovimientoDAO MovimientoDAO){
    	Movimiento NewMovimiento=new Movimiento();
    	Cuenta cuenta;
    	MessageStatus messageStatus;
    	Optional<Movimiento> Result;
    	try {
    		Result=iMovimientoRepo.findById(MovimientoDAO.getiIdMovimiento());
    		if(Result.orElse(null)==null) {
    			MessageError messageError=new MessageError(null);
		    	messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"El movimiento no existe no se puede actualizar",messageError);
		   		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST); 	
    		}
	    	NewMovimiento.setiIdMovimiento(MovimientoDAO.getiIdMovimiento());
			NewMovimiento.setbEstado(MovimientoDAO.isbEstado());
	    	NewMovimiento.setDtFechaCreacion(new Date());
	    	NewMovimiento.setDtFecha(MovimientoDAO.getDtFecha());
	    	NewMovimiento.setiMovimiento(MovimientoDAO.getiMovimiento());
	    	cuenta=iCuentaRepo.findById(MovimientoDAO.getCuenta_iIdcuenta()).get();
	    	NewMovimiento.setCuenta(cuenta);
	    	iMovimientoRepo.save(NewMovimiento);
    	}catch(Exception ex) {
    		MessageError messageError=new MessageError(ex.getLocalizedMessage(),ex);
    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"Se disparo un error al momento de actualizar un movimiento",messageError);
    		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST);
    	}
    	messageStatus=new MessageStatus(HttpStatus.OK,"Se actualizo el movimiento correctamente",null);
    	return ResponseEntity.ok(messageStatus);
    }
    
    @DeleteMapping("/deleteMovimientos/{id}")
    public ResponseEntity<MessageStatus> deleteMovimientos(@PathVariable("id")Integer id){
    	MessageStatus messageStatus;
    	Optional<Movimiento> Result;
    	try {
    		Result=iMovimientoRepo.findById(id);
    		if(Result.orElse(null)==null) {
    			messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"No existe el movimiento a eliminar",null);
        		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST);	
    		}
    		iMovimientoRepo.deleteById(id);	
    	}
    	catch(Exception ex) {
    		MessageError messageError=new MessageError(ex.getLocalizedMessage(),ex);
    		messageStatus=new MessageStatus(HttpStatus.BAD_REQUEST,"Se disparo un error al momento de actualizar un movimiento",messageError);
    		return new ResponseEntity<MessageStatus>(messageStatus,HttpStatus.BAD_REQUEST);
    	}
    	messageStatus=new MessageStatus(HttpStatus.OK,"Se elimino el movimiento con el id "+id,null);
    	return ResponseEntity.ok(messageStatus);
    }
}
