package services;

import entities.Barbeiro;
import java.util.ArrayList;
import java.util.List;

public class BarbeiroService {
    private List<Barbeiro> barbeiros = new ArrayList<>();

    public void cadastrarBarbeiro(Barbeiro barbeiro) {
        for (Barbeiro b : barbeiros) {
            if (b.getNome().equals(barbeiro.getNome())) {
                throw new IllegalArgumentException("Nome já existente");
            }
        }
        barbeiros.add(barbeiro);
    }
    public void listarBarbeiros() {
        for(Barbeiro b : barbeiros) {
            System.out.println(b);
        }
    }
    public void removerBarbeiro(Barbeiro barbeiro) {
        for (Barbeiro b : barbeiros) {
            if (b.getNome().equals(barbeiro.getNome())) {
                barbeiros.remove(b);
                return;
            }
        }
        throw new IllegalArgumentException("Barbeiro não encontrado");
    }
    public Barbeiro buscarBarbeiro(String nome) {
        for (Barbeiro b : barbeiros) {
            if (b.getNome().equals(nome)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Barbeiro não encontrado");
    }
}
