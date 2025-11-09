package br.com.fiap.challenge.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.challenge.bean.Paciente;
import br.com.fiap.challenge.dao.PacienteDAO;

public class PacienteBO {

    PacienteDAO pacienteDAO;

    // Selecionar
    public List<Paciente> selecionarBo() throws ClassNotFoundException, SQLException {
        pacienteDAO = new PacienteDAO();
        // Regras de negócio
        return pacienteDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Paciente paciente) throws ClassNotFoundException, SQLException {
        pacienteDAO = new PacienteDAO();
        // Regras de negócio
        pacienteDAO.inserir(paciente);
    }

    // Atualizar
    public void atualizarBo(Paciente paciente) throws ClassNotFoundException, SQLException {
        pacienteDAO = new PacienteDAO();
        // Regras de negócio
        pacienteDAO.atualizar(paciente);
    }

    // Deletar
    public void deletarBo(String cpf) throws ClassNotFoundException, SQLException {
        pacienteDAO = new PacienteDAO();
        // Regras de negócio
        pacienteDAO.deletar(cpf);
    }
}
