package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.bean.Medico;
import br.com.fiap.challenge.conexao.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    private Connection minhaConexao;

    public MedicoDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Medico medico) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO MEDICOS (NOME, CRM, ESPECIALIDADE) VALUES (?, ?, ?)"
        );
        stmt.setString(1, medico.getNome());
        stmt.setString(2, medico.getCrm());
        stmt.setString(3, medico.getEspecialidade());
        stmt.execute();
        stmt.close();
        return "Médico cadastrado com sucesso!";
    }

    public String atualizar(Medico medico) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE MEDICOS SET NOME=?, CRM=?, ESPECIALIDADE=? WHERE ID=?"
        );
        stmt.setString(1, medico.getNome());
        stmt.setString(2, medico.getCrm());
        stmt.setString(3, medico.getEspecialidade());
        stmt.setInt(4, medico.getId());
        stmt.executeUpdate();
        stmt.close();
        return "Médico atualizado com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM MEDICOS WHERE ID=?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Médico removido com sucesso!";
    }

    public List<Medico> selecionar() throws SQLException {
        List<Medico> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM MEDICOS ORDER BY NOME");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Medico m = new Medico();
            m.setId(rs.getInt("ID"));
            m.setNome(rs.getString("NOME"));
            m.setCrm(rs.getString("CRM"));
            m.setEspecialidade(rs.getString("ESPECIALIDADE"));
            lista.add(m);
        }

        stmt.close();
        return lista;
    }
}
