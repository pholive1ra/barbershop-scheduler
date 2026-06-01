package com.ph.ph.controller;

import com.ph.ph.dto.AgendamentoRequest;
import com.ph.ph.dto.AtualizarStatusRequest;
import com.ph.ph.entities.Agendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ph.ph.services.AgendamentoService;
import com.ph.ph.entities.enums.StatusAgendamento;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public String agendarHorario(@RequestBody AgendamentoRequest request) {
        agendamentoService.agendarHorario(request.horario, request.barbeiroId, request.clienteId, request.servicoId);
        return "Agendamento realizado com sucesso!";
    }

    @GetMapping
    public List<Agendamento> listarAgendamentos() {
        return agendamentoService.listarAgendamentos();
    }

    @GetMapping("/barbeiro/{barbeiroId}")
    public List<Agendamento> listarPorBarbeiro(@PathVariable Long barbeiroId) {
        return agendamentoService.listarPorBarbeiro(barbeiroId);
    }

    @DeleteMapping("/{id}")
    public String cancelarAgendamento(@PathVariable Long id) {
        agendamentoService.cancelarAgendamento(id);
        return "Agendamento cancelado com sucesso!";
    }

    @PutMapping("/{id}")
    public String atualizarStatus(@PathVariable Long id, @RequestBody AtualizarStatusRequest request) {
        StatusAgendamento novoStatus = StatusAgendamento.valueOf(request.status.toUpperCase());
        agendamentoService.atualizarStatus(id, novoStatus);
        return "Status atualizado com sucesso!";
    }
}