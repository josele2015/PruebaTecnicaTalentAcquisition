package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer>{

}
