package br.com.fiap.challenge.bean;

public class Setor {
    private int id;
    private String nome;
    private String andar;
    private String responsavel;

    public Setor() {}

    public Setor(int id, String nome, String andar, String responsavel) {
        this.id =id;
        this.nome = nome;
        this.andar = andar;
        this.responsavel = responsavel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Setor: " + nome + " | Andar: " + andar + " | Responsável: " + responsavel;
    }
}
