package br.com.fiap.challenge.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.challenge.bean.Enfermeiro;
import br.com.fiap.challenge.dao.EnfermeiroDAO;

public class EnfermeiroBO {

    EnfermeiroDAO enfermeiroDAO;

    // Selecionar
    public List<Enfermeiro> selecionarBo() throws ClassNotFoundException, SQLException {
        enfermeiroDAO = new EnfermeiroDAO();
        // Regras de negócio
        return enfermeiroDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Enfermeiro enfermeiro) throws ClassNotFoundException, SQLException {
        enfermeiroDAO = new EnfermeiroDAO();
        // Regras de negócio
        enfermeiroDAO.inserir(enfermeiro);
    }

    // Atualizar
    public void atualizarBo(Enfermeiro enfermeiro) throws ClassNotFoundException, SQLException {
        enfermeiroDAO = new EnfermeiroDAO();
        // Regras de negócio
        enfermeiroDAO.atualizar(enfermeiro);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        enfermeiroDAO = new EnfermeiroDAO();
        // Regras de negócio
        enfermeiroDAO.deletar(id);
    }
}
