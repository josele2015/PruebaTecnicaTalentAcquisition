package com.example.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.entity.MovimientoDAO;
import com.example.model.Movimiento;
@Transactional
@Service
public class MovimientoServiceImpl implements IMovimientoService{
	@Override
	public Movimiento saveMovimiento(MovimientoDAO movimiento) {
		return null;
	}
	@Override
    public List<Movimiento> getAllMovimiento(){
		return null;
	}
	@Override
	public Optional<Movimiento> getMovimientoById(Integer id){
		return null;
	}
	@Override
	public Movimiento updateMovimiento(MovimientoDAO updatedMovimiento) {
		return null;
	}
	@Override
	public void deleteMovimiento(Integer id) {
		
	}
}
