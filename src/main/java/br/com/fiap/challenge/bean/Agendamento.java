package br.com.fiap.challenge.bean;

public class Agendamento {
    private int id;
    private String data;
    private String horario;
    private String pacienteCpf;
    private String medicoNome;

    public Agendamento() {
    }

    public Agendamento(int id, String data, String horario, String pacienteCpf, String medicoNome) {
        this.id = id;
        this.data = data;
        this.horario = horario;
        this.pacienteCpf = pacienteCpf;
        this.medicoNome = medicoNome;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public String getPacienteCpf() { return pacienteCpf; }
    public void setPacienteCpf(String pacienteCpf) { this.pacienteCpf = pacienteCpf; }

    public String getMedicoNome() { return medicoNome; }
    public void setMedicoNome(String medicoNome) { this.medicoNome = medicoNome; }

    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", horario='" + horario + '\'' +
                ", pacienteCpf='" + pacienteCpf + '\'' +
                ", medicoNome='" + medicoNome + '\'' +
                '}';
    }
}