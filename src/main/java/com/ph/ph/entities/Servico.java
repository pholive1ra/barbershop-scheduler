package com.ph.ph.entities;

import jakarta.persistence.*;

@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int duracao;
    private double preco;

    public Servico(String nome, double preco, int duracao) {
        setNome(nome);
        setPreco(preco);
        setDuracao(duracao);
    }

    public Servico() {}


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        if (duracao <= 0) {
            throw new IllegalArgumentException("Duração inválida.");
        }
        this.duracao = duracao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço inválido.");
        }
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Serviço: " + nome +
                "\nPreço: " + String.format("%.2f", preco) +
                "\nDuração" + duracao;
    }
}
