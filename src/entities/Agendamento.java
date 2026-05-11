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
    private String cliente;
    private StatusAgendamento status;

    public Agendamento(LocalDateTime horario, String cliente, Servico servico, Barbeiro barbeiro) {
        if (horario == null || horario.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Horário inválido.");
        }
        this.horario = horario;
        this.servico = Objects.requireNonNull(servico, "Serviço inválido.");
        this.barbeiro = Objects.requireNonNull(barbeiro, "Barbeiro inválido.");
        setCliente(cliente);
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        if (cliente == null || cliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Cliente inválido.");
        }
        this.cliente = cliente.trim();
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
        return "Cliente: " + cliente +
                "\nBarbeiro: " + barbeiro.getNome() +
                "\nServiço: " + servico.getNome() +
                "\nHorário: " + horario.format(FORMATTER) +
                "\nStatus: " + status;
    }
}