package br.com.fiap.challenge.bean;

public class Enfermeiro {
    private int id;
    private String nome;
    private String coren;
    private String setor;

    public Enfermeiro() {}

    public Enfermeiro(int id, String nome, String coren, String setor) {
        this.id = id;
        this.nome = nome;
        this.coren = coren;
        this.setor = setor;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCoren() { return coren; }
    public void setCoren(String coren) { this.coren = coren; }

    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }

    @Override
    public String toString() {
        return "Enfermeiro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", coren='" + coren + '\'' +
                ", setor='" + setor + '\'' +
                '}';
    }
}
