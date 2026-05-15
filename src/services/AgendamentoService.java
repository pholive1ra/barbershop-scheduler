package services;

import entities.Agendamento;
import enums.StatusAgendamento;

import java.util.ArrayList;
import java.util.List;

public class AgendamentoService {
    private List<Agendamento> agendamentos = new ArrayList<>();

    public void agendarHorario(Agendamento agendamento) {
        for (Agendamento a : agendamentos) {
            if (    a.getStatus() != StatusAgendamento.CANCELADO
                    &&
                    a.getHorario().equals(agendamento.getHorario())
                    &&
                    a.getBarbeiro().equals(agendamento.getBarbeiro())) {
                throw new IllegalArgumentException("Horário indisponível");
            }
        }
        agendamentos.add(agendamento);
    }
    public void listarAgendamentos() {
        for(Agendamento a : agendamentos) {
            if (a.getStatus() != StatusAgendamento.CANCELADO) { //Exibir so agendamentos ativos
                System.out.println(a);
            }
        }
    }
    public void cancelarAgendamento(Agendamento agendamento) {
        for(Agendamento a : agendamentos) {
            if (a.getHorario().equals(agendamento.getHorario()) && a.getBarbeiro().equals(agendamento.getBarbeiro())) {
                a.setStatus(StatusAgendamento.CANCELADO);
                return;
            }
        }
        throw new IllegalArgumentException("Agendamento não encontrado");
    }
}

