package com.ph.ph.controller;

import com.ph.ph.dto.ClienteRequest;
import com.ph.ph.entities.Cliente;
import com.ph.ph.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public String cadastrar(@RequestBody ClienteRequest request) {
        Cliente cliente = new Cliente(request.nome, request.telefone, request.email);
        clienteService.cadastrar(cliente);
        return "Cliente cadastrado com sucesso!";
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listar();
    }

    @DeleteMapping("/{id}")
    public String deletarCliente(@PathVariable Long id) {
        clienteService.remover(id);
        return "Cliente deletado com sucesso!";
    }
}