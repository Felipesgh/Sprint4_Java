package br.com.fiap.challenge.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.challenge.bean.Setor;
import br.com.fiap.challenge.dao.SetorDAO;

public class SetorBO {

    SetorDAO setorDAO;

    // Selecionar
    public List<Setor> selecionarBo() throws ClassNotFoundException, SQLException {
        setorDAO = new SetorDAO();
        // Regras de negócio
        return setorDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Setor setor) throws ClassNotFoundException, SQLException {
        setorDAO = new SetorDAO();
        // Regras de negócio
        setorDAO.inserir(setor);
    }

    // Atualizar
    public void atualizarBo(Setor setor) throws ClassNotFoundException, SQLException {
        setorDAO = new SetorDAO();
        // Regras de negócio
        setorDAO.atualizar(setor);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        setorDAO = new SetorDAO();
        // Regras de negócio
        setorDAO.deletar(id);
    }
}
