package services;

import entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getNome().equals(cliente.getNome()) || c.getTelefone().equals(cliente.getTelefone())) {
                throw new IllegalArgumentException("Cliente já cadastrado");
            }
        }
        clientes.add(cliente);
    }

    public void listarClientes() {
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    public void removerCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getNome().equals(cliente.getNome())) {
                clientes.remove(c);
                return;
            }
        }
        throw new IllegalArgumentException("Cliente não encontrado");
    }

    public Cliente buscarCliente(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Cliente não encontrado");
    }
}
