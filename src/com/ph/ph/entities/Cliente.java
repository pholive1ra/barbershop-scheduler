package com.ph.ph.entities;

import jakarta.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;

    public Cliente(String nome, String telefone, String email) {
        setNome(nome);
        setTelefone(telefone);
        setEmail(email);
    }

    public Cliente() {}


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty())
            throw new IllegalArgumentException("Telefone inválido.");
        if (!telefone.matches("\\d{10,11}"))
            throw new IllegalArgumentException("Telefone inválido.");
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome +
                "\nTelefone: " + telefone +
                "\nEmail: " + email;
    }

}
