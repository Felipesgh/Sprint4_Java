package br.com.fiap.challenge.bean;

public class Prontuario {
    private int id;
    private String pacienteNome;
    private String observacoes;
    private String medicoNome;
    private String cid;

    public Prontuario() {}

    public Prontuario(String pacienteNome, String observacoes, String medicoNome, String cid) {
        this.pacienteNome = pacienteNome;
        this.observacoes = observacoes;
        this.medicoNome = medicoNome;
        this.cid = cid;
    }

    
    public Prontuario(int id, String pacienteNome, String observacoes, String medicoNome, String cid) {
        this.id = id;
        this.pacienteNome = pacienteNome;
        this.observacoes = observacoes;
        this.medicoNome = medicoNome;
        this.cid = cid;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPacienteNome() {
        return pacienteNome;
    }

    public void setPacienteNome(String pacienteNome) {
        this.pacienteNome = pacienteNome;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getMedicoNome() {
        return medicoNome;
    }

    public void setMedicoNome(String medicoNome) {
        this.medicoNome = medicoNome;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Paciente: %s | Médico: %s | CID: %s | Obs: %s",
                id, pacienteNome, medicoNome, cid, observacoes);
    }
}