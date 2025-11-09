package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.bean.Prontuario;
import br.com.fiap.challenge.conexao.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO {

    private Connection minhaConexao;

    public ProntuarioDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Prontuario prontuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO PRONTUARIOS (PACIENTE_ID, DESCRICAO, MEDICO_NOME, CID) " +
                        "VALUES (?, ?, ?, ?, ?)"
        );
        stmt.setString(1, prontuario.getPacienteNome());
        stmt.setString(2, prontuario.getObservacoes());
        stmt.setString(3, prontuario.getMedicoNome());
        stmt.setString(4, prontuario.getCid());

        stmt.execute();
        stmt.close();

        return "Prontuário cadastrado com sucesso!";
    }

    public String atualizar(Prontuario prontuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE PRONTUARIOS SET PACIENTE_ID=?, DESCRICAO=?, DATA_REGISTRO=?, MEDICO_NOME=?, CID=? WHERE ID=?"
        );
        stmt.setString(1, prontuario.getPacienteNome());
        stmt.setString(2, prontuario.getObservacoes());
        stmt.setString(3, prontuario.getMedicoNome());
        stmt.setString(4, prontuario.getCid());

        stmt.executeUpdate();
        stmt.close();

        return "Prontuário atualizado com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM PRONTUARIOS WHERE ID=?"
        );
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Prontuário removido com sucesso!";
    }

    public List<Prontuario> selecionar() throws SQLException {
        List<Prontuario> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM PRONTUARIOS ORDER BY DATA_REGISTRO DESC"
        );
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Prontuario p = new Prontuario();
            p.setPacienteNome(rs.getString("NOME"));
            p.setObservacoes(rs.getString("DESCRICAO"));
            p.setMedicoNome(rs.getString("MEDICO_NOME"));
            p.setCid(rs.getString("CID"));
            lista.add(p);
        }

        stmt.close();
        return lista;
    }
}