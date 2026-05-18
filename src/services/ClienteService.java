package services;

import entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService implements CrudService<Cliente>{
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void cadastrar(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getNome().equals(cliente.getNome()) || c.getTelefone().equals(cliente.getTelefone())) {
                throw new IllegalArgumentException("Cliente já cadastrado.");
            }
        }
        clientes.add(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return clientes;
    }

    @Override
    public void remover(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getNome().equals(cliente.getNome())) {
                clientes.remove(c);
                return;
            }
        }
        throw new IllegalArgumentException("Cliente não encontrado.");
    }

    @Override
    public Cliente buscar(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Cliente não encontrado.");
    }
}
