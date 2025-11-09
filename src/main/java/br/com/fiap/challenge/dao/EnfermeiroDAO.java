package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.bean.Enfermeiro;
import br.com.fiap.challenge.conexao.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnfermeiroDAO {

    private Connection minhaConexao;

    public EnfermeiroDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Enfermeiro enfermeiro) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO ENFERMEIROS (NOME, COREN, SETOR) VALUES (?, ?, ?)"
        );
        stmt.setString(1, enfermeiro.getNome());
        stmt.setString(2, enfermeiro.getCoren());
        stmt.setString(3, enfermeiro.getSetor());

        stmt.execute();
        stmt.close();

        return "Enfermeiro cadastrado com sucesso!";
    }

    public String atualizar(Enfermeiro enfermeiro) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE ENFERMEIROS SET NOME=?, COREN=?, SETOR=? WHERE ID=?"
        );
        stmt.setString(1, enfermeiro.getNome());
        stmt.setString(2, enfermeiro.getCoren());
        stmt.setString(3, enfermeiro.getSetor());
        stmt.setInt(4, enfermeiro.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Enfermeiro atualizado com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM ENFERMEIROS WHERE ID=?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Enfermeiro removido com sucesso!";
    }

    public List<Enfermeiro> selecionar() throws SQLException {
        List<Enfermeiro> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM ENFERMEIROS ORDER BY NOME");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Enfermeiro e = new Enfermeiro();
            e.setId(rs.getInt("ID"));
            e.setNome(rs.getString("NOME"));
            e.setCoren(rs.getString("COREN"));
            e.setSetor(rs.getString("SETOR"));
            lista.add(e);
        }

        stmt.close();
        return lista;
    }
}
