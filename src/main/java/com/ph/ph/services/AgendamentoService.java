package com.ph.ph.services;

import com.ph.ph.entities.Agendamento;
import com.ph.ph.entities.Barbeiro;
import com.ph.ph.entities.Cliente;
import com.ph.ph.entities.Servico;
import com.ph.ph.entities.enums.StatusAgendamento;
import com.ph.ph.repositories.AgendamentoRepository;
import com.ph.ph.repositories.BarbeiroRepository;
import com.ph.ph.repositories.ClienteRepository;
import com.ph.ph.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    public void agendarHorario(LocalDateTime horario, Long barbeiroId, Long clienteId, Long servicoId) {
        Barbeiro barbeiro = barbeiroRepository.findById(barbeiroId)
                .orElseThrow(() -> new IllegalArgumentException("Barbeiro não encontrado."));
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
        Servico servico = servicoRepository.findById(servicoId)
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado."));

        Agendamento agendamento = new Agendamento(horario, cliente, servico, barbeiro);
        agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listarAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public List<Agendamento> listarPorBarbeiro(Long barbeiroId) {
        return agendamentoRepository.findByBarbeiroId(barbeiroId);
    }

    public void atualizarStatus(Long id, StatusAgendamento novoStatus) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado."));
        agendamento.setStatus(novoStatus);
        agendamentoRepository.save(agendamento);
    }

    public void cancelarAgendamento(Long id) {
        atualizarStatus(id, StatusAgendamento.CANCELADO);
    }
}