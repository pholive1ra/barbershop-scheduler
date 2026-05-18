package entities;
import entities.enums.StatusAgendamento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Agendamento {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private LocalDateTime horario;
    private Barbeiro barbeiro;
    private Servico servico;
    private Cliente cliente;
    private StatusAgendamento status;

    public Agendamento(LocalDateTime horario, Cliente cliente, Servico servico, Barbeiro barbeiro) {
        if (horario == null || horario.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Horário inválido.");
        }
        this.horario = horario;
        this.servico = Objects.requireNonNull(servico, "Serviço inválido.");
        this.barbeiro = Objects.requireNonNull(barbeiro, "Barbeiro inválido.");
        this.cliente = Objects.requireNonNull(cliente, "Cliente inválido.");
        this.status = StatusAgendamento.AGENDADO;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = Objects.requireNonNull(status, "Status inválido.");
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
       this.cliente = Objects.requireNonNull(cliente, "Cliente inválido");
    }

    public Servico getServico() {
        return servico;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = Objects.requireNonNull(barbeiro, "Barbeiro inválido.");
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() +
                "\nBarbeiro: " + barbeiro.getNome() +
                "\nServiço: " + servico.getNome() +
                "\nHorário: " + horario.format(FORMATTER) +
                "\nStatus: " + status;
    }
}