package br.com.fiap.challenge.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.challenge.bean.Agendamento;
import br.com.fiap.challenge.dao.AgendamentoDAO;

public class AgendamentoBO {

    AgendamentoDAO agendamentoDAO;

    // Selecionar
    public List<Agendamento> selecionarBo() throws ClassNotFoundException, SQLException {
        agendamentoDAO = new AgendamentoDAO();
        // Regras de negócio
        return agendamentoDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Agendamento agendamento) throws ClassNotFoundException, SQLException {
        agendamentoDAO = new AgendamentoDAO();
        // Regras de negócio
        agendamentoDAO.inserir(agendamento);
    }

    // Atualizar
    public void atualizarBo(Agendamento agendamento) throws ClassNotFoundException, SQLException {
        agendamentoDAO = new AgendamentoDAO();
        // Regras de negócio
        agendamentoDAO.atualizar(agendamento);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        agendamentoDAO = new AgendamentoDAO();
        // Regras de negócio
        agendamentoDAO.deletar(id);
    }
}