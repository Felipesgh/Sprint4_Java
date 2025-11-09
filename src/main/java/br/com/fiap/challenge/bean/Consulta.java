package br.com.fiap.challenge.bean;

public class Consulta {

    private int id;
    private String pacienteNome;
    private String pacienteCpf;
    private String medico;
    private String especialidade;
    private String data;
    private String horario;
    private String problema;

    public Consulta() {
    }

    public Consulta(String pacienteNome, String pacienteCpf, String medico, String especialidade, String data, String horario, String problema) {
        this.pacienteNome = pacienteNome;
        this.pacienteCpf = pacienteCpf;
        this.medico = medico;
        this.especialidade = especialidade;
        this.data = data;
        this.horario = horario;
        this.problema = problema;
    }

    
    public Consulta(int id, String pacienteNome, String pacienteCpf, String medico, String especialidade, String data, String horario, String problema) {
        this.id = id;
        this.pacienteNome = pacienteNome;
        this.pacienteCpf = pacienteCpf;
        this.medico = medico;
        this.especialidade = especialidade;
        this.data = data;
        this.horario = horario;
        this.problema = problema;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPacienteNome() { return pacienteNome; }
    public void setPacienteNome(String pacienteNome) { this.pacienteNome = pacienteNome; }

    public String getPacienteCpf() { return pacienteCpf; }
    public void setPacienteCpf(String pacienteCpf) { this.pacienteCpf = pacienteCpf; }

    public String getMedico() { return medico; }
    public void setMedico(String medico) { this.medico = medico; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public String getProblema() { return problema; }
    public void setProblema(String problema) { this.problema = problema; }

    @Override
    public String toString() {
        return String.format("ID: %d | Paciente: %s | Médico: %s | Especialidade: %s | Data: %s | Hora: %s | Problema: %s",
                id, pacienteNome, medico, especialidade, data, horario, problema);
    }
}
