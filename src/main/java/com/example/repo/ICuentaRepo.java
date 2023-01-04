package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Cuenta;

public interface ICuentaRepo extends JpaRepository<Cuenta, Integer>{

}
