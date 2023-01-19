package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Movimiento;

public interface IMovimientoRepo extends JpaRepository<Movimiento, Integer>{

}
