package services;

import entities.Servico;

import java.util.ArrayList;
import java.util.List;

public class ServicoService {
    private List<Servico> servicos = new ArrayList<>();

    public void cadastrarServico(Servico servico) {
        for (Servico s : servicos) {
            if (s.getNome().equals(servico.getNome())) {
                throw new IllegalArgumentException("Serviço já cadastrado");
            }
        }
        servicos.add(servico);
    }

    public void listarServicos() {
        for (Servico s : servicos) {
            System.out.println(s);
        }
    }

    public void removerServico(Servico servico) {
        for (Servico s : servicos) {
            if (s.getNome().equals(servico.getNome())) {
                servicos.remove(s);
                return;
            }
        }
        throw new IllegalArgumentException("Serviço não encontrado");
    }

    public Servico buscarServico(String nome) {
        for (Servico s : servicos) {
            if (s.getNome().equals(nome)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Serviço não encontrado");
    }
}