package br.com.fiap.challenge.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.challenge.bean.Consulta;
import br.com.fiap.challenge.dao.ConsultaDAO;

public class ConsultaBO {

    ConsultaDAO consultaDAO;

    // Selecionar
    public List<Consulta> selecionarBo() throws ClassNotFoundException, SQLException {
        consultaDAO = new ConsultaDAO();
        // Regras de negócio
        return consultaDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Consulta consulta) throws ClassNotFoundException, SQLException {
        consultaDAO = new ConsultaDAO();
        // Regras de negócio
        consultaDAO.inserir(consulta);
    }

    // Atualizar
    public void atualizarBo(Consulta consulta) throws ClassNotFoundException, SQLException {
        consultaDAO = new ConsultaDAO();
        // Regras de negócio
        consultaDAO.atualizar(consulta);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        consultaDAO = new ConsultaDAO();
        // Regras de negócio
        consultaDAO.deletar(id);
    }
}
