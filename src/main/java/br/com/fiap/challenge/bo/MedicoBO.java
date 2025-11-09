package br.com.fiap.challenge.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.challenge.bean.Medico;
import br.com.fiap.challenge.dao.MedicoDAO;

public class MedicoBO {

    MedicoDAO medicoDAO;

    // Selecionar
    public List<Medico> selecionarBo() throws ClassNotFoundException, SQLException {
        medicoDAO = new MedicoDAO();
        // Regras de negócio
        return medicoDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Medico medico) throws ClassNotFoundException, SQLException {
        medicoDAO = new MedicoDAO();
        // Regras de negócio
        medicoDAO.inserir(medico);
    }

    // Atualizar
    public void atualizarBo(Medico medico) throws ClassNotFoundException, SQLException {
        medicoDAO = new MedicoDAO();
        // Regras de negócio
        medicoDAO.atualizar(medico);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        medicoDAO = new MedicoDAO();
        // Regras de negócio
        medicoDAO.deletar(id);
    }
}
