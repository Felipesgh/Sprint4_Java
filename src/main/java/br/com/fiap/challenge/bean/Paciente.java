package br.com.fiap.challenge.bean;

public class Paciente {
    private String cpf;
    private String nome;
    private int idade;
    private String problema;
    private String prontuario;

    public Paciente() {}

    public Paciente(String cpf, String nome, int idade, String problema, String prontuario) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.problema = problema;
        this.prontuario = prontuario;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getProblema() { return problema; }
    public void setProblema(String problema) { this.problema = problema; }

    public String getProntuario() { return prontuario; }
    public void setProntuario(String prontuario) { this.prontuario = prontuario; }

    public void atualizarProblema(String novoProblema) {
        if (novoProblema != null && !novoProblema.isBlank()) {
            this.problema = novoProblema;
        }
    }

    @Override
    public String toString() {
        return "Paciente: " + nome + " | CPF: " + cpf + " | Idade: " + idade + " | Problema: " + problema;
    }
}
