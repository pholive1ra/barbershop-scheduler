package entities;

public class Servico {
    private String nome;
    private int duracao;
    private double preco;

    public Servico(String nome, double preco, int duracao) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        if (preco <= 0 ) {
            throw new IllegalArgumentException("Preço inválido.");
        }
        if (duracao <= 0) {
            throw new IllegalArgumentException("Duração inválida.");
        }
        this.nome = nome;
        this.preco = preco;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
