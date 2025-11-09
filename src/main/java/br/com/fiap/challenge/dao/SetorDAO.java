package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.bean.Setor;
import br.com.fiap.challenge.conexao.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SetorDAO {

    private Connection minhaConexao;

    public SetorDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Setor setor) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO SETORES (NOME, ANDAR, RESPONSAVEL) VALUES (?, ?, ?)"
        );
        stmt.setString(1, setor.getNome());
        stmt.setString(2, setor.getAndar());
        stmt.setString(3, setor.getResponsavel());

        stmt.execute();
        stmt.close();

        return "Setor cadastrado com sucesso!";
    }

    public String atualizar(Setor setor) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE SETORES SET NOME=?, ANDAR=?, RESPONSAVEL=? WHERE ID=?"
        );
        stmt.setString(1, setor.getNome());
        stmt.setString(2, setor.getAndar());
        stmt.setString(3, setor.getResponsavel());
        stmt.setInt(4, setor.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Setor atualizado com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM SETORES WHERE ID=?"
        );
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Setor removido com sucesso!";
    }

    public List<Setor> selecionar() throws SQLException {
        List<Setor> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM SETORES ORDER BY NOME"
        );
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Setor s = new Setor();
            s.setId(rs.getInt("ID"));
            s.setNome(rs.getString("NOME"));
            s.setAndar(rs.getString("ANDAR"));
            s.setResponsavel(rs.getString("RESPONSAVEL"));
            lista.add(s);
        }

        stmt.close();
        return lista;
    }
}