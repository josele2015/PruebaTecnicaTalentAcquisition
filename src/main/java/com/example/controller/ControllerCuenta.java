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

import com.example.entity.CuentaDAO;
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
    public ResponseEntity<Cuenta> postCuenta( @RequestBody CuentaDAO CuentaDAO){
    	Cuenta NewCuenta=new Cuenta();
    	
    	NewCuenta.setiIdCuenta(CuentaDAO.getiIdCuenta());
    	NewCuenta.settNumeroCuenta(CuentaDAO.gettNumeroCuenta());
    	NewCuenta.settTipoCuenta(CuentaDAO.gettTipoCuenta());
    	NewCuenta.setiSaldoInicial(CuentaDAO.getiSaldoInicial());
    	NewCuenta.setbEstado(CuentaDAO.getbEstado()); 	
       	NewCuenta.setDtFechaCreacion(new Date());
    	NewCuenta.setiSaldo(CuentaDAO.getiSaldo());
    	Cliente cliente=iClienteRepo.findById(CuentaDAO.getCliente_iidcliente()).get();
    	NewCuenta.setCliente(cliente);    	
    	
    	Cuenta CuentaSave=(Cuenta)iCuentaRepo.save(NewCuenta);
    	return ResponseEntity.ok(CuentaSave);
    }
    
    @PutMapping("/putCuentas")
    public ResponseEntity<Cuenta> putCuentas( @RequestBody CuentaDAO CuentaDAO){
    	Cuenta NewCuenta=new Cuenta();
    	
    	NewCuenta.setiIdCuenta(CuentaDAO.getiIdCuenta());
    	NewCuenta.settNumeroCuenta(CuentaDAO.gettNumeroCuenta());
    	NewCuenta.settTipoCuenta(CuentaDAO.gettTipoCuenta());
    	NewCuenta.setiSaldoInicial(CuentaDAO.getiSaldoInicial());
    	NewCuenta.setbEstado(CuentaDAO.getbEstado()); 	
       	NewCuenta.setDtFechaCreacion(new Date());
       	NewCuenta.setiSaldo(CuentaDAO.getiSaldo());
    	Cliente cliente=iClienteRepo.findById(CuentaDAO.getCliente_iidcliente()).get();
    	NewCuenta.setCliente(cliente);
    	
    	Cuenta CuentaSave=(Cuenta)iCuentaRepo.save(NewCuenta);
    	return ResponseEntity.ok(CuentaSave);
    }
    
    @DeleteMapping("/deleteCuentas/{id}")
    public ResponseEntity<String> deleteCuentas(@PathVariable("id")Integer id){
    	iCuentaRepo.deleteById(id);
    	return ResponseEntity.ok("id "+id+" Cuenta, se eliminó ");
    }
    
}
