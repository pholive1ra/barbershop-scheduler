package com.ph.ph.services;

import com.ph.ph.entities.Agendamento;
import com.ph.ph.entities.Barbeiro;
import com.ph.ph.entities.enums.StatusAgendamento;
import com.ph.ph.repositories.AgendamentoRepository;
import com.ph.ph.repositories.BarbeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BarbeiroService {

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public void cadastrar(Barbeiro barbeiro) {
        barbeiroRepository.save(barbeiro);
    }

    public List<Barbeiro> listar() {
        return barbeiroRepository.findAll();
    }

    public void remover(Long id) {
        if (agendamentoRepository.existsByBarbeiroIdAndStatus(id, StatusAgendamento.AGENDADO)) {
            throw new IllegalArgumentException("Barbeiro possui agendamentos pendentes e não pode ser removido.");
        }
        barbeiroRepository.deleteById(id);
    }

    public List<String> horariosDisponiveis(Long barbeiroId, LocalDate data) {
        LocalDateTime inicio = data.atTime(LocalTime.of(9, 0));
        LocalDateTime fim = data.atTime(LocalTime.of(17, 0));

        List<Agendamento> agendados = agendamentoRepository
                .findByBarbeiroIdAndHorarioBetweenAndStatus(barbeiroId, inicio, fim, StatusAgendamento.AGENDADO);

        List<LocalDateTime> ocupados = agendados.stream()
                .map(Agendamento::getHorario)
                .toList();

        List<String> disponiveis = new ArrayList<>();
        LocalDateTime horario = inicio;

        while (horario.isBefore(fim)) {
            if (!ocupados.contains(horario)) {
                disponiveis.add(horario.toLocalTime().toString());
            }
            horario = horario.plusMinutes(30);
        }

        return disponiveis;
    }
}