package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.ClienteDAO;
import com.example.model.Cliente;

public interface IClienteService {
	Cliente saveCliente(ClienteDAO clienteDAO);
    List<Cliente> getAllCliente();
    Optional<Cliente> getClienteById(Integer id);
    Cliente updateCliente(ClienteDAO updatedCliente);
    void deleteCliente(Integer id);
}
