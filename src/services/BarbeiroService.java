package services;

import entities.Barbeiro;
import java.util.ArrayList;
import java.util.List;

public class BarbeiroService implements CrudService<Barbeiro> {
    private List<Barbeiro> barbeiros = new ArrayList<>();

    @Override
    public void cadastrar(Barbeiro barbeiro) {
        for (Barbeiro b : barbeiros) {
            if (b.getNome().equals(barbeiro.getNome())) {
                throw new IllegalArgumentException("Nome já existente.");
            }
        }
        barbeiros.add(barbeiro);
    }

    @Override
    public List<Barbeiro> listar() {
        return barbeiros;
    }

    @Override
    public void remover(Barbeiro barbeiro) {
        for (Barbeiro b : barbeiros) {
            if (b.getNome().equals(barbeiro.getNome())) {
                barbeiros.remove(b);
                return;
            }
        }
        throw new IllegalArgumentException("Barbeiro não encontrado.");
    }

    @Override
    public Barbeiro buscar(String nome) {
        for (Barbeiro b : barbeiros) {
            if (b.getNome().equals(nome)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Barbeiro não encontrado.");
    }
}
