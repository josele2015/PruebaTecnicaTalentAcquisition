package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.CuentaDAO;
import com.example.model.Cuenta;

public interface ICuentaService {
	Cuenta saveCuenta(CuentaDAO Cuenta);
    List<Cuenta> getAllCuenta();
    Optional<Cuenta> getCuentaById(Integer id);
    Cuenta updateCuenta(CuentaDAO updatedCuenta);
    void deleteCuenta(Integer id);
}
