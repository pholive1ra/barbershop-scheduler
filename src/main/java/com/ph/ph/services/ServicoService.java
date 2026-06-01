package com.ph.ph.services;

import com.ph.ph.entities.Servico;
import com.ph.ph.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicoService  {

    @Autowired
    private ServicoRepository servicoRepository;

    public void cadastrar(Servico servico) {
        servicoRepository.save(servico);
    }

    public List<Servico> listar() {
        return servicoRepository.findAll();
    }

    public void remover(Long id) {
        servicoRepository.deleteById(id);
    }
}