package br.com.fiap.challenge.bean;

public class Medico {
    private int id;
    private String crm;
    private String nome;
    private String especialidade;

    public Medico() {
    }


    public Medico(int id, String nome, String crm, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    
    public Medico(String nome, String crm, String especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void atualizarEspecialidade(String novaEspecialidade) {
        if (novaEspecialidade != null && !novaEspecialidade.isBlank()) {
            this.especialidade = novaEspecialidade;
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Especialidade: " + especialidade + " | CRM: " + crm;
    }
}
