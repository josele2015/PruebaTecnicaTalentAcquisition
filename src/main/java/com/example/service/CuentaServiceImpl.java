package com.example.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.entity.CuentaDAO;
import com.example.model.Cuenta;
@Transactional
@Service
public class CuentaServiceImpl implements ICuentaService{

	@Override
	public Cuenta saveCuenta(CuentaDAO Cuenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cuenta> getAllCuenta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cuenta> getCuentaById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Cuenta updateCuenta(CuentaDAO updatedCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCuenta(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
