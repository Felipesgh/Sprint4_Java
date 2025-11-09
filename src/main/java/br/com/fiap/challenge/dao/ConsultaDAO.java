package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.bean.Consulta;
import br.com.fiap.challenge.conexao.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    private Connection minhaConexao;

    public ConsultaDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Consulta consulta) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO CONSULTAS (PACIENTE_NOME, PACIENTE_CPF, MEDICO, ESPECIALIDADE, DATA, HORARIO, PROBLEMA) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)"
        );
        stmt.setString(1, consulta.getPacienteNome());
        stmt.setString(2, consulta.getPacienteCpf());
        stmt.setString(3, consulta.getMedico());
        stmt.setString(4, consulta.getEspecialidade());
        stmt.setString(5, consulta.getData());
        stmt.setString(6, consulta.getHorario());
        stmt.setString(7, consulta.getProblema());

        stmt.execute();
        stmt.close();

        return "Consulta cadastrada com sucesso!";
    }

    public String atualizar(Consulta consulta) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE CONSULTAS SET PACIENTE_NOME=?, PACIENTE_CPF=?, MEDICO=?, ESPECIALIDADE=?, DATA=?, HORARIO=?, PROBLEMA=? WHERE ID=?"
        );
        stmt.setString(1, consulta.getPacienteNome());
        stmt.setString(2, consulta.getPacienteCpf());
        stmt.setString(3, consulta.getMedico());
        stmt.setString(4, consulta.getEspecialidade());
        stmt.setString(5, consulta.getData());
        stmt.setString(6, consulta.getHorario());
        stmt.setString(7, consulta.getProblema());
        stmt.setInt(8, consulta.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Consulta atualizada com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM CONSULTAS WHERE ID=?");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Consulta removida com sucesso!";
    }

    public List<Consulta> selecionar() throws SQLException {
        List<Consulta> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM CONSULTAS ORDER BY DATA, HORARIO");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Consulta c = new Consulta();
            c.setId(rs.getInt("ID"));
            c.setPacienteNome(rs.getString("PACIENTE_NOME"));
            c.setPacienteCpf(rs.getString("PACIENTE_CPF"));
            c.setMedico(rs.getString("MEDICO"));
            c.setEspecialidade(rs.getString("ESPECIALIDADE"));
            c.setData(rs.getString("DATA"));
            c.setHorario(rs.getString("HORARIO"));
            c.setProblema(rs.getString("PROBLEMA"));
            lista.add(c);
        }

        stmt.close();
        return lista;
    }
}
