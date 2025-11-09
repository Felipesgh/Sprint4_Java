package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.bean.Paciente;
import br.com.fiap.challenge.conexao.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public Connection minhaConexao;

    public PacienteDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Paciente paciente) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO PACIENTES (CPF, NOME, IDADE, PROBLEMA, PRONTUARIO) VALUES (?, ?, ?, ?, ?)"
        );
        stmt.setString(1, paciente.getCpf());
        stmt.setString(2, paciente.getNome());
        stmt.setInt(3, paciente.getIdade());
        stmt.setString(4, paciente.getProblema());
        stmt.setString(5, paciente.getProntuario());

        stmt.execute();
        stmt.close();

        return "Paciente cadastrado com sucesso!";
    }

    public String atualizar(Paciente paciente) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE PACIENTES SET NOME=?, IDADE=?, PROBLEMA=?, PRONTUARIO=? WHERE CPF=?"
        );
        stmt.setString(1, paciente.getNome());
        stmt.setInt(2, paciente.getIdade());
        stmt.setString(3, paciente.getProblema());
        stmt.setString(4, paciente.getProntuario());
        stmt.setString(5, paciente.getCpf());

        stmt.executeUpdate();
        stmt.close();

        return "Paciente atualizado com sucesso!";
    }

    public String deletar(String cpf) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM PACIENTES WHERE CPF=?"
        );
        stmt.setString(1, cpf);

        stmt.execute();
        stmt.close();

        return "Paciente removido com sucesso!";
    }

    public List<Paciente> selecionar() throws SQLException {
        List<Paciente> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM PACIENTES ORDER BY NOME"
        );
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Paciente p = new Paciente();
            p.setCpf(rs.getString("CPF"));
            p.setNome(rs.getString("NOME"));
            p.setIdade(rs.getInt("IDADE"));
            p.setProblema(rs.getString("PROBLEMA"));
            p.setProntuario(rs.getString("PRONTUARIO"));
            lista.add(p);
        }

        stmt.close();
        return lista;
    }
}
