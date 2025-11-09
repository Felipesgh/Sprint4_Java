package br.com.fiap.challenge.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.challenge.bean.Prontuario;
import br.com.fiap.challenge.dao.ProntuarioDAO;

public class ProntuarioBO {

    ProntuarioDAO prontuarioDAO;

    // Selecionar
    public List<Prontuario> selecionarBo() throws ClassNotFoundException, SQLException {
        prontuarioDAO = new ProntuarioDAO();
        // Regras de negócio
        return prontuarioDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Prontuario prontuario) throws ClassNotFoundException, SQLException {
        prontuarioDAO = new ProntuarioDAO();
        // Regras de negócio
        prontuarioDAO.inserir(prontuario);
    }

    // Atualizar
    public void atualizarBo(Prontuario prontuario) throws ClassNotFoundException, SQLException {
        prontuarioDAO = new ProntuarioDAO();
        // Regras de negócio
        prontuarioDAO.atualizar(prontuario);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        prontuarioDAO = new ProntuarioDAO();
        // Regras de negócio
        prontuarioDAO.deletar(id);
    }
}
