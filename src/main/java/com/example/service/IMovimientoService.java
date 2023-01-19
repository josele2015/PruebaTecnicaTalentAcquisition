package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.MovimientoDAO;
import com.example.model.Movimiento;

public interface IMovimientoService {
	Movimiento saveMovimiento(MovimientoDAO movimiento);
    List<Movimiento> getAllMovimiento();
    Optional<Movimiento> getMovimientoById(Integer id);
    Movimiento updateMovimiento(MovimientoDAO updatedMovimiento);
    void deleteMovimiento(Integer id);
}
