package com.example.controller;

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

import com.example.model.Cuenta;
import com.example.entity.MovimientoDAO;
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
    public ResponseEntity<Movimiento> postMovimiento( @RequestBody MovimientoDAO MovimientoDAO){
//    	@RequestBody Movimiento Movimiento
    	Movimiento NewMovimiento=new Movimiento();
    	NewMovimiento.setiIdMovimiento(MovimientoDAO.getiIdMovimiento());
		NewMovimiento.setbEstado(MovimientoDAO.isbEstado());
    	NewMovimiento.setDtFechaCreacion(new Date());
    	NewMovimiento.settTipoMovimiento(MovimientoDAO.gettTipoMovimiento());
    	NewMovimiento.setDtFecha(MovimientoDAO.getDtFecha());
    	NewMovimiento.setiMovimiento(MovimientoDAO.getiMovimiento());
    	Cuenta cuenta=iCuentaRepo.findById(MovimientoDAO.getCuenta_iIdcuenta()).get();
    	NewMovimiento.setCuenta(cuenta);
    	
    	Movimiento MovimientoSave=(Movimiento)iMovimientoRepo.save(NewMovimiento);
//    	URI ubicacion= ServletUriComponentsBuilder.fromCurrentRequest()
//    			.path("/{id}").buildAndExpand(MovimientoDAO.getiIdMovimiento()).toUri();
    	return ResponseEntity.ok(MovimientoSave);
    }
    
    @PutMapping("/putMovimientos")
    public ResponseEntity<Movimiento> putMovimientos( @RequestBody MovimientoDAO MovimientoDAO){
//    	@RequestBody Movimiento Movimiento
    	Movimiento NewMovimiento=new Movimiento();
    	NewMovimiento.setiIdMovimiento(MovimientoDAO.getiIdMovimiento());
		NewMovimiento.setbEstado(MovimientoDAO.isbEstado());
    	NewMovimiento.setDtFechaCreacion(new Date());
    	NewMovimiento.settTipoMovimiento(MovimientoDAO.gettTipoMovimiento());
    	NewMovimiento.setDtFecha(MovimientoDAO.getDtFecha());
    	NewMovimiento.setiMovimiento(MovimientoDAO.getiMovimiento());
    	Cuenta cuenta=iCuentaRepo.findById(MovimientoDAO.getCuenta_iIdcuenta()).get();
    	NewMovimiento.setCuenta(cuenta);
    	
    	Movimiento MovimientoSave=(Movimiento)iMovimientoRepo.save(NewMovimiento);
//    	URI ubicacion= ServletUriComponentsBuilder.fromCurrentRequest()
//    			.path("/{id}").buildAndExpand(MovimientoDAO.getiIdMovimiento()).toUri();
    	return ResponseEntity.ok(MovimientoSave);
    }
    
    @DeleteMapping("/deleteMovimientos/{id}")
    public ResponseEntity<String> deleteMovimientos(@PathVariable("id")Integer id){
    	iMovimientoRepo.deleteById(id);
    	return ResponseEntity.ok("id"+id+"Movimiento delete ");
    }
}
