package com.ph.ph.controller;

import com.ph.ph.dto.ServicoRequest;
import com.ph.ph.entities.Servico;
import com.ph.ph.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public String cadastrar(@RequestBody ServicoRequest request) {
        Servico servico = new Servico(request.nome, request.preco, request.duracao);
        servicoService.cadastrar(servico);
        return "Serviço cadastrado com sucesso!";
    }

    @GetMapping
    public List<Servico> listarServicos() {
        return servicoService.listar();
    }

    @DeleteMapping("/{id}")
    public String deletarServico(@PathVariable Long id) {
        servicoService.remover(id);
        return "Serviço deletado com sucesso!";
    }
}