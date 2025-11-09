package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.bean.Agendamento;
import br.com.fiap.challenge.conexao.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {

    private Connection minhaConexao;

    public AgendamentoDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Agendamento agendamento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO AGENDAMENTOS (DATA_AGENDAMENTO, HORARIO, PACIENTE_CPF, MEDICO_NOME) " +
                        "VALUES (?, ?, ?, ?, ?)"
        );
        stmt.setString(1, agendamento.getData());
        stmt.setString(2, agendamento.getHorario());
        stmt.setString(3, agendamento.getPacienteCpf());
        stmt.setString(4, agendamento.getMedicoNome());

        stmt.execute();
        stmt.close();

        return "Agendamento cadastrado com sucesso!";
    }

    public String atualizar(Agendamento agendamento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE AGENDAMENTOS SET PACIENTE_ID=?, MEDICO_ID=?, DATA_AGENDAMENTO=?, HORARIO=?, STATUS=? WHERE ID=?"
        );
        stmt.setString(1, agendamento.getData());
        stmt.setString(2, agendamento.getHorario());
        stmt.setString(3, agendamento.getPacienteCpf());
        stmt.setString(4, agendamento.getMedicoNome());
        stmt.setInt(6, agendamento.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Agendamento atualizado com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM AGENDAMENTOS WHERE ID=?"
        );
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Agendamento removido com sucesso!";
    }

    public List<Agendamento> selecionar() throws SQLException {
        List<Agendamento> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM AGENDAMENTOS ORDER BY DATA_AGENDAMENTO, HORARIO"
        );
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Agendamento a = new Agendamento();
            a.setId(rs.getInt("ID"));
            a.setPacienteCpf(rs.getString("PACIENTE"));
            a.setMedicoNome(rs.getString("MEDICO"));
            a.setData(rs.getString("DATA_AGENDAMENTO"));
            a.setHorario(rs.getString("HORARIO"));
            lista.add(a);
        }

        stmt.close();
        return lista;
    }
}