package com.ph.ph.repositories;

import com.ph.ph.entities.Agendamento;
import com.ph.ph.entities.enums.StatusAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    boolean existsByBarbeiroIdAndStatus(Long barbeiroId, StatusAgendamento status);
    List<Agendamento> findByBarbeiroId(Long barbeiroId);
    List<Agendamento> findByBarbeiroIdAndHorarioBetweenAndStatus(
            Long barbeiroId,
            LocalDateTime inicio,
            LocalDateTime fim,
            StatusAgendamento status
    );
}