package services;

import entities.Servico;

import java.util.ArrayList;
import java.util.List;

public class ServicoService implements CrudService<Servico> {
    private List<Servico> servicos = new ArrayList<>();

    @Override
    public void cadastrar(Servico servico) {
        for (Servico s : servicos) {
            if (s.getNome().equals(servico.getNome())) {
                throw new IllegalArgumentException("Serviço já cadastrado.");
            }
        }
        servicos.add(servico);
    }

    @Override
    public List<Servico> listar() {
        return servicos;
    }

    @Override
    public void remover(Servico servico) {
        for (Servico s : servicos) {
            if (s.getNome().equals(servico.getNome())) {
                servicos.remove(s);
                return;
            }
        }
        throw new IllegalArgumentException("Serviço não encontrado.");
    }

    @Override
    public Servico buscar(String nome) {
        for (Servico s : servicos) {
            if (s.getNome().equals(nome)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Serviço não encontrado.");
    }
}