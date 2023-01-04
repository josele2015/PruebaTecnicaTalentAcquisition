package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Entidad;

public interface IEntidadRepo extends JpaRepository<Entidad, Integer>{

}
