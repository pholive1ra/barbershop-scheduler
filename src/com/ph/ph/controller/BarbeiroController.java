package com.ph.ph.controller;

import com.ph.ph.dto.BarbeiroRequest;
import com.ph.ph.entities.Barbeiro;
import com.ph.ph.services.BarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/barbeiros")
public class BarbeiroController {

    @Autowired
    private BarbeiroService barbeiroService;

    @PostMapping
    public String cadastrar(@RequestBody BarbeiroRequest request) {
        Barbeiro barbeiro = new Barbeiro(request.nome, request.especialidade, request.telefone);
        barbeiroService.cadastrar(barbeiro);
        return "Barbeiro cadastrado com sucesso!";
    }

    @GetMapping
    public List<Barbeiro> listarBarbeiros() {
        return barbeiroService.listar();
    }

    @DeleteMapping("/{id}")
    public String deletarBarbeiro(@PathVariable Long id) {
        barbeiroService.remover(id);
        return "Barbeiro deletado com sucesso!";
    }

    @GetMapping("/{id}/horarios-disponiveis")
    public List<String> horariosDisponiveis(@PathVariable Long id, @RequestParam String data) {
        LocalDate dia = LocalDate.parse(data);
        return barbeiroService.horariosDisponiveis(id, dia);
    }
}