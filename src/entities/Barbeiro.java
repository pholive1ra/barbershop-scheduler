package entities;

public class Barbeiro {
    private String nome;
    private String telefone;
    private String especialidade;

    public Barbeiro(String nome, String especialidade, String telefone) {
      setNome(nome);
      setEspecialidade(especialidade);
      setTelefone(telefone);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
        if(!telefone.matches("\\d+")) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        if(especialidade == null || especialidade.trim().isEmpty()) {
            throw new IllegalArgumentException("Especialidade inválida.");
        }
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
       return "Barbeiro: " + nome +
               "\nEspecialidade: " + especialidade +
               "\nTelefone: " + telefone;
    }
}
