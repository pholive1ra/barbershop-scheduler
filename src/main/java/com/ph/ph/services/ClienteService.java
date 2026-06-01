package com.ph.ph.services;

import com.ph.ph.entities.Cliente;
import com.ph.ph.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void cadastrar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public void remover(Long id) {
        clienteRepository.deleteById(id);
    }
}