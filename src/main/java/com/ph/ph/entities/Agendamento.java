package com.ph.ph.entities;
import com.ph.ph.entities.enums.StatusAgendamento;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private LocalDateTime horario;

    @ManyToOne(cascade = CascadeType.ALL)
    private Barbeiro barbeiro;
    @ManyToOne(cascade = CascadeType.ALL)
    private Servico servico;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente cliente;
    @Enumerated(EnumType.STRING)
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

    public Agendamento() {}

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

    public Long getId() {
        return id;
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